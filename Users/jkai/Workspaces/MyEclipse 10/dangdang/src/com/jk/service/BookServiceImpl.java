package com.jk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jk.dao.BookDAO;
import com.jk.entity.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDAO;
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<Book> showHotBook() {
		return bookDAO.selectBookBySalesVolume();
	}
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<Book> showRecommendBook() {
		return bookDAO.selectBookByIsRecommend();
	}
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<Book> showRecommendBookByPage(Integer fromRecord) {
		return bookDAO.selectRecommendBookByPage(fromRecord);
	}
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<Book> showNewShelfBooks() {
		return bookDAO.selectNewShelfBooks();
	}
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<Book> showNewShelfHot() {
		return bookDAO.selectNewShelfHot();
	}
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public Integer showRecommendCount() {
		return bookDAO.selectRecommendCount();
	}
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<Book> showBookByCategoryId(Integer id) {
		return bookDAO.selectBookByCategoryId(id);
	}
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public Book showBookById(Integer id) {
		return bookDAO.selectBookById(id);
	}
	@Override
	@Transactional(propagation=Propagation.NESTED)
	public void updateSaleVolume(Integer id, Integer count) {
		bookDAO.updateSaleVolume(id, count);
	}
	
}
