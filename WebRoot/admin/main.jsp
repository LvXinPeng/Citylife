<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
     <title>后台首页</title>
    
    <link type="text/css" rel="stylesheet" href="../css/style.css">
</head>
<body>
    <center>
     
        <table border="0" cellpadding="0" cellspacing="0" width="688" height="auto">
            <tr height="20"><td><img src="../images/default_t.jpg"></td></tr>
            <tr><td background="../images/default_m.jpg" valign="top">
				<!-- 内容区 -->
				<iframe name="default" src="default.jsp" frameBorder="0" width="650" scrolling="no" height="300" style="margin-left:10"></iframe>

				</td>
			</tr>
            <tr height="26"><td><img src="../images/default_e.jpg"></td></tr>        
        </table>
    </center>
</body>
</html>