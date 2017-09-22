<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>都市信息网-后台管理</title>
  <link type="text/css" rel="stylesheet" href="../css/style.css">
</head>
<body >
	
        <table border="0" width="920" cellspacing="0" height="auto" bgcolor="white" align="center" >
			<!-- 页眉 -->
            <tr>
				<td colspan="2">
					<iframe src="top.jsp" frameBorder="0" width="920" scrolling="no" height="100" ></iframe>
				</td>
			</tr>
			<!-- 分隔行 -->
            <tr height="10" bgcolor="lightgrey">
				<td colspan="2"></td>
			</tr>
			<!-- 内容区域 -->
            <tr>
                <td width="700" align="center" valign="top">
					<!-- main -->
					<iframe src="main.jsp" frameBorder="0" width="688" scrolling="no" height="400" ></iframe>
				</td>
				<td width="200" align="center" valign="top">
					<!-- 右侧栏 -->
					<iframe src="right.jsp" frameBorder="0" width="240" scrolling="no" height="690" ></iframe>
				</td>
            </tr>
			<!-- 分隔行 -->
			<tr height="10" bgcolor="lightgrey">
				<td colspan="2"></td>
			</tr>
			<!-- 页脚 -->
            <tr>
				<td colspan="2">
					<iframe src="end.jsp" frameBorder="0" width="920" scrolling="no" height="70" ></iframe>   
				</td>
			</tr>
			
        </table>        
    
</body>
</html>
