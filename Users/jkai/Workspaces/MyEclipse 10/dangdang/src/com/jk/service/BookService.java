package com.jk.service;

import java.util.List;

import com.jk.entity.Book;

public interface BookService {
	List<Book> showHotBook();
	List<Book> showRecommendBook();
	List<Book> showRecommendBookByPage(Integer fromRecord);
	List<Book> showNewShelfBooks();
	List<Book> showNewShelfHot();
	Integer showRecommendCount();
	List<Book> showBookByCategoryId(Integer id);
	Book showBookById(Integer id);
	void updateSaleVolume(Integer id,Integer count);
}
 