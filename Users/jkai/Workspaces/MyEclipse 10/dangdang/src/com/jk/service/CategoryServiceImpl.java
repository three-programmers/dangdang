package com.jk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jk.dao.CategoryDAO;
import com.jk.entity.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<Category> showFirstCategory() {
		return categoryDAO.selectFirstCategory();
	}
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<Category> showAllCategory() {
		return categoryDAO.selectAllCategory();
	}
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<Category> showFirstCategoryById(Integer id) {
		return categoryDAO.selectFirstCategoryById(id);
	}
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<Category> showChildCategoryById(Integer id) {
		return categoryDAO.selectChildCategoryById(id);
	}
}
