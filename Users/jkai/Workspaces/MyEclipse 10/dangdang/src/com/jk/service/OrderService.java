package com.jk.service;

import com.jk.entity.Address;
import com.jk.entity.Order;

public interface OrderService {
	void addOrder(Address address,Order order);
}
