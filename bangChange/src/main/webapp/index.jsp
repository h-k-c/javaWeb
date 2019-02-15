<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <style>
        #main{
            width:80%;
            margin: auto;
        }
    </style>
</head>
<body>
<div id="main">
    <form action="${ctx}/account/login" method="post" onsubmit="return check()">
            <h1>个人网上银行</h1>
        卡号：<input type="text" name="cardNo"><br>
        密码:<input type="text" name="password"><br>
        <input type="submit" value="登录网上银行">
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script>
    var errorMsg='${errorMsg}';
    if(errorMsg!=null&&errorMsg!=undefined&&errorMsg!=''){
        alert(errorMsg);
    }
    
    function check() {
        var cardNo = $('input[name=cardNo]').val();
        if (cardNo.length!=16){
            alert("卡号必须是16位");
            return false;
        }
        var password=$('input[name=password]').val();
        if(password.length!=6){
            alert("密码必须是6位");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
