<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 胡开成
  Date: 2019/1/27
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<c:if test="${not empty code and not empty msg}">
    <c:if test="${code eq 2500}">
        <script>
            alert("操作成功");
        </script>
    </c:if>

    <c:if test="${code != 2500}">
        <script>
            alert(${msg})
        </script>
    </c:if>
</c:if>
    <form action="${ctx}/account/transfer" method="post">
        转入的账号：<input type="text" name="cardNo">
        转入的金额:<input type="text" name="transactionAmount">
        <input type="submit" value="转账">
    </form>



