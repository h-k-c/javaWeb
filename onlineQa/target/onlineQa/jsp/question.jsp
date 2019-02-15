<%--
  Created by IntelliJ IDEA.
  User: 胡开成
  Date: 2019/1/30
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布提问</title>
</head>
<body>
    <div>
        <h2>我要提问</h2>
        <a href="${ctx}/">返回首页</a>
    </div>
    <div>
        <form action="${ctx}/question/save" method="post">
            问题描述：<input type="text" name="title">
            问题详述：<textarea name="detailDesc"></textarea>
            <input type="submit" value="提交">
        </form>

    </div>
</body>
</html>
