<%--
  Created by IntelliJ IDEA.
  User: 45188
  Date: 2022/3/7
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- Form -->
<form action="${pageContext.request.contextPath }/alipay/carmate?" method="post">
    <br><center><th>&#32; </th></center>
    <br><center><th>&#32; </th></center>
    <br><center><th> &#32;</th></center>
    <center><th>用户id</th></center>


    <center>
        <input class="form-control" type="text" placeholder="userId"name="userId">
    </center>



    <center>
        <th>车牌号</th>
    </center>

        <input class="form-control" type="text" placeholder="carNumber"name="carNumber">

    <center><th>停车开始时间</th></center>

        <input class="form-control" type="date" placeholder="inTime"name="inTime">

    <center><th>停车结束时间</th></center>

        <input class="form-control" type="date" placeholder="outTime"name="outTime">




    <div class="form-group">
        <button class="btn btn-primary btn-block" type="submit">确认添加</button>
        <button class="btn btn-primary btn-block" type="button" onclick="togo('${manager.username}')" >返回上一页</button>

    </div>

</form>
</body>
</html>
