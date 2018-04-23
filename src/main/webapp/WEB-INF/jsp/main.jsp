<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName() +":"+request.getServerPort()+path+"/";
%>
<%@page isELIgnored="false" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>main.jsp</title>
</head>
<body>
<h1>欢迎您，<shiro:principal/></h1></br>

<shiro:hasRole name="admin">
    <h1>只有admin角色能够看到的内容</h1><br>
</shiro:hasRole>

<shiro:hasRole name="role1">
    <h1>只有role1角色能够看到的内容</h1><br>
</shiro:hasRole>

<shiro:hasRole name="role2">
    <h1>只有role2角色能够看到的内容</h1><br>
</shiro:hasRole>

<shiro:hasPermission name="/student/add">
    <h1>增加用户</h1></br>
</shiro:hasPermission>

<shiro:hasPermission name="/student/delete">
    <h1>删除用户</h1></br>
</shiro:hasPermission>

<shiro:hasPermission name="/student/update">
    <h1>修改用户</h1></br>
</shiro:hasPermission>

<shiro:hasPermission name="/student/select">
    <h1>查询用户</h1></br>
</shiro:hasPermission>


<a href="<%=basePath%>student/add">增加学生</a><br>
<a href="<%=basePath%>student/delete">删除学生</a><br>
<a href="<%=basePath%>student/update">修改学生</a><br>
<a href="<%=basePath%>student/select">查询学生</a><br>
</body>
</html>
