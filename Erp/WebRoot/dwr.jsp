<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dwr.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <script type="text/javascript" src="/Erp/js/dwr/engine.js"></script>
    <script type="text/javascript" src="/Erp/js/dwr/util.js"></script>
    <script type="text/javascript" src="/Erp/js/dwr/interface/push.js"></script>
    <script type="text/javascript" src="/Erp/js/libs/jquery.js"></script>
     <script type="text/javascript">
        $(document).ready(function(){
           dwr.engine.setActiveReverseAjax(true);
           $("#send").click(function(){
             push.pushMessage($("#msg").val());
             $("#msg").val("");
           });
        });
        
         function  back(msg){
            $("#ul").html($("#ul").html()+"</br>"+msg);
        }
        
        
        
    </script>
  </head>
  
  <body>
       <ul id="ul" style="color:red;font-size: 21px">
       
       </ul>
    <input type="text" id="msg" size="30" style="min-height: 60px;width: 80%">
    <input type="button"   id="send" value="发送" style="padding: 10px">
  </body>
</html>
