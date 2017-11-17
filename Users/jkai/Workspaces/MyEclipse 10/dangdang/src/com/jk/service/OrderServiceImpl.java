package com.jk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jk.dao.OrderDAO;
import com.jk.entity.Address;
import com.jk.entity.Order;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDAO orderDAO;
	@Override
	@Transactional(propagation=Propagation.NESTED)
	public void addOrder(Address address,Order order) {
		Integer addressId = address.getAddressId();
		address.setAddressId(addressId);
		orderDAO.insertOrder(order);
	}
}
