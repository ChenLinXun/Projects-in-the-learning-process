<%--
  Created by IntelliJ IDEA.
  User: 26574
  Date: 2022/4/30
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>表单提交</h3>
    <form action="book/add" method="post">
        <p>图书名称<input type="text" name="bookName"/></p>
        <p>图书作者<input type="text" name="bookAuthor"/></p>
        <p>图书价格<input type="text" name="bookPrice"/></p>
        <p><input type="submit" value="提交"/></p>
    </form>

    <h3>表单提交2</h3>
    <form action="book2/add" method="post">
        <p>图书名称<input type="text" name="bookName"/></p>
        <p>图书作者<input type="text" name="bookAuthor"/></p>
        <p>图书价格<input type="text" name="bookPrice"/></p>
        <p>出版时间<input type="text" name="publishTime"/></p>
        <p><input type="submit" value="提交"/></p>
    </form>

    <h3>AJAX提交（请求头传值）</h3>
    <input type="button" value="ajax提交1" id="btn1"/>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $("#btn1").click(function () {
            $.ajax({
                url:"book/list",
                type:"post",
                headers:{
                    token:"xixihaha"
                },
                success:function (res) {
                    console.log(res);
                }
            });
        });
    </script>

    <h3>AJAX提交（请求体传值）</h3>
    <input type="button" value="ajax提交2" id="btn2"/>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $("#btn2").click(function () {
            var obj = {};
            obj.bookName = "Java";
            obj.bookAuthor="张三";
            obj.bookPrice=3.33;

            $.ajax({
                url:"book/update",
                type:"post",
                contentType:"application/json",
                dataType:"json", //设置返回数据类型为json
                data:JSON.stringify(obj),
                success:function (res) {
                    console.log(res);
                }
            });
        });
    </script>

</body>
</html>
