<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 胡开成
  Date: 2019/1/29
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${not empty msg}">
    <script>
        alert("${msg}");
    </script>
</c:if>
<form action="${ctx}/account/updatepassword" method="post" onsubmit="return check()">
    输入新密码:<input type="text" name="resultpassword">
    再次输入新密码<input type="text" name="newpassword">
    <input type="submit" value="确定">
</form>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>

    function check() {
        var resultpassword=$('input[name=resultpassword]').val();
        var newpassword=$('input[name=newpassword]').val();
        if(resultpassword.length!=6){
            alert("密码长度必须是6位");
            return false;
        }else {
            if(resultpassword!=newpassword){
                alert("两次的密码长度不一样");
                return false;
            }
            return true;
        }

    }

</script>