<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>
	<span class="more"><a href="#" target="_blank"></a> </span>最新上架图书
</h2>
<div class="book_c_04">

	<!--热销图书A开始-->
	<c:forEach var="new" items="${requestScope.newShelfBooks}">
	<div class="second_d_wai">
		<div class="img">
			<a href="#" target='_blank'><img
					src="../productImages/${new.imgPath}" border=0 /> </a>
		</div>
		<div class="shuming">
			<a href="#" target="_blank">${new.name}</a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			<h4>上架</h4>
			<h4>时间：${new.shelfTime}</h4>
		</div>
		<div class="price">
			当当价：￥${new.dangPrice}
		</div>
	</div>
	</c:forEach>
	<div class="book_c_xy_long"></div>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>