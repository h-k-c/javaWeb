<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 胡开成
  Date: 2019/1/30
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线问答</title>
    <style>
        table tbody tr:nth-of-type(even){
            background-color: darkolivegreen;
        }
        table thead tr{
            background-color: aqua;
        }
    </style>
</head>
<body>
    <div>
        <h2>在线问答</h2>
        <a href="${ctx}/question/put">我要提问</a>
        <table>
            <thead>
            <tr>
                <th>序号</th>
                <th>问题</th>
                <th>回答次数</th>
                <th>日期</th>
            </tr>
            </thead>
            <tbody>

                <c:forEach items="${questions}" var="obj" varStatus="status">
                    <tr>
                        <td>${status.index+1}</td>
                        <td><a href="${ctx}/question/answer?id=${obj.id}">${obj.title}</a></td>
                        <td>${obj.answerCount}</td>
                        <td><fmt:formatDate value="${obj.lastModified}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
