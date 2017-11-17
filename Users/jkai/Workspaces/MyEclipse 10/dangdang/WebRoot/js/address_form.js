
	$(function(){
				var flag = [false,false,false,false];
				//验证用户名和地址不能为空
				$("#receiveName").blur(function(){
					var receiveName = $("#receiveName").val();
					if(receiveName == ''){
						$("#nameValidMsg :first-child").text("收件人不能为空！");
					}else{
						$("#nameValidMsg :first-child").html("<img src='../images/label.gif'/>");
						flag[0] = true;
					}
				});
				$("#receiveName").focus(function(){
					$("#nameValidMsg :first-child").text("请填写有效的收件人姓名");
				});
				$("#fullAddress").blur(function(){
					var address = $("#fullAddress").val();
					if(address == ''){
						$("#addressValidMsg :first-child").text("地址不能为空！");
					}else{
						$("#addressValidMsg :first-child").html("<img src='../images/label.gif'/>");
						flag[1] = true;
					}
				});
				$("#fullAddress").focus(function(){
					$("#addressValidMsg :first-child").text("请填写有效的收件人的详细地址");
				});
				//验证邮箱是否合法
				$("#postalCode").blur(function(){
					var inputPost = $("#postalCode").val();
					var post = /^[1-9][0-9]{5}$/;
					if(inputPost == ''){
						$("#codeValidMsg :first-child").text("邮编不能为空！");
					}else if(!post.test(inputPost)){
						$("#codeValidMsg :first-child").text("邮编格式错误！");
					}else{
						$("#codeValidMsg :first-child").html("<img src='../images/label.gif'/>");
						flag[2] = true;
					}	
				});
				$("#postalCode").focus(function(){
					$("#codeValidMsg :first-child").text("请填写有效的收件人的邮政编码");
				});
				//验证手机号码是否合法
				$("#mobile").blur(function(){
					var inputMobile = $("#mobile").val();
					var mobile = /^1[3|4|5|7|8][0-9]{9}$/;
					if(inputMobile == ''){
						$("#mobileValidMsg :first-child").text("手机号不能为空！");
					}else if(!mobile.test(inputMobile)){
						$("#mobileValidMsg :first-child").text("手机格式错误！");
					}else{
						$("#mobileValidMsg :first-child").html("<img src='../images/label.gif'/>");
						flag[3] = true;
					}
				});
				$("#mobile").focus(function(){
					$("#mobileValidMsg :first-child").text("请填写有效的收件人的手机");
				});
				//如果输入合法，则请求controller
				$("#btnNext").click(function(){
					if(flag[0] && flag[1] && flag[2] && flag[3]){
						$("#f").submit();
					}	
				});	
			});