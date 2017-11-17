<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
		<script type="text/javascript">
		$(function(){
			var currentPage = $("#currentPage").text();
			var totalPage = $("#totalPage").text();
			//判断最后一页
			if(currentPage == totalPage && totalPage != 1 && totalPage != 0){
				$("#down1").html("<img src='../images/page_down_gray.gif' id='downimg1'/>");
				$("#down2").html("<img src='../images/page_down_gray.gif' id='downimg2'/>");
				$("#up1").html("<a name=link_page_next href='../user/showOrders.do?pageIndex=1'>"+"<img src='../images/page_up.gif' id='upimg1'/>");
				$("#up2").html("<a name=link_page_next href='../user/showOrders.do?pageIndex="+(parseInt(currentPage)-1)+"'>"+"<img src='../images/page_up.gif' id='upimg2'/>");		
			}else if((currentPage == 1 && totalPage == 1) || (currentPage == 0 && totalPage == 0)){	//判断是否只有一页,或者数据为空
				$("#down1").html("<img src='../images/page_down_gray.gif' id='downimg1'/>");
				$("#down2").html("<img src='../images/page_down_gray.gif' id='downimg2'/>");
				$("#up1").html("<img src='../images/page_up_gray.gif' id='upimg1'/>");
				$("#up2").html("<img src='../images/page_up_gray.gif' id='upimg2'/>");
			}else if(currentPage == 1||currentPage == null){
			
			}else{	
				$("#up1").html("<a name=link_page_next href='../user/showOrders.do?pageIndex=1'>"+"<img src='../images/page_up.gif' id='upimg1'/>");
				$("#up2").html("<a name=link_page_next href='../user/showOrders.do?pageIndex="+(parseInt(currentPage)-1)+"'>"+"<img src='../images/page_up.gif' id='upimg2'/>");
			}
			//点击下一页事件
			$("#nextpage").click(function(){
				$("#nextpage").attr("href","../user/showOrders.do?pageIndex="+(parseInt(currentPage)+1));			
			});
		});
		</script>
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
			<font style='color: #cc3300'><strong>我的当当</strong> </font>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							菜单
						</h2>
						<ul>							
							<div class="clear"></div>
							
							<!--2级分类开始-->		
							<li>
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei>
										<a href="../user/showOrders.do?pageIndex=1">全部订单&nbsp;</a>
									</div>
								</div>
							</li>
							<div class="clear"></div>
							<li>
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei>
										<a href="#">个人信息&nbsp;</a>
									</div>
								</div>
							</li>
						    <div class="clear"></div>
						    
							<!--2级分类结束-->
							
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--订单列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							所有订单
						</div>
						
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
							
							<div class='list_r_title_text3a' id="down1">
								<a name=link_page_next
									href="../user/showOrders.do?pageIndex=${requestScope.pageIndex}" id="nextpage">
									<img src='../images/page_down.gif' id="downimg1"/> </a>
							</div>
			
							<div class='list_r_title_text3a' id="down2">
								<a name=link_page_next href="../user/showOrders.do?pageIndex=${requestScope.pageCount}" id="nextpage">
								<img src='../images/page_down.gif' id="downimg2"/></a>
							</div>

							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
						
						<div class="list_r_line"></div>
						<div class="clear"></div>
						<c:forEach var="map" items="${requestScope.allOrders}">
						<c:forEach var="allOrders" items="${map.value}" begin="0" end="0">
						<div class="list_r_list">
							<span class="list_r_list_book"><a name="link_prd_img" href='../book/showBook.do?id=${allOrders.bookId}'>
								<img src="../productImages/${allOrders.imgPath}"/></a></span>
							<h2>
								下单日期：${allOrders.orderTime}&nbsp;&nbsp;&nbsp;
								订单号:${allOrders.orderId}&nbsp;&nbsp;&nbsp;
								总价格：${allOrders.totalPrice}						
							</h2>
							<h4 class="list_r_list_h4">
								<a name="link_prd_name" href='../book/showBook.do?id=${allOrders.bookId}'>${allOrders.bookName}</a>
								<input type="hidden" id="bookId" value="${allOrders.bookId}"/>
							</h4>
							<h4>
								单价:￥${allOrders.buyPrice}		
							</h4>
							<h4>
								数量：${allOrders.amount}			
							</h4>
								
							<div class="clear"></div>			
						</div>
						</c:forEach>
						<c:forEach var="allOrders" items="${map.value}" begin="1">
						<div class="list_r_list">
							<span class="list_r_list_book"><a name="link_prd_img" href='../book/showBook.do?id=${allOrders.bookId}'>
								<img src="../productImages/${allOrders.imgPath}"/></a></span>
							<h2>					
							</h2>
							<h4 class="list_r_list_h4">
								<a name="link_prd_name" href='../book/showBook.do?id=${allOrders.bookId}'>${allOrders.bookName}</a>
								<input type="hidden" id="bookId" value="${allOrders.bookId}"/>
							</h4>
							<h4>
								单价:￥${allOrders.buyPrice}		
							</h4>
							<h4>
								数量：${allOrders.amount}			
							</h4>
								
							<div class="clear"></div>			
						</div>
						</c:forEach>
						</c:forEach>
						<div class="clear"></div>
						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--订单列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
