	
	$(
		function(){
		//验证用户名密码
		$("#btnSignCheck").click(function(){
			//获取请求路径
			var url = window.location.pathname;
			var userlogin = "/dangdang/cart/checkLogin.do";
			if(url == userlogin){
				requesturl = "/dangdang/user/login.do?flag=buy";
			}else{
				requesturl = "/dangdang/user/login.do";
			}		
			$.ajax({
				url:requesturl,
				data:{email:$("#txtUsername").val(),password:$("#txtPassword").val()},
				type:"POST",
				dataType:"text",
				success:function(result){
					if(result == "trueLogin"){
						//跳转页面
						window.location.href="../user/login_ok.jsp";
					}else if(result == "falseLogin"){
						$("li:last").text("用户名或密码错误！");
					}else if(result == "trueBuy"){
						window.location.href="../user/redirect.jsp";
					}
				}	
			});	
		});
		//提示错误信息后，input框获得焦点取消显示
		$("#txtPassword").focus(function(){
			$("li:last").text("");
		});
		$("#txtUsername").focus(function(){
			$("li:last").text("");
		});
		
	});
	