<%--
  Created by IntelliJ IDEA.
  User: falling
  Date: 2016/6/3
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style>
        #register {
            width: 300px;
            height: 300px;
            position: absolute;
            top: 50%;
            margin-top: -150px;
            left: 50%;
            margin-left: -150px;
        }
    </style>
</head>
<body>
<h1 class="text-center">注册</h1>

<div id="register">
    <div class="panel panel-primary">
        <div class="panel-heading">
            Register
        </div>
        <form id="form" class="panel-body">
            <div class="form-group">
                用户名:<input type="text" name="user.username" class="form-control" id="username">
                密码:<input type="password" name="user.password" class="form-control" id="password">
                手机:<input type="text" name="user.tel" class="form-control" id="tel">
                姓名:<input type="text" name="user.name" class="form-control" id="name">
            </div>
            <input type="button" value="返回" class="btn btn-default pull-right" onclick="location='login.jsp'">
            <input type="button" value="注册" class="btn btn-primary pull-right" id="sub">
        </form>
    </div>
</div>

<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script>

    $('#sub').click(function () {
        if (check()) {
            $.ajax({
                url: "register",
                type: 'post',
                data: {
                    "bean.username": $('#username').val(),
                    "bean.password": $('#password').val(),
                    "bean.tel": $('#tel').val(),
                    "bean.name": $('#name').val()
                }
            }).success(function () {
                alert("注册成功");
                self.location = 'login.jsp';
            }).error(function () {
                alert("注册失败，可能有同名的用户");
            })
        }
    });


    function check() {
        if ($('#username').val() == "") {
            alert("用户名不能为空");
            return false;
        }
        if ($('#password').val().length < 6) {
            alert("密码不得少于6位");
            return false;
        }
        if (!isPhoneNo($('#tel').val())) {
            alert("手机号码不正确");
            return false;
        }
        if ($('#name').val() == "") {
            alert("姓名不得为空");
            return false;
        }
        return true;
    }

    function isPhoneNo(phone) {
        var pattern = /^1[34578]\d{9}$/;
        return pattern.test(phone);
    }


</script>

</body>
</html>
