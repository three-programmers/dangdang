package com.jk.dao;

import org.apache.ibatis.annotations.Param;

import com.jk.entity.OrderItem;

public interface OrderItemDAO {
	void insertOrderItem(@Param("orderItem") OrderItem orderItem);
}
