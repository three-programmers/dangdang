package com.jk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jk.entity.Book;
import com.jk.entity.Category;
import com.jk.service.BookService;
import com.jk.service.CategoryService;
import com.jk.util.PageUtil;

@Controller
@RequestMapping("book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private CategoryService categoryService;
	@RequestMapping("hot")
	public String showHotBooks(ModelMap modelMap) throws Exception{
		List<Book> hotBooks = bookService.showHotBook();
		modelMap.addAttribute("hotBooks", hotBooks);
		return "/main/hot";
	}
	@RequestMapping("recommend")
	public String showRecommendBook(ModelMap modelMap) throws Exception{
		List<Book> recommendBook = bookService.showRecommendBook();
		modelMap.addAttribute("recommendBook", recommendBook);
		return "/main/recommend";
	}
	@RequestMapping("recommendByPage")
	public String showRecommendBookByPage(Integer pageIndex,ModelMap modelMap) throws Exception{
		Integer recommendCount = bookService.showRecommendCount();
		//判断是否无记录
		if(recommendCount == 0){
			pageIndex = 0;
			modelMap.addAttribute("pageIndex",pageIndex);
			modelMap.addAttribute("pageCount",0);
			return "/main/book_list";
		}
		PageUtil page = new PageUtil(pageIndex, 3,recommendCount);
		Integer pageCount = page.getPageCount();
		Integer fromRecord = page.fromRecord();
		List<Book> pageRecommendBook = bookService.showRecommendBookByPage(fromRecord);
		modelMap.addAttribute("books", pageRecommendBook);
		modelMap.addAttribute("pageCount",pageCount);
		modelMap.addAttribute("pageIndex",pageIndex);
		return "/main/book_list";
	}
	@RequestMapping("showBook")
	public String showBook(Integer id,ModelMap modelMap) throws Exception{
		Book book = bookService.showBookById(id);
		id = book.getCategoryId();
		List<Category> category = categoryService.showChildCategoryById(id);
		modelMap.addAttribute("category",category);
		modelMap.addAttribute("book",book);
		return "/main/product";
	}
	@RequestMapping("newBoooks")
	public String showNewBooks(ModelMap modelMap) throws Exception{
		List<Book> newShelfBooks = bookService.showNewShelfBooks();
		modelMap.addAttribute("newShelfBooks", newShelfBooks);
		return "/main/new";
	}
	@RequestMapping("newHotBooks")
	public String showNewHootBooks(ModelMap modelMap) throws Exception{
		List<Book> newHotBooks = bookService.showNewShelfHot();
		modelMap.addAttribute("newHotBooks", newHotBooks);
		return "/main/hotBoard";
	}
}
 