package com.jk.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jk.entity.Address;
import com.jk.entity.Order;
import com.jk.entity.OrderItem;
import com.jk.entity.User;
import com.jk.service.BookService;
import com.jk.service.OrderItemService;

@Controller
@RequestMapping("/order")
public class OrderController {
	Map<Integer, Integer> map;
	@Autowired
	private OrderItemService orderItemService;
	@Autowired
	private BookService bookService;

	// 结算订单
	@RequestMapping("/item")
	public String item(HttpSession session, Address address, ModelMap modelMap)
			throws Exception {
		User user = new User();
		Order order = new Order();
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		map = (Map<Integer, Integer>) session.getAttribute("cart");
		user = (User) session.getAttribute("user");
		if (map == null) {
			return "redirect:/cart/showCart.do";
		}
		if (user == null) {
			return "redirect:/cart/checkLogin.do";
		}
		double totalPrice = 0;
		for (Integer id : map.keySet()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setBookId(id);
			orderItem.setAmount(map.get(id));
			double price = bookService.showBookById(id).getDangPrice();
			totalPrice += map.get(id) * price;
			orderItem.setBuyPrice(price);
			orderItemList.add(orderItem);
		}
		order.setOrderTime(new Date());
		order.setUserId(address.getUserId());
		order.setTotalPrice(totalPrice);
		order.setState("1");
		orderItemService.addOrderItem(address, order, orderItemList);
		modelMap.addAttribute("orderId", order.getOrderId());
		modelMap.addAttribute("totalPrice", totalPrice);
		session.removeAttribute("cart");
		return "/order/order_ok";

	}
}
