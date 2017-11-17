package com.jk.service;

import java.util.List;

import com.jk.entity.Address;
import com.jk.entity.Order;
import com.jk.entity.OrderItem;

public interface OrderItemService {
	void addOrderItem(Address address,Order order,List<OrderItem> orderItem);
}
