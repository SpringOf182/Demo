<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>">

        <title>login.jsp</title>

        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->

    </head>

    <body>
        <form name="userInfoForm" action="${pageContext.request.contextPath}/login.action" method="post">
            用户名:
            <input name="userName" type="text"/><br>
            密码:
            <input name="password" type="password"/><br>
            <input name="sub" type="submit" value="SignUp" />
            <input name="res" type="reset" value="Reset" />
        </form>
    </body>
</html>
