/**
 * 页面初始化后，绑定函数。
 */
$(function(){
	//注册
	$("#regist_button").click(function(){
		register();
	});
	
	//登录
	$("#login").click(function(){
		login();
	});
	
	//登出
	$("#logout").click(function(){
		logout();
	});
	
	//修改密码
	$("#changePassword").click(function(){
		changepwd();
	})
	
});

//注册
function register() 
{
	var username=$("#regist_username").val();
	var nickname=$("#nickname").val();
	var password=$("#regist_password").val();
	var finalpwd=$("#final_password").val();
	var reg=/^\w{3,9}$/;
	var reg2=/^\d{6,11}$/;
	if(!reg.test(username))
	{
		$("#warning_1 span").text("用户名3-9位");
		$("#warning_1").show();
		return;
	}
	else
	{
		$("#warning_1").hide();
	}
	if(!reg2.test(password))
	{
		$("#warning_2 span").text("密码6-11");
		$("#warning_2").show();
		return;
	}
	else
	{
		$("#warning_2").hide();
	}
	if(password!==finalpwd)
	{
		$("#warning_3").show();
		return;
	}
	else
	{
		$("#warning_3").hide();
	}
	//通过jquery的post方法使用ajax异步请求和json数据交互实现局部响应
	$.post("/Spring/login/regist.do",
			{"cn_user_name":username,"cn_user_desc":nickname,"cn_user_password":password},
	function(controllerResult)
	{
		if(!controllerResult.data)
		{
			$("#warning_1 span").show();
		}
		else
		{
			alert("注册成功.");
			$("#zc").attr("class","sig sig_out");
			$("#dl").attr("class","log log_in");
		}
	}		
	);

}

//登陆
function login()
{
	var username=$("#count").val();
	var password=$("#password").val();
	if(!username)
	{
		alert("用户名不能为空");
		return;
	}
	if(!password)
	{
		alert("密码不能为空");
		return;
	}
	$.post("/Spring/login/login.do",{"cn_user_name":username,"cn_user_password":password},function(controllerResult)
	{
		if(controllerResult.success)
		{
			if(controllerResult.data.flag==2)
			{
				alert("密码错误");
				return;
				
			}
			else if(controllerResult.data.flag==1)
			{
				alert("用户名错误");
				return;
			}
			else
			{
				
				location.href="edit.html";
				addCookie("user",controllerResult.data.username);
			}
		}
		else
		{
			alert("登录失败");
			return;
		}
	});

}

/**
 * 退出登录
 */
function logout()
{
	$.post("/Spring/login/logout.do",{},function(result)
			{
				if(result.success)
				{
					location.href="login.html";
				}
				else
				{
					alert(result.message);
				}
			}		
	);
	
}

/**
 * 修改密码
 */
function changepwd()
{
	/*
	 * 1.检验密码是否6位 
	 * 2.校验两次密码是否一致
	 */
	var reg=/^\d{6,11}$/;
	var lastpassword=$("#last_password").val();
	var newpassword=$("#new_password").val();
	var finalpassword=$("#final_password").val();
	if(!lastpassword)
	{
		alert("原密码不能为空");
		return;
	}
	if(!newpassword)
	{
		alert("新密码不能为空");
		return;
	}
	if(!reg.test(newpassword))
	{
		$("#warning_2 span").text("密码长度为6-11");
		$("#warning_2").show();
		return;
	}
	else
	{
		$("#warning_2").hide();
	}
	if(newpassword!==finalpassword)
	{
		$("#warning_3").show();
		return;
	}
	else
	{
		$("#warning_3").hide();
	}
	$.post("/Spring/login/changepwd.do",
			{"lastpwd":lastpassword,"newpwd":newpassword},
			function(result)
			{
				if(result.success)
				{
					if(result.data)
					{

						alert("修改成功.");
						logout();
					}
					else
					{
						$("#warning_1").show();
						return;
					}
				}
				else
				{
					alert(result.message);
					return;
				}
			}
	);

}


