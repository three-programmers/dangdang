<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="../js/category_book_list.js"></script>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/list.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="../main/main.jsp"><img src="../images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='../main/main.jsp'>当当图书</a> &gt;&gt;
			<c:forEach var="firstCategory" items="${requestScope.category}" begin="0" end="0">							
			<a href='../category/bookCategory.do?pid=${firstCategory.parentId}&pageIndex=1&type=1'><font style='color: #cc3300'><strong>${firstCategory.parentName}</strong></font></a>
			<c:if test="${requestScope.type == 2}">
			&gt;&gt;<font style='color: #cc3300'><strong>${firstCategory.name}</strong></font>
			</c:if>
			</c:forEach>
		</div>

		<div class="book">
			<!-- 判断是否从一级分类跳转 -->
			<c:if test="${requestScope.type=='1'}">
			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<div class=second_fenlei>
										&middot;<c:forEach var="firstCategory" items="${requestScope.category}" begin="0" end="0">
										${firstCategory.parentName}&nbsp;(${requestScope.count})
										</c:forEach>
									</div>
								</div>
							</li>
							<div class="clear"></div>
							
							<!--2级分类开始-->
							<c:forEach var="secondcategory" items="${requestScope.category}">
							<li>
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei>
										<a href="../category/bookCategory.do?cid=${secondcategory.id}&pageIndex=1&type=2">
										${secondcategory.name}&nbsp;(${secondcategory.count})</a>
									</div>
								</div>
							</li>
						    <div class="clear"></div>
						    </c:forEach>
							<!--2级分类结束-->	
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
				</c:if>
				<!-- 判断是否从二级分类跳转 -->
				<c:if test="${requestScope.type=='2'}">
			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<div class=second_fenlei>
										&middot;<c:forEach var="firstCategory" items="${requestScope.category}" begin="0" end="0">
										${firstCategory.name}&nbsp;(${firstCategory.count})
										</c:forEach>
									</div>
								</div>
							</li>
							<div class="clear"></div>
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
				</c:if>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							
							<div class='list_r_title_text3a' id="up1">
								<img src='../images/page_up_gray.gif' id="upimg1"/> </a>
							</div>
	
							<div class='list_r_title_text3a' id="up2">
								<img src='../images/page_up_gray.gif' id="upimg2"/>
							</div>
				
							<div class='list_r_title_text3b'>
								第<span id="currentPage">${requestScope.pageIndex}</span>页/共<span id="totalPage">${requestScope.pageCount}</span>页
							</div>
							<c:if test="${requestScope.type=='1'}">	
							<c:forEach var="category" items="${requestScope.category}" begin="0" end="0">	
							<div class='list_r_title_text3a' id="down1">		  	
								<input type="hidden" id="categoryId" value="${category.id}"/>		
								<input type="hidden" id="parentId" value="${category.parentId}"/>
								<input type="hidden" id="type" value="${requestScope.type}"/>		
									<a name=link_page_next
									href="../category/bookCategory.do?pid=${category.parentId}&pageIndex=${requestScope.pageIndex}&type=${requestScope.type}" id="nextpage">
									<img src='../images/page_down.gif' id="downimg1"/> </a>		
							</div>
							<div class='list_r_title_text3a' id="down2">
								<a name=link_page_next href="../category/bookCategory.do?pid=${category.parentId}&pageIndex=${requestScope.pageCount}&type=${requestScope.type}" id="nextpage">
								<img src='../images/page_down.gif' id="downimg2"/></a>
							</div>
							</c:forEach>
							</c:if>
							<c:if test="${requestScope.type=='2'}">	
							<c:forEach var="category" items="${requestScope.category}" begin="0" end="0">	
							<div class='list_r_title_text3a' id="down1">		
								<input type="hidden" id="categoryId" value="${category.id}"/>
								<input type="hidden" id="parentId" value="${category.parentId}"/>
								<input type="hidden" id="type" value="${requestScope.type}"/>			
									<a name=link_page_next
									href="../category/bookCategory.do?cid=${category.id}&pageIndex=${requestScope.pageIndex}&type=${requestScope.type}" id="nextpage">
									<img src='../images/page_down.gif' id="downimg1"/> </a>		
							</div>
							<div class='list_r_title_text3a' id="down2">
								<a name=link_page_next href="../category/bookCategory.do?cid=${category.id}&pageIndex=${requestScope.pageCount}&type=${requestScope.type}" id="nextpage">
								<img src='../images/page_down.gif' id="downimg2"/></a>
							</div>
							</c:forEach>
							</c:if>
							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->		
						<div class="list_r_line"></div>
						<div class="clear"></div>
						<c:forEach var="book" items="${requestScope.books}">
						<div class="list_r_list">
							<span class="list_r_list_book"><a name="link_prd_img" href='../book/showBook.do?id=${book.id}'>
								<img src="../productImages/${book.imgPath}" /> </a> </span>
							<h2>
								<a name="link_prd_name" href='../book/showBook.do?id=${book.id}'>${book.name}</a>
							</h2>		
							<h4 class="list_r_list_h4">
								作 者:${book.author}				
							</h4>
							<h4>
								出版社：${book.publish}			
							</h4>
							<h4>
								出版时间：${book.publicationTime}
							</h4>
							<h5>
								${book.contentValidity}
							</h5>
							<div class="clear"></div>
							<h6>
								<span class="del">￥${book.price}</span>
								<span class="red">￥${book.dangPrice}</span>
								节省：￥${book.price-book.dangPrice}
							</h6>
							<span class="list_r_list_button"></span>	
							<img class="addCart" src="../images/buttom_goumai.gif" onclick="add(this,${book.id})"/>
							<span id="cartinfo_${book.id}"></span>
						</div>
						</c:forEach>
						<div class="clear"></div>
						<!--商品条目结束-->
					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>
				</div>
				<!--图书列表结束-->
			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
