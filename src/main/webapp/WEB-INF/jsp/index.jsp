<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="<%=basePath%>login" method="post">
        用户名：<input type="text" name="userName"/><br>
        密码：<input type="password" name="password"/><br>
        <input type="submit" value="登录"/><br>
        <span style="color: red;">${error}</span>
    </form>
</body>
</html>
