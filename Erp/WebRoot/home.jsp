<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'home.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	  a{ 
	     text-decoration: none;
	   }
	</style>

  </head>
  
  <body>
    选择登录方式<br>
    <a href="accountLogin.jsp"><div>
     <button >账号登录</button> 
    </div></a>
    <a href="codeLogin.jsp">
    <div>
     <button>扫码登录</button>
    </div></a>
  </body>
</html>
