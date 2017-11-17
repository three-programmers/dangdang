package com.jk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jk.dao.UserAllOrdersDAO;
import com.jk.entity.UserAllOrders;
@Service
@Transactional
public class UserAllOrdersServicesImpl implements UserAllOrdersService {
	@Autowired
	UserAllOrdersDAO userAllOrdersDAO;
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<UserAllOrders> showUserAllOrders(Integer id,Integer fromRecord) {
		return userAllOrdersDAO.selectUserOrders(id,fromRecord);
	}
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public Integer totalCount(Integer id) {
		return userAllOrdersDAO.selectOrderCount(id);
	}
	

}
