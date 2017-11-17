	
	$(function(){
		var currentPage = $("#currentPage").text();
		var totalPage = $("#totalPage").text();
		var cid = $("#categoryId").val();
		var pid = $("#parentId").val();
		var type = $("#type").val();
		//判断最后一页
		if(currentPage == totalPage && totalPage != 1 && totalPage != 0){
			$("#down1").html("<img src='../images/page_down_gray.gif' id='downimg1'/>");
			$("#down2").html("<img src='../images/page_down_gray.gif' id='downimg2'/>");
			if(type == 1){
				$("#up1").html("<a name=link_page_next href='../category/bookCategory.do?pid="+pid+"&pageIndex=1&type="+type+"'>"+"<img src='../images/page_up.gif' id='upimg1'/>");
				$("#up2").html("<a name=link_page_next href='../category/bookCategory.do?pid="+pid+"&pageIndex="+(parseInt(currentPage)-1)+"&type="+type+"'>"+"<img src='../images/page_up.gif' id='upimg2'/>");
			}else if(type == 2){
				$("#up1").html("<a name=link_page_next href='../category/bookCategory.do?cid="+cid+"&pageIndex=1&type="+type+"'>"+"<img src='../images/page_up.gif' id='upimg1'/>");
				$("#up2").html("<a name=link_page_next href='../category/bookCategory.do?cid="+cid+"&pageIndex="+(parseInt(currentPage)-1)+"&type="+type+"'>"+"<img src='../images/page_up.gif' id='upimg2'/>");
			}		
		}else if((currentPage == 1 && totalPage == 1) || (currentPage == 0 && totalPage == 0)){	//判断是否只有一页,或者数据为空
			$("#down1").html("<img src='../images/page_down_gray.gif' id='downimg1'/>");
			$("#down2").html("<img src='../images/page_down_gray.gif' id='downimg2'/>");
			$("#up1").html("<img src='../images/page_up_gray.gif' id='upimg1'/>");
			$("#up2").html("<img src='../images/page_up_gray.gif' id='upimg2'/>");
		}else if(currentPage == 1||currentPage == null){
			
		}else{
			if(type == 1){
				$("#up1").html("<a name=link_page_next href='../category/bookCategory.do?pid="+pid+"&pageIndex=1&type="+type+"'>"+"<img src='../images/page_up.gif' id='upimg1'/>");
				$("#up2").html("<a name=link_page_next href='../category/bookCategory.do?pid="+pid+"&pageIndex="+(parseInt(currentPage)-1)+"&type="+type+"'>"+"<img src='../images/page_up.gif' id='upimg2'/>");
			}else if(type == 2){
				$("#up1").html("<a name=link_page_next href='../category/bookCategory.do?cid="+cid+"&pageIndex=1&type="+type+"'>"+"<img src='../images/page_up.gif' id='upimg1'/>");
				$("#up2").html("<a name=link_page_next href='../category/bookCategory.do?cid="+cid+"&pageIndex="+(parseInt(currentPage)-1)+"&type="+type+"'>"+"<img src='../images/page_up.gif' id='upimg2'/>");
			}
		}
		//点击下一页事件
		$("#nextpage").click(function(){
			if(type == 1){
				$("#nextpage").attr("href","../category/bookCategory.do?pid="+pid+"&pageIndex="+(parseInt(currentPage)+1)+"&type="+type);
			}else if(type == 2){
				$("#nextpage").attr("href","../category/bookCategory.do?cid="+cid+"&pageIndex="+(parseInt(currentPage)+1)+"&type="+type);
			}			
		});
		//购买按钮鼠标移入事件
		$(".addCart").hover().css("cursor","pointer");
	});
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

