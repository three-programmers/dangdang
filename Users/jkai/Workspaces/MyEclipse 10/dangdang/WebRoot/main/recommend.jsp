<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>
	<span class="more"><a href="../book/recommendByPage.do?pageIndex=1" target="_blank">更多&gt;&gt;</a> </span>编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	
	<div class=second_c_02>
		<c:forEach var="recommend" items="${requestScope.recommendBook}" begin="0" end="1">
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href='../book/showBook.do?id=${recommend.id}' target='_blank'><img src="../productImages/${recommend.imgPath}" width=70 border=0 /> </a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='../book/showBook.do?id=${recommend.id}' target='_blank' title='书名'>${recommend.name}</a>
				</h3>
				<h4>
					作者：${recommend.author} 著
					<br />
					出版社：${recommend.publish}&nbsp;&nbsp;&nbsp;&nbsp;出版时间：${recommend.publicationTime}
				</h4>
				<h5>
					${recommend.contentValidity}
				</h5>
				<h6>
					定价：￥${recommend.price}&nbsp;&nbsp;当当价：￥${recommend.dangPrice}
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
		</c:forEach>		
	</div>
</div>
