<%--
  Created by IntelliJ IDEA.
  User: Cabage
  Date: 2015/12/15
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style>
        #login{
            width:300px;
            height:300px;
            position: absolute;
            top: 50%;
            margin-top: -150px;
            left: 50%;
            margin-left: -150px;
        }
    </style>
</head>
<body>
<h1 class="text-center">Project Manager</h1>
<h2 class="text-danger">${requestScope.msg}</h2>

<div id="login">
    <div class="panel panel-primary">
        <div class="panel-heading">
            Login
        </div>
        <form action="Login.action" method="post"  class="panel-body">
            <div class="form-group">
                用户名:<input type="text" name="user.username" class="form-control">
                密码:<input type="password" name="user.password" class="form-control">
            </div>
            <input type="submit" value="登陆" class="btn btn-primary pull-right">
        </form>
    </div>
</div>

<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>