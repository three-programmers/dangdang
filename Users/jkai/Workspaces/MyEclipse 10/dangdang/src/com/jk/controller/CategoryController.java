package com.jk.controller;

import java.util.ArrayList;
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
@RequestMapping("category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BookService bookService;
	@RequestMapping("show")
	public String showAllCategory(ModelMap modelMap) throws Exception{
		List<Category> firstCategory = categoryService.showFirstCategory();
		List<Category> allCategory = categoryService.showAllCategory();
		modelMap.addAttribute("firstCategory", firstCategory);
		modelMap.addAttribute("allCategory", allCategory);
		return "/main/category";
	}
	@RequestMapping("idCategory")
	public String showFirstCategoryById(ModelMap modelMap,Integer id) throws Exception{
		List<Category> category = categoryService.showFirstCategoryById(id);
		modelMap.addAttribute("category",category);
		return "/main/book_list";
	}
	@RequestMapping("bookCategory")
	public String showBookByCategoryId(ModelMap modelMap,Integer cid,Integer pid,Integer pageIndex,Integer type) throws Exception{
		List<Category> category = new ArrayList<Category>();
		List<Book> books = new ArrayList<Book>();
		List<Book> bookByPage;
		Integer pageCount;
		Integer count = 0;
		if(type == 1){	//一级目录
			category = categoryService.showFirstCategoryById(pid);
			modelMap.addAttribute("category",category);
		}else if(type == 2){	//二级目录
			category = categoryService.showChildCategoryById(cid);
			modelMap.addAttribute("category",category);
		}
		//将取出的各个分类图书，放到一个新的List并且根据页号返回相应数据
		for(int i = 0;i < category.size();i++){
			Integer id = category.get(i).getId();
			List<Book> book = bookService.showBookByCategoryId(id);
			for(int j = 0;j < book.size();j++){
				books.add(book.get(j));
			}
			count += category.get(i).getCount();
		}
		if(pageIndex*3 > count){
			bookByPage = books.subList((pageIndex-1)*3, count);
		}
		else{
			bookByPage = books.subList((pageIndex-1)*3, pageIndex*3);
		}	
		if(count != 0){
			pageCount = new PageUtil(pageIndex,3,count).getPageCount();
		}else{
			pageIndex = 0;
			pageCount = 0;
		}
		modelMap.addAttribute("books", bookByPage);
		modelMap.addAttribute("category",category);
		modelMap.addAttribute("pageIndex",pageIndex);
		modelMap.addAttribute("pageCount",pageCount);
		modelMap.addAttribute("type",type);
		modelMap.addAttribute("count",count);	
		return "/main/category_book_list";
	}
}
