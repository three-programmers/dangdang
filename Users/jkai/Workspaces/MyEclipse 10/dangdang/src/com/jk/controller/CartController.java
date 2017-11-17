package com.jk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.entity.Book;
import com.jk.entity.User;
import com.jk.service.BookService;


@Controller
@RequestMapping("/cart")
public class CartController {
	Map<Integer,Integer> map;
	Map<Integer,Integer> delMap;
	@Autowired
	private BookService bookService;
	/*
	    显示订单信息，取出购物车和删除商品的session，分别遍历map，
	    查询图书信息，并分别放入到List中。 
	*/
	@RequestMapping("/showCart")	
	public String showCart(HttpSession session,ModelMap modelMap) throws Exception{
		int totalPrice = 0;
		int savePrice = 0;
		List<Book> books = new ArrayList<Book>();
		List<Book> delBooks = new ArrayList<Book>();
		map = (Map<Integer,Integer>)session.getAttribute("cart");
		delMap = (Map<Integer,Integer>)session.getAttribute("delCart");
		if(map != null){
			for(Integer id : map.keySet()){
				Book book = bookService.showBookById(id);
				totalPrice += book.getDangPrice()*map.get(id);
				savePrice += (book.getPrice()-book.getDangPrice())*map.get(id);
				book.setQuantity(map.get(id));
				books.add(book);
			}
		}
		if(delMap != null){
			for(Integer id : delMap.keySet()){
				Book delBook = bookService.showBookById(id);
				delBook.setQuantity(delMap.get(id));
				delBooks.add(delBook);
			}
		}
		modelMap.addAttribute("bookCart",books);
		modelMap.addAttribute("delBookCart",delBooks);
		modelMap.addAttribute("totalPrice",totalPrice);
		modelMap.addAttribute("savePrice",savePrice);
		return "/cart/cart_list";
	}
	//加入购物车
	@RequestMapping("/addCart")
	public @ResponseBody boolean addCart(HttpSession session,Integer id) throws Exception{
		try{
			Thread.sleep(1000);
			map = (Map<Integer,Integer>)session.getAttribute("cart");
			//判断是否第一次加入购物车
			if(map == null){
				map = new HashMap<Integer,Integer>();
				map.put(id, 1);
			}else{
				if(map.containsKey(id)){
					Integer count = map.get(id);
					map.put(id, count+1);
				}else{
					map.put(id,1);
				}
			}
			session.setAttribute("cart", map);
			return true;
		}catch(Exception e){
			return false;
		}	
	}
	//删除商品
	@RequestMapping("/delCart")
	public String delCart(HttpSession session,ModelMap modelMap,Integer id) throws Exception{
			map = (Map<Integer,Integer>)session.getAttribute("cart");
			delMap = (Map<Integer,Integer>)session.getAttribute("delCart");
			if(map == null){
				map = new HashMap<Integer, Integer>();
			}
			if(delMap == null){
				delMap = new HashMap<Integer, Integer>();
			}
			//判断刷新页面再次请求时，map中是否已经包括该id，包括则在map中删除
			if(map.containsKey(id)){
				delMap.put(id, map.get(id));
				map.remove(id);	
			}
			session.setAttribute("delCart", delMap);
			showCart(session, modelMap);
			return "/cart/cart_list";
	}
	//恢复商品
	@RequestMapping("/restoreCart")
	public String restoreCart(HttpSession session,ModelMap modelMap,Integer id) throws Exception{
		delMap = (Map<Integer,Integer>)session.getAttribute("delCart");
		map = (Map<Integer,Integer>)session.getAttribute("cart");
		if(map == null){
			map = new HashMap<Integer, Integer>();
		}
		if(delMap == null){
			delMap = new HashMap<Integer, Integer>();
		}
		//判断刷新页面再次请求时，map中是否已经包括该id，不包括插入，包括则不插入
		if(!map.containsKey(id)){
			map.put(id,delMap.get(id));
			delMap.remove(id);
		}
		showCart(session, modelMap);
		return "/cart/cart_list";
	}
	//修改数量
	@RequestMapping("/changeCount")
	public String changeCount(HttpSession session,ModelMap modelMap,Integer id,Integer count) throws Exception{
		map = (Map<Integer,Integer>)session.getAttribute("cart");
		delMap = (Map<Integer,Integer>)session.getAttribute("delCart");
		if(map == null){
			map = new HashMap<Integer, Integer>();
		}
		if(delMap == null){
			delMap = new HashMap<Integer, Integer>();
		}
		if(count == 0 && map.containsKey(id)){
			Integer originalCount = map.get(id);
			delMap.put(id,originalCount);
			map.remove(id);
		}else if(map.containsKey(id)){
			map.put(id, count);
		}
		session.setAttribute("delCart", delMap);
		showCart(session, modelMap);
		return "/cart/cart_list";
	}
	//结算
	@RequestMapping("/check")
	public String check(ModelMap modelMap,HttpSession session) throws Exception{
		map = (Map<Integer,Integer>)session.getAttribute("cart");
		if(map == null){
			map = new HashMap<Integer, Integer>();
		}
		Integer num = 1;
		Double totalPrice = 0.0;
		List<Book> buyBook = new ArrayList<Book>();
		for (Integer id : map.keySet()) {
			Book book = bookService.showBookById(id);
			book.setQuantity(map.get(id));
			book.setBuyNum(num++);
			buyBook.add(book);
			totalPrice += book.getDangPrice()*map.get(id);
		}
		modelMap.addAttribute("buyBook",buyBook);
		modelMap.addAttribute("totalPrice",totalPrice);
		return "/order/order_info";
	}
	//判断用户是否登录
	@RequestMapping("/checkLogin")
	public String checkLogin(HttpSession session) throws Exception{
		User user = (User)session.getAttribute("user");
		map = (Map<Integer,Integer>)session.getAttribute("cart");
		//判断购物车的session是否到期
		if(map == null){
			return "forward:/cart/showCart.do";
		}
		if(user == null){
			return "/user/login_form";
		}else{
			return "/order/address_form";
		}
	}	
}
