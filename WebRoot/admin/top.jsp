<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head><title>后台-页眉</title>
  <link type="text/css" rel="stylesheet" href="../css/style.css">
</head>
<body>
    <center>
    
        <table border="0" width="100%" height="93" cellspacing="0" cellpadding="0" background="../images/admin_top.jpg">
            <tr>
                <td width="100%" height="100%" align="right" valign="bottom">
               
				<a href="" onclick="window.parent.location.href='../view/Indextemp.html'">
					<img src="../images/admin_index.gif" border="0" />
				</a>
				<a href="../UserServlet?flag=logout" target="_parent">
					<img src="../images/admin_exit.gif" border="0" />
				</a>
                </td>
            </tr>            
        </table>
    </center>
</body>
</html>