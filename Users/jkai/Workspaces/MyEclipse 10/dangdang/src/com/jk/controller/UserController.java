package com.jk.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.entity.User;
import com.jk.entity.UserAllOrders;
import com.jk.service.UserAllOrdersService;
import com.jk.service.UserService;
import com.jk.util.PageUtil;

@Controller
@RequestMapping("/user")
public class UserController{
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserAllOrdersService userAllOrdersService;

	@RequestMapping("register")
	public String userRegister(ModelMap modelMap,User user,String flag,HttpSession session) throws Exception{
		if(user.getName() != null && (userService.checkEmail(user.getEmail())==null)){
			modelMap.addAttribute("user",user);
			String registerPassword = user.getPassword();	
			//对密码进行md5加密
			String md5Password = DigestUtils.md5Hex(registerPassword);
			user.setPassword(md5Password);			
			userService.register(user);
			login(modelMap, flag, session, user.getEmail(), registerPassword);
		}
		return "register_ok";
	}
	@RequestMapping("checkEmail")
	public @ResponseBody boolean checkEmailIsRepeat(String email) throws Exception{
		Thread.sleep(1500);
		User user = userService.checkEmail(email);
		if(user == null){
			return true;
		}else{
			return false;
		}
	}
	@RequestMapping("login")
	public @ResponseBody String login(ModelMap modelMap,String flag,HttpSession session,String email,String password) throws Exception{
		//先对用户输入的密码做md5再与数据库密码比较
		String md5InputPassword = DigestUtils.md5Hex(password);
		User user = userService.login(email, md5InputPassword);
		if(flag != null){
			if(user != null){
				modelMap.addAttribute("user", user);
				session.setAttribute("user",user);
				return "trueBuy";
			}else{
				return "falseLogin";
			}
		}else{
			if(user != null){
				modelMap.addAttribute("user", user);
				session.setAttribute("user",user);
				return "trueLogin";
			}else{
				return "falseLogin";
			}
		}		
	}
	
	/*
	      注意使用SessionAttribute注解，SpringMVC就会自动将@SessionAttributes定义的属性注入到 ModelMap对象，
	      只要我们不去调用SessionStatus的setComplete()方法，这个对象就会一直保留在 Session 中。
	*/
	@RequestMapping("logout")
	public String logout(HttpSession session) throws Exception{
		session.removeAttribute("user");
		return "/main/main";
	}
	@RequestMapping("showOrders")
	public String showOrders(HttpSession session,ModelMap modelMap,Integer pageIndex) throws Exception{
		User user = (User)session.getAttribute("user");
		if(user == null){
			return "/user/login_form";
		}
		//分页
		Integer totalCount = userAllOrdersService.totalCount(user.getId());
		//判断是否无记录
		if(totalCount == 0){
			pageIndex = 0;
			modelMap.addAttribute("pageIndex",pageIndex);
			modelMap.addAttribute("pageCount",0);
			return "/main/my_dangdang";
		}
		PageUtil pageUtil = new PageUtil(pageIndex, 4, totalCount);
		Integer pageCount = pageUtil.getPageCount();
		Integer fromRecord = pageUtil.fromRecord();
		//将订单号相同的商品，放到Map中 
		Map<Integer,Object> map = new TreeMap<Integer,Object>();
		List<UserAllOrders> allOrders = userAllOrdersService.showUserAllOrders(user.getId(),fromRecord);
		List<UserAllOrders> sameOrderId;
		for(int i = 0;i < allOrders.size();i++){
			if(!map.containsKey(allOrders.get(i).getOrderId())){
				sameOrderId = new ArrayList<UserAllOrders>();
				sameOrderId.add(allOrders.get(i));
				map.put(allOrders.get(i).getOrderId(), sameOrderId);
			}else{
				sameOrderId = (List)map.get(allOrders.get(i).getOrderId());
				sameOrderId.add(allOrders.get(i));
				map.put(allOrders.get(i).getOrderId(), sameOrderId);
			}
		}
		modelMap.addAttribute("allOrders", map);
		modelMap.addAttribute("pageCount",pageCount);
		modelMap.addAttribute("pageIndex",pageIndex);
		return "/main/my_dangdang";
	}
	
}
