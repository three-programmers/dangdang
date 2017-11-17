<%@page contentType="text/html;charset=utf-8"  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<h2 class="t_xsrm">
			新书热卖榜
		</h2>
		<div id="NewProduct_1_o_t" onmouseover="">
<ul>
	<c:forEach var="new" items="${requestScope.newHotBooks}" begin="0" end="0">
	<h3><img src="../images/book_no0_1.gif"><a target='_blank' href="../book/showBook.do?id=${new.id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${new.name}</a></h3>
	</c:forEach>
	<c:forEach var="new" items="${requestScope.newHotBooks}" begin="1" end="1">
	<h3><img src="../images/book_no0_2.gif"><a target='_blank' href="../book/showBook.do?id=${new.id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${new.name}</a></h3>
	</c:forEach>
	<c:forEach var="new" items="${requestScope.newHotBooks}" begin="2" end="2">
	<h3><img src="../images/book_no0_3.gif"><a target='_blank' href="../book/showBook.do?id=${new.id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${new.name}</a></h3>
	</c:forEach>
</ul>
	<h3 class="second">
		<span class="dot_r"> </span><a href="#" target="_blank"></a>
	</h3>
</div>