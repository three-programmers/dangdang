package com.jk.service;

import java.util.List;

import com.jk.entity.UserAllOrders;

public interface UserAllOrdersService {
	List<UserAllOrders> showUserAllOrders(Integer id,Integer fromRecord);
	Integer totalCount(Integer id);
}
