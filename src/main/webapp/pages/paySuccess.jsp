<%--
  Created by IntelliJ IDEA.
  User: 45188
  Date: 2022/3/18
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script src="<%=request.getContextPath() %>/static/js/jquery.min.js" type="text/javascript"></script>

<html>

<head>

</head>

<body>
<h1 style="color: green;">购买成功</h1>
<table>
    <tr>
        <td>
            订单编号: ${out_trade_no }
        </td>
    </tr>
    <td>
        支付宝交易号: ${trade_no }
    </td>
    <tr>
    </tr>
    <td>
        实付金额: ${total_amount }
    </td>
    <tr>

</table>
</body>

</html>


