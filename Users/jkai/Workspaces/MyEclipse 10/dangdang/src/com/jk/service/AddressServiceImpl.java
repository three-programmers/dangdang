package com.jk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jk.dao.AddressDAO;
import com.jk.entity.Address;
@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDAO addressDAO;
	@Override
	@Transactional(propagation=Propagation.NESTED)
	public void addAddress(Address address) {
		addressDAO.insertAddress(address);
	}
}
