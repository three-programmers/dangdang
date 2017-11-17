package com.jk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jk.dao.OrderItemDAO;
import com.jk.entity.Address;
import com.jk.entity.Order;
import com.jk.entity.OrderItem;
@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {
	@Autowired
	private OrderItemDAO orderItemDAO;
	@Autowired
	private AddressService addressService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private BookService bookService;
	@Override
	public void addOrderItem(Address address,Order order,List<OrderItem> orderItem) {
		addressService.addAddress(address);
		Integer addressId = address.getAddressId();
		order.setAddressId(addressId);
		orderService.addOrder(address,order);
		Integer orderId = order.getOrderId();
		for(int i = 0;i < orderItem.size();i++){
			bookService.updateSaleVolume(orderItem.get(i).getBookId(), orderItem.get(i).getAmount());
			orderItem.get(i).setOrderId(orderId);
			orderItemDAO.insertOrderItem(orderItem.get(i));
		}
	}

}
