package com.jk.dao;

import org.apache.ibatis.annotations.Param;

import com.jk.entity.Address;

public interface AddressDAO {
	void insertAddress(@Param("address")Address address);
}
