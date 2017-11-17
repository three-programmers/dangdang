package com.jk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jk.entity.Book;

public interface BookDAO {
	List<Book> selectBookBySalesVolume();// 按销量查询
	List<Book> selectBookByIsRecommend();// 查询编辑推荐
	List<Book> selectRecommendBookByPage(@Param("fromRecord") Integer fromRecord);// 编辑推荐“更多”查询
	List<Book> selectNewShelfBooks();// 查询最新上架图书
	List<Book> selectNewShelfHot(); // 查询新书热卖榜
	List<Book> selectBookByCategoryId(@Param("id")Integer id);
	Book selectBookById(@Param("id")Integer id);
	Integer selectRecommendCount();
	void updateSaleVolume(@Param("id") Integer id,@Param("count") Integer count);
}
