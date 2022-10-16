<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.feng.JSP.Actor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //假设这里完成了数据库查询，拿到了内容列表
    List<Actor> actors = new ArrayList<Actor>();
    actors.add(new Actor("灶门炭治郎","男","水之呼吸","癸",1));
    actors.add(new Actor("嘴平伊之助","男","兽之呼吸","癸",1));
    actors.add(new Actor("我妻善逸","男","雷之呼吸","癸",1));
    actors.add(new Actor("炼狱杏寿郎","男","炎之呼吸","柱",0));
    actors.add(new Actor("栗花落香奈乎","女","花之呼吸","己",1));
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>鬼灭之刃</title>
</head>
<body>

<input type="button" value="新增"><br>
<hr>

<table border="1" cellspacing="0" width="800">

    <tr>
        <th>姓名</th>
        <th>性别</th>
        <th>呼吸法</th>
        <th>队内等级</th>
        <th>状态</th>
    </tr>

    <%
        for (Actor actor : actors) {
    %>
    <tr align="center">
        <td><%=actor.getName()%></td>
        <td><%=actor.getSex()%></td>
        <td><%=actor.getBreath()%></td>
        <td><%=actor.getLevel()%></td>
        <%
            if (actor.getSurvive() == 1){
        %>
            <td><%="存活"%></td>

        <%
            }else if (actor.getSurvive() == 0){
        %>
            <td><%="牺牲"%></td>
        <%
            }
        %>
    <%
        }
    %>
    </tr>
</table>

</body>
</html>
