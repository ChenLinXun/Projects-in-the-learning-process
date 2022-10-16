<%--
  Created by IntelliJ IDEA.
  User: 26574
  Date: 2022/5/11
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <title>欢迎访问</title>
    <link rel="shortcut icon" href="#"/>
    <link rel="stylesheet" href="css/login.css"/>
</head>

<body>
<div id="log">
    <form action="user/login" method="post">
        <div id="welcome">欢迎登陆</div>
        <div>
            <a href="">立即注册</a>
        </div>
        <div class="email">
            <p>用户名：</p>
            <input type="text" class="fill" name="userName" placeholder="请输入用户名">
        </div>

        <div class="password">
            <p>密&emsp;码：</p>
            <input type="password" class="fill" name="password" placeholder="请输入密码">
        </div>

        <div class="longOn">
            <input type="submit" id="kick" value="登录">
            <p id="tips">${tips}</p>
        </div>
    </form>
</div>
</body>
</html>
