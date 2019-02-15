<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 胡开成
  Date: 2019/1/27
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人银行主页面</title>
    <style>
        .left{
            float: left;
        }
        .clearfix::after{
            content: ',';
            height: 0;
            display: block;
            visibility: hidden;
            clear: both;
        }
    </style>
</head>
<body>
<div>
    <p>卡号：${account.cardNo}<a href="${ctx}/account/out">退出登录</a></p>
</div>
<div class="clearfix">
    <div class="left">
        <div><a href="${ctx}/account/balance?cardNo=${account.cardNo}">查询余额</a></div>
        <div><a href="${ctx}/account/transferTo">转账</a></div>
        <div><a href="${ctx}/transactionRecord/index">查询交易记录</a></div>
        <div><a href="${ctx}/account/update">修改密码</a></div>
    </div>

</div>
<div class="left">
    <c:if test="${page eq 'balance'}">
        <jsp:include page="balance.jsp"/>
    </c:if>
    <c:if test="${page eq 'transferTo'}">
        <jsp:include page="transferTo.jsp"/>
    </c:if>
    <c:if test="${page eq 'record'}">
        <jsp:include page="record.jsp"/>
    </c:if>
    <c:if test="${page eq 'update'}">
        <jsp:include page="update.jsp"/>
    </c:if>
</div>
</body>
</html>
