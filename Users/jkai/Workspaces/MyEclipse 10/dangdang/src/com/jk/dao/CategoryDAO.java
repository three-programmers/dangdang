package com.jk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jk.entity.Category;

public interface CategoryDAO {
	List<Category> selectFirstCategory();
	List<Category> selectAllCategory();
	List<Category> selectFirstCategoryById(@Param("id")Integer id);
	List<Category> selectChildCategoryById(@Param("id")Integer id);
 }
