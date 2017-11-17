<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>
	<span class="more"><a href="#" target="_blank"></a> </span>热销图书
</h2>
<div class="book_c_04">

	<!--热销图书A开始-->
	<c:forEach var="hot" items="${requestScope.hotBooks}">
	<div class="second_d_wai">
		<div class="img">
			<a href="../book/showBook.do?id=${hot.id}" target='_blank'><img
					src="../productImages/${hot.imgPath}" border=0 /> </a>
		</div>
		<div class="shuming">
			<a href="../book/showBook.do?id=${hot.id}" target="_blank">${hot.name}</a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥${hot.price}
		</div>
		<div class="price">
			当当价：￥${hot.dangPrice}
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	</c:forEach>
	<!--热销图书A结束-->
	
	
</div>
<div class="clear"></div>