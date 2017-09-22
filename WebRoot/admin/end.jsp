<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>页脚</title>
  
    <link type="text/css" rel="stylesheet" href="../css/style.css">
</head>
<body>
    <center>
    当前在线人数：<%=session.getAttribute("count") %>
        <table border="0" width="100%" cellspacing="0" cellpadding="0">
            <tr><td align="center"><img src="../images/end.jpg"></td></tr>
        </table>        
    </center>
</body>
</html>