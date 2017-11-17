package com.jk.dao;

import org.apache.ibatis.annotations.Param;

import com.jk.entity.Order;

public interface OrderDAO {
	void insertOrder(@Param("order") Order order);
}
