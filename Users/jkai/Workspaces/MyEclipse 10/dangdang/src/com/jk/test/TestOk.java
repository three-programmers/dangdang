package com.jk.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.jk.dao.UserDAO;
import com.jk.entity.User;
import com.jk.service.UserService;
import com.jk.util.JedisUtil;

public class TestOk {

	@Test
	public void testDao() {
//		User user = new User();
//		user.setId(1);
//		user.setName("jk");
//		user.setEmail("jkai@thunisoft.com");
//		user.setPassword("123456");
		ApplicationContext context = new FileSystemXmlApplicationContext(
			    "classpath:/applicationContext.xml");
		UserDAO userDao = (UserDAO)context.getBean("userDAO");
		User user = userDao.queryUserByEmail("1154735587@qq.com");
		System.out.println(user);
	}
	@Test
	public void testService(){
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:/applicationContext.xml");
		UserService userservice = (UserService)context.getBean("userServiceImpl");
		System.out.println(userservice);
	}
	@Test
	public void testRedis(){
		JedisUtil.getJedis().set("name", "suns");
	}

}
