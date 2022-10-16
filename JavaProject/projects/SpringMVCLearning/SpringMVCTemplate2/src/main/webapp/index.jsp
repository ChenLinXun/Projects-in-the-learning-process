<%--
  Created by IntelliJ IDEA.
  User: 26574
  Date: 2022/4/6
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>冲冲冲</title>
</head>
<body>
<h1 align="center" style="color: red">努力！奋斗！</h1>

<table width="100%" height="700">
    <tr>
        <td width="200" style="border-right: deepskyblue 2px solid; background: rgba(255,0,0,0.1)">
            <ul>
                <li><a href="book-add.jsp" target="mainFrame">添加图书</a></li>
                <li><a href="list.jsp" target="mainFrame">图书列表</a></li>
            </ul>
        </td>
        <td>
            <iframe name="mainFrame" width="100%" height="700" frameborder="0"></iframe>
        </td>
    </tr>
</table>

</body>
</html>
