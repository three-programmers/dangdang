package com.jk.service;

import java.util.List;

import com.jk.entity.Category;

public interface CategoryService {
	List<Category> showFirstCategory();
	List<Category> showAllCategory();
	List<Category> showFirstCategoryById(Integer id);
	List<Category> showChildCategoryById(Integer id);
}
