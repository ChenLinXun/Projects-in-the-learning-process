<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${status ==1}">
    启用
</c:if>

<c:if test="${status ==0}">
    禁用
</c:if>

<table border="1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>呼吸法</th>
        <th>队内等级</th>
        <th>状态</th>
    </tr>

    <c:forEach items="${actors}" var="actor" varStatus="serial">
    <tr align="center">
        <td>${serial.count}</td>
        <td>${actor.name}</td>
        <td>${actor.sex}</td>
        <td>${actor.breath}</td>
        <td>${actor.level}</td>
        <c:if test="${actor.survive == 1}">
            <td>存活</td>
        </c:if>
        <c:if test="${actor.survive == 0}">
            <td>牺牲</td>
        </c:if>
    </tr>
    </c:forEach>
</table>

<c:forEach begin="1" end="10" step="1" var="i">
    <a href="#">${i}</a>
</c:forEach>

</body>
</html>
