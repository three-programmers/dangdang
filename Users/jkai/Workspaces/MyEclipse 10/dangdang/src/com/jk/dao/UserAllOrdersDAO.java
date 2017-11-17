package com.jk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jk.entity.UserAllOrders;

public interface UserAllOrdersDAO {
	List<UserAllOrders> selectUserOrders(@Param("id") Integer id,@Param("fromRecord") Integer fromRecord);
	Integer selectOrderCount(@Param("id") Integer id);
}
