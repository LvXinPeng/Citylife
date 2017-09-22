<%@page import="com.xinpeng.model.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title>后台首页</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script>
	function del(userid) {
		if(confirm("是否确定要删除用户信息？")){
			window.location.href="UserServlet?flag=delete&userid="+userid;
		}
	}
</script>
</head>
<body>
	<center>
		<table width="650" cellspacing="0" cellpadding="0" border="0" height="300">
			<tbody>
				<tr>
					<td align="center">用户id</td>
					<td align="center">用户名</td>
					<td align="center">操作</td>
				</tr>
				<%
					List<User> userList = (List<User>) request.getAttribute("userList");
					//System.out.println(userList.size());
				%>
				<%
					for (int i = 0; i < userList.size(); i++) {
				%>
				<tr id="trdel">
					<td align="center"><%=userList.get(i).getUserId()%></td>
					<td align="center"><%=userList.get(i).getUsername()%></td>
					<td align="center"><a href="UserServlet?flag=toUpdate&userid=<%=userList.get(i).getUserId()%>">修改密码</a>|<a href="#" onClick="del(<%=userList.get(i).getUserId()%>)">删除</a></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</center>

</body>
</html>