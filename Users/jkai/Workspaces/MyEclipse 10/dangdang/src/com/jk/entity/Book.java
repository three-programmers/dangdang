package com.jk.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer categoryId;
	private String name;
	private String author;
	private Integer stock;
	private double price;
	private double dangPrice;
	private Date publicationTime;//出版时间
	private Date shelfTime;
	private String isRecommand;//是否编辑推荐
	private String state;
	private String publish;
	private Integer edition;//版次
	private Date printDate;
	private Integer printCount;//印次
	private String ISBN;
	private Integer wordCount;
	private Integer pageCount;
	private String style;
	private String paper;
	private String pack;//包装
	private Integer salesVolume;//销量
	private String editorChoice;//编辑推荐
	private String contentValidity;//内容简介
	private String authorIntroduction;//作者简介
	private String catalog;
	private String imgPath;//图片路径
	private Integer quantity;//购买数量
	private Integer buyNum;//购买序号
	private Category category;
	private List<OrderItem> orderItem;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDangPrice() {
		return dangPrice;
	}
	public void setDangPrice(double dangPrice) {
		this.dangPrice = dangPrice;
	}
	public Date getPublicationTime() {
		return publicationTime;
	}
	public void setPublicationTime(Date publicationTime) {
		this.publicationTime = publicationTime;
	}
	public Date getShelfTime() {
		return shelfTime;
	}
	public void setShelfTime(Date shelfTime) {
		this.shelfTime = shelfTime;
	}
	public String getIsRecommand() {
		return isRecommand;
	}
	public void setIsRecommand(String isRecommand) {
		this.isRecommand = isRecommand;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public Integer getEdition() {
		return edition;
	}
	public void setEdition(Integer edition) {
		this.edition = edition;
	}
	public Date getPrintDate() {
		return printDate;
	}
	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}
	public Integer getPrintCount() {
		return printCount;
	}
	public void setPrintCount(Integer printCount) {
		this.printCount = printCount;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public Integer getWordCount() {
		return wordCount;
	}
	public void setWordCount(Integer wordCount) {
		this.wordCount = wordCount;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getPaper() {
		return paper;
	}
	public void setPaper(String paper) {
		this.paper = paper;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public Integer getSalesVolume() {
		return salesVolume;
	}
	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}
	public String getEditorChoice() {
		return editorChoice;
	}
	public void setEditorChoice(String editorChoice) {
		this.editorChoice = editorChoice;
	}
	public String getContentValidity() {
		return contentValidity;
	}
	public void setContentValidity(String contentValidity) {
		this.contentValidity = contentValidity;
	}
	public String getAuthorIntroduction() {
		return authorIntroduction;
	}
	public void setAuthorIntroduction(String authorIntroduction) {
		this.authorIntroduction = authorIntroduction;
	}
	public String getCatalog() {
		return catalog;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
}
