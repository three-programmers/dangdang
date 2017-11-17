	
	$(function(){
		var currentPage = $("#currentPage").text();
		var totalPage = $("#totalPage").text();
		//判断最后一页
		if(currentPage == totalPage && totalPage != 1 && totalPage != 0){
			$("#down1").html("<img src='../images/page_down_gray.gif' id='downimg1'/>");
			$("#down2").html("<img src='../images/page_down_gray.gif' id='downimg2'/>");
			$("#up1").html("<a name=link_page_next href='../book/recommendByPage.do?pageIndex=1'>"+"<img src='../images/page_up.gif' id='upimg1'/>");
			$("#up2").html("<a name=link_page_next href='../book/recommendByPage.do?pageIndex="+(parseInt(currentPage)-1)+"'>"+"<img src='../images/page_up.gif' id='upimg2'/>");
		}else if((currentPage == 1 && totalPage == 1) || (currentPage == 0 && totalPage == 0)){	//判断是否只有一页,或者数据为空		
			$("#down1").html("<img src='../images/page_down_gray.gif' id='downimg1'/>");
			$("#down2").html("<img src='../images/page_down_gray.gif' id='downimg2'/>");
			$("#up1").html("<img src='../images/page_up_gray.gif' id='upimg1'/>");
			$("#up2").html("<img src='../images/page_up_gray.gif' id='upimg2'/>");
		}else if(currentPage == 1){
		
		}else{
			$("#up1").html("<a name=link_page_next href='../book/recommendByPage.do?pageIndex=1'>"+"<img src='../images/page_up.gif' id='upimg1'/>");
			$("#up2").html("<a name=link_page_next href='../book/recommendByPage.do?pageIndex="+(parseInt(currentPage)-1)+"'>"+"<img src='../images/page_up.gif' id='upimg2'/>");
		}
		//点击下一页事件
		$("#nextpage").click(function(){
			$("#nextpage").attr("href","../book/recommendByPage.do?pageIndex="+(parseInt(currentPage)+1));
		});
		//购买按钮鼠标移入事件
		$(".addCart").hover().css("cursor","pointer");
	});
	
	
	//加入购物车,点击“购买”按钮，传入当前点击的img对象和商品id
	function add(img,id){
		$.ajax({
			url:"../cart/addCart.do",
			type:"POST",
			dataType:"json",
			data:"id="+id,
			beforeSend:function(XMLHttpRequest){
				$(img).css("visibility","hidden");
				$("#cartinfo_"+id).css("display","inline");
				$("#cartinfo_"+id).html('<img align="bottom" src="../images/load.gif" width="14" height="14" style="display:inline" align="bottom"/>&nbsp;购买中...');
			},
			success:function(result){
				if(result == true){
					$("#cartinfo_"+id).text("添加成功").fadeOut(1000,function(){
						$(img).css("visibility","visible");
					});
					
				}else{
					$("#cartinfo_"+id).text("添加失败").fadeOut(1000,function(){
						$(img).css("visibility","visible");
					});
				}
			}
		});
	};
