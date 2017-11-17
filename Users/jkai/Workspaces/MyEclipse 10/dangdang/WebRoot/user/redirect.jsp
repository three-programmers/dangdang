<%@page contentType="text/html;charset=utf-8"  pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
		<script type="text/javascript">		
			$(function(){
				timer();
			});
			var time = 5;
			function timer(){
				$("#secondSpan").text(time);
				if(time == 0){
					window.location.href="<c:url value='http://127.0.0.1:8989/dangdang/order/address_form.jsp'/>";
				}	
				setTimeout("timer()",1000);
				time -= 1;			
			};
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
	<div class="login_success">
		<div class="login_bj">
				<h5>
					<img src="../images/label3.gif" width="20" height="20" align="absmiddle" />&nbsp;${sessionScope.user.name} 您好，您已经成功登录
				</h5>
				<h6> &nbsp;&nbsp;</h6>
				<h6>页面在<span id="secondSpan"></span>秒后将转到送货地址填写页面。如果转入失败，请单击<a href="<c:url value='http://127.0.0.1:8989/dangdang/order/address_form.jsp'/>">这里</a>。</h6>
 	 	</div>
	</div>

		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

