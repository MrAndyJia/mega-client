<%@page import="org.springframework.security.web.WebAttributes"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>智能管理系统-登录</title>
<!-- Custom Theme files -->
<link href="./css/login.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="" />
</head>
<body>
<div class="login">
	<h2>智能管理系统</h2>
	<div class="login-top">
		<h1>用户登录</h1>
		<form method="post" action="security_check_" onsubmit="return check()" >
<!-- 		<form method="post" action="security_check_" > -->
			<input type="text" id = "username_" name = "username_" value="帐号……" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">
			<input type="password" id = "password_" name = "password_"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">
		    <div class="forgot">
		    	<a href="">忘记密码</a>
		    	<input type="submit" name="submit" value="登录" >
		    </div>
	    </form>
	</div>
	<div class="login-bottom">
<!-- 		<h3>New User &nbsp;<a href="#">注册</a>&nbsp; Here</h3> -->
		<span id ="errormsg" >
		 <%!
			private String getAuthenticationExceptionMessage(){
			    Exception exp = (Exception)ContextHolder.getHttpSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
			    if(exp==null){
			        exp=(Exception)ContextHolder.getRequest().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
			    }
			    if(exp!=null){
			        return exp.getMessage();
			    }
			    return null;
			}
		%>
		<%
			String error = getAuthenticationExceptionMessage();
			if(StringUtils.isNotEmpty(error)){
				if(error.contains("password")){
					error="您的密码不正确，请重新输入！！";
				}
				if(error.startsWith("Bad")){
					error="用户名或密码有误，请重新输入！！";
				}
				if(error.contains("SQL")){
					error="数据库连接异常，请重尝试新登录！！";
				}
			    out.println("系统："+error);    
			}
		%>
		</span>
	</div>
</div>	
<div class="copyright">
	<p>Copyright &copy; 2017.Company name All rights reserved.<a target="_blank" href="#">www.megasoft.com</a></p>
</div>

<script type="text/javascript">
	function check(){
		var text1 = document.getElementById("username_").value;
		var text2 = document.getElementById("password_").value;
		var errormsg = document.getElementById("errormsg");
		if(null==text1 || ""==text1 || text1=="帐号……"){
			errormsg.innerText="系统：帐号不能为空！！";
			request.setAttribute("SPRING_SECURITY_LAST_EXCEPTION",null);
       		return false;
   		}else if(null==text2 || ""==text2){
   			errormsg.innerText="系统：密码不能为空！！";
   			request.setAttribute("SPRING_SECURITY_LAST_EXCEPTION",null);
       		return false;
   		}else{
   			errormsg.innerText="";
       		return true;
   		}
	}
</script>
</body>
</html>