<%@ page import="com.xinpeng.model.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title>后台首页</title><link href="../css/style.css" rel="stylesheet" type="text/css"></head>
  
<body>
    <center>
    	<form method="post" action="UserServlet?flag=update&userid=${user.userId}">
        <table width="650" cellspacing="0" cellpadding="0" border="0" height="300">
           	
           	<tbody><tr><td align='right'>用户id:&nbsp;&nbsp;</td><td><input type="text" readonly="readonly" value="${user.userId}" name="userid"></td></tr>
           	<tr><td align='right'>用户名:&nbsp;&nbsp;</td><td><input type="text" readonly="readonly" value="${user.username}" name="username"></td></tr>
           	<tr><td align='right'>用户密码:&nbsp;&nbsp;</td><td><input type="password" value="${user.password}" name="password"></td></tr>
           	<tr><td></td><td><input type="submit" value="修改"></td></tr>
        </tbody></table>
        </form>
    </center>

</body>
</html>