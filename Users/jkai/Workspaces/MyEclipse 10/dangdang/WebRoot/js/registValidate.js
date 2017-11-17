		var flag = [false,false,false,false];
		var ajaxEmail = false;
		var ajaxValidate = false;
	$(	
		function(){
			//设置input autocomplete="off"
			$("input").attr("autocomplete","off");
			//验证码看不清，换一张
			$("#changeImag").click(function(){
				$("#imgVcode").attr("src","../imag/creatImag.do?n="+Math.random());
			});
			//重新获得验证码焦点事件
			$("#txtVerifyCode").focus(function(){
				$(".t1").html("<span id='vcodeValidMsg'>请输入图片中的四个字母。</span>"+
							  "<span id='number.info' style='color:red'></span>"+
							  "<a href='javascript:void(0)' id='changeImag'>看不清楚？换个图片</a>");
			});
			//检验邮箱格式
			$("#txtEmail").blur(function(){
				var mail = $("#txtEmail").val();
				if(mail == ''){
					$("#emailValidMsg :first-child").text("邮箱不能为空！");
					flag[0] = false;
				}
				if (mail != '') {
					var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
					if (!reg.test(mail)) {
						$("#emailValidMsg :first-child").text("邮箱格式不正确，请重新填写！");
						flag[0] = false;
					}else{
						flag[0] = true;
					}
				}
			//验证邮箱是否已被注册
			$.ajax({
				url:"/dangdang/user/checkEmail.do",
				type:"POST",
				dataType:"json",
				data:{email:$("#txtEmail").val()},
				beforeSend:function(XMLHttpRequest){
					if(flag[0] == true){
						$("#emailValidMsg :first-child").html("<img src='../images/load.gif'/>");
					}else{
						return false;
					}		
				},
				success:function(result){
					if(result == true && flag[0] == true){
						$("#emailValidMsg :first-child").html("<img src='../images/label.gif'/>");
						ajaxEmail = true;
					}else{
						$("#emailValidMsg :first-child").text("该邮箱已被注册！");
						ajaxEmail = false;
					}
				}
			});	
				
			});
			//计算字符长度，中文及双字节字符长度记为2
			function getByteLen(val) {
				var len = 0;
				for (var i = 0; i < val.length; i++) {
					if (val[i].match(/[^\x00-\xff]/ig) != null){ //全角
						len += 2;
					}
					else{
						len += 1;
					}
				}
				return len;
			} 
			//验证昵称格式
			$("#txtNickName").blur(function(){
				var nick = /^[a-z0-9\u4e00-\u9fa5]*$/;
				var inputnick = $("#txtNickName").val();
				if(inputnick == ''){
					$("#nickNameValidMsg").text("昵称不能为空！");
					flag[1] = false;
				}
				else if(getByteLen(inputnick)<4){
					$("#nickNameValidMsg").text("昵称不能小于4个字符！");
					flag[1] = false;
				}
				else if(getByteLen(inputnick)>20){
					$("#nickNameValidMsg").text("昵称不能超过20个字符！");
					flag[1] = false;
				}else{
					if(!nick.test(inputnick)){
						$("#nickNameValidMsg").text("昵称格式不符合要求！");
						flag[1] = false;
					}else{
						$("#nickNameValidMsg").html("<img src='../images/label.gif'/>");
						flag[1] = true;
					}
				}
			});
			//昵称输入重新获得焦点事件
			$("#txtNickName").focus(function(){
				$("#nickNameValidMsg").html("<p>您的昵称可以由小写英文字母、中文、数字组成，</p>"+
				"<p>长度4－20个字符，一个汉字为两个字符。</p>");
			});	
			//验证密码格式
			$("#txtPassword").blur(function(){
				var password = /^[a-zA-Z0-9]*$/;
				var inputpwd = $("#txtPassword").val();
				if(inputpwd == ''){
					$("#passwordValidMsg").text("密码不能为空！");
					flag[2] = false;
				}
				else if(getByteLen(inputpwd)<6){
					$("#passwordValidMsg").text("密码长度不能小于6位！");
					flag[2] = false;
				}
				else if(getByteLen(inputpwd)>20){
					$("#passwordValidMsg").text("密码长度不能大于20位！");
					flag[2] = false;
				}else{
					if(!password.test(inputpwd)){
						$("#passwordValidMsg").text("密码格式不符合要求！");
						flag[2] = false;
					}else{
						$("#passwordValidMsg").html("<img src='../images/label.gif'/>");
						flag[2] = true;
					}
				}	
			});
			//验证码输入重新获得焦点事件
			$("#txtPassword").focus(function(){
				$("#passwordValidMsg").html("<p>您的密码可以由大小写英文字母、数字组成，长度6－20位。</p>");
			});
			//判断两次密码输入是否相同
			$("#txtRepeatPass").blur(function(){
				var password1 = $("#txtPassword").val();
				var password2 = $("#txtRepeatPass").val();
				if(password2 == ''){
					$("#repeatPassValidMsg").text("密码不能为空！");
					flag[3] = false;
				}else if(getByteLen(password2)<6){
					$("#repeatPassValidMsg").text("密码长度不能小于6位！");
					flag[3] = false;
				}
				else if(getByteLen(password2)>20){
					$("#repeatPassValidMsg").text("密码长度不能大于20位！");
					flag[3] = false;
				}
				else if(password1 != password2){
					$("#repeatPassValidMsg").text("两次输入的密码不同！");
					flag[3] = false;
				}else{
					$("#repeatPassValidMsg").html("<img src='../images/label.gif'/>");
					flag[3] = true;
				}
			});
			//检验验证码
			$("#txtVerifyCode").blur(function(){
				$.ajax({
					url:"/dangdang/imag/checkImag.do",
					data:{number:$("#txtVerifyCode").val()},
					type:"POST",	
					dataType:"json",
					success:function(result){
						if(result == true){
							$(".t1").html("<img src='../images/label.gif'/>");
							ajaxValidate = true;
						}else{
							$(".t1").text("验证码错误！");
							$("#imgVcode").attr("src","../imag/creatImag.do?n="+Math.random());
							$("#txtVerifyCode").val("");
							ajaxValidate = false;
						}
					}
				});
			});
			//注册提交到Controller
			$("#btnClientRegister").click(function(){
					if(flag[0] && flag[1] && flag[2] && flag[3] && ajaxEmail && ajaxValidate){
						$("#f").submit();
					}
			});	
	});