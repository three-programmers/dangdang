<%@page contentType="text/html;charset=utf-8"  pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
	<div class="login_success">
		<div class="login_bj">
				<h5>
					系统错误。请单击这里返回<a href="<c:url value="http://127.0.0.1:8989/dangdang/main/main.jsp"/>">首页</a>
				</h5>
 	 	</div>
	</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

