<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML>
<HEAD>
<TITLE>${requestScope.book.name} - 图书 - 当当网</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="../product_files/dangdang.css" type=text/css rel=Stylesheet>
<LINK href="../product_files/book.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function move(img){
		$(img).css("cursor","pointer");
	}
	function addCart(id){
		$.ajax({
			url:"../cart/addCart.do",
			data:"id="+id,
			dataType:"json",
			beforeSend:function(){
				$(".goumai").html('<img align="bottom" src="../images/load.gif" width="14" height="14" style="display:inline" align="bottom"/>&nbsp;购买中...');
			},
			success:function(result){
				if(result == true){
					$(".goumai").html("添加成功").fadeOut(1000,function(){
						$(".goumai").css("display","block");
						$(".goumai").html('<IMG id="buy" src="../images/buttom_goumai.gif" onclick="addCart(${requestScope.book.id})" onmouseover="move(this)">');
					});
				}else{
					$(".goumai").html("添加失败").fadeOut(1000,function(){
						$(".goumai").css("display","block").html('<IMG id="buy" src="../images/buttom_goumai.gif" onclick="addCart(${requestScope.book.id})">');
					});
				}
			}
		});
	}
</script>
</HEAD>
<BODY>

	<DIV id=tag_box style="DISPLAY: none; Z-INDEX: 10; POSITION: absolute"></DIV>
	<DIV id=div_shield></DIV>
	<DIV id=main>
		<DIV class=mainsearch></DIV>
		<DIV class=wrap>
			<!--left start-->
			<!--left end-->
			<DIV class=right>
				<DIV class=right_wai>
					<DIV class=shuming>
						<DIV class=shuming_left>
							<SPAN class=black000><A name=top_bk></A> ${requestScope.book.name}
								</SPAN>
						</DIV>
						<DIV class=book_case>
							<SPAN class=seriesname>丛书名：${requestScope.book.name}</SPAN>
						</DIV>
						<DIV class=empty_box></DIV>
					</DIV>
					<DIV class=book_left>
						<DIV class=book_pic>
							<A
								href="javascript:ImgBtnChgPrd_Click(this,'http://img39.ddimg.cn/93/5/20867709-1_o.jpg')"
								name=bigpicture_bk><IMG id=img_show_prd
								src="../productImages/${requestScope.book.imgPath}">
							</A>
						</DIV>
						<INPUT id=hid_largepictureurl type=hidden>
					</DIV>
					<DIV class=book_right>
						   <DIV id=author_>作 者：${requestScope.book.author}</DIV>
						<DIV id=publisher_>出 版 社：${requestScope.book.publish} </DIV>
						<UL>
							<LI>出版时间： ${requestScope.book.publicationTime}</LI>
							<LI>字 数：${requestScope.book.wordCount} </LI>
							<LI>版 次：${requestScope.book.edition} </LI>
							<LI>页 数：${requestScope.book.pageCount} </LI>
							<LI>印刷时间： ${requestScope.book.printDate} </LI>
							<LI>开 本：${requestScope.book.style} </LI>
							<LI>印 次：${requestScope.book.printCount} </LI>
							<LI>纸 张：${requestScope.book.paper}</LI>
							<LI>I S B N :${requestScope.book.ISBN} </LI>
							<LI>包 装：${requestScope.book.pack}</LI>
						</UL>
						<DIV id=__categroy_bk>
							所属分类：
								<c:forEach var="category" items="${requestScope.category}">
								<A class=blue12a
								href="../main/main.jsp"
								target=_blank>图书</A> &gt;&gt; <A class=blue12a
								href="../category/bookCategory.do?pid=${category.parentId}&pageIndex=1&type=1"
								target=_blank>${category.parentName}</A> &gt;&gt; <A class=blue12a
								href="../category/bookCategory.do?cid=${category.id}&pageIndex=1&type=${category.type}"
								target=_blank>${category.name}</A> 
								</c:forEach>
						</DIV>
						<DIV class=jiage>
							<SPAN class=gray87>定价：<SPAN class=del id=originalPriceTag>￥${requestScope.book.price}</SPAN>
							</SPAN> <SPAN class=redc30>当当价：￥${requestScope.book.dangPrice}<B></B>
							</SPAN> 节省：￥${requestScope.book.price-requestScope.book.dangPrice}
							<DIV class=pd_buy_num>
								<DIV class=clear></DIV>
							</DIV>
								<DIV class="goumai">
									<IMG id="buy" src="../images/buttom_goumai.gif" onclick="addCart(${requestScope.book.id})" onmouseover="move(this)">
									<span id="product_"></span>				
								</DIV>
						</DIV>
					</DIV>
					<DIV id=dvTPUrls></DIV>
					<DIV id=__zhinengbiaozhu_bk>
						<DIV class=dashed></DIV>
						<H2 class=black14>
							<IMG src="../product_files/bg_point1.gif" align=absMiddle>
							编辑推荐
						</H2>
						<DIV class=zhengwen>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							${requestScope.book.editorChoice}
						</DIV>
						<DIV class=dashed></DIV>
						<H2 class=black14>
							<IMG src="../product_files/bg_point1.gif" align=absMiddle>
							内容简介
						</H2>
						<DIV class=zhengwen>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							${requestScope.book.contentValidity}
						</DIV>
						<DIV class=dashed></DIV>
						<H2 class=black14>
							<IMG src="../product_files/bg_point1.gif" align=absMiddle>
							作者简介
						</H2>
						<DIV class=zhengwen>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							${requestScope.book.authorIntroduction}
						</DIV>
						<DIV class=dashed></DIV>
						<H2 class=black14>
							<IMG src="../product_files/bg_point1.gif" align=absMiddle>
							目录
						</H2>
						<DIV class=zhengwen>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							${requestScope.book.catalog}
						</DIV>
						<DIV class=dashed></DIV>
						<H2 class=black14>
							<IMG src="../product_files/bg_point1.gif" align=absMiddle>
							媒体评论
						</H2>
						<DIV class=zhengwen></DIV>
						<DIV class=dashed></DIV>
						<H2 class=black14>
							<IMG src="../product_files/bg_point1.gif" align=absMiddle>
							书摘插图
						</H2>
						<DIV class=zhengwen>
							
						</DIV>
					</DIV>
					<A name=review_point></A>
				</DIV>
			</DIV>
			<DIV id=tag_box style="DISPLAY: none; Z-INDEX: 2; POSITION: absolute"></DIV>
			<DIV id=tag_box_pay
				style="DISPLAY: none; Z-INDEX: 2; POSITION: absolute"></DIV>
			<DIV id=div_shield></DIV>
			<!--页尾 开始 -->
			<DIV class=public_footer_add_s></DIV>
			<!--09.3.10new-->
			<!--页尾 end -->
			<!--页尾开始 -->
			<%@include file="../common/foot.jsp"%>
			<!--页尾结束 -->
</BODY>
</HTML>
