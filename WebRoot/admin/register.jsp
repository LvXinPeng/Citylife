<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>用户注册</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css;">
</head>
<script language="javascript" type="text/javascript">
function show(obj){
	if(obj.username.value==''||obj.username.value==null){
	alert("请输入用户名！");
	return false;
	}
	else if(obj.password.value==''||obj.password.value==null){
	alert("请输入密码！");
	return false;
	}
}
</script>
<body bgcolor="#E7ECEF">
    <center>
        <form action="../UserServlet?flag=reg" method="post" onsubmit="return show(this)">
            <table border="0" cellspacing="0" cellpadding="0" style="margin-top:130">
                <tr><td><img src="../images/logon_top.gif"></td></tr>                
                <tr height="180">
                    <td background="../images/logon_middle.gif" align="center" valign="top">
                         <table border="0" width="90%" cellspacing="0" cellpadding="0">
                             <tr height="50"><td colspan="2"></td></tr>
                             <tr height="30">
                                 <td align="right" width="40%">用户名：&nbsp;&nbsp;</td>
                                 <td style="text-indent:5"><input type="text" name="username" size="30" value="" id="username" onblur="checkusername()"/></td>
                             </tr>                
                             <tr height="30">
                                 <td align="right">密&nbsp;&nbsp;码：&nbsp;&nbsp;</td>
                                 <td style="text-indent:5"><input type="password" name="password" size="30" id="password" onblur="checkpassword()"/></td>
                             </tr>
                             <tr height="60">
                                 <td></td>
                                 <td>
								
                                     <input type="submit" id="" value="注册"/>

                                     <input type="reset" value="重置"/>

                                     <a id="log_Login_action_" href="../view/indextemp.html">[返回首页]</a>
                                 </td>
                             </tr>
                         </table>
                    </td>
                </tr>
                <tr><td><img src="../images/logon_end.gif"></td></tr>
            </table>
        </form>



     
    </center>
</body>
</html>