<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 胡开成
  Date: 2019/1/31
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>回答内容</title>
    <style>
        .left{
            float: left;
        }
        .clearfix::after{
            content: ',';
            display: block;
            height: 0;
            visibility: hidden;
            clear: both;
        }
    </style>
</head>
<body>
    <div>
        <div>
            为题是:${question.title}
        </div>
        <div>
            问题的描述:${question.detailDesc}
        </div>
        <div class="clearfix">
            <div class="left">
                网友的回答：
            </div>
            <div class="left">
                <c:forEach items="${question.answers}" var="obj">
                    <div>
                        ${obj.ansDate}
                    </div>
                    <div>

                            ${obj.ansContext}
                    </div>
                </c:forEach>
            </div>
        </div>

        <div class="clearfix">
            <div class="left">
                我来回答
            </div>
            <div class="left">
                <form action="${ctx}/question/ask" method="post">
                    <input type="hidden" name="qid" value="${question.id}">
                    <textarea name="ansContext"></textarea>
                    <input type="submit" value="提交答案"> <a href="${ctx}/">返回首页</a>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
