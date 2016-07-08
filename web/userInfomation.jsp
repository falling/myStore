<%@ page import="bean.Usertablebean" %><%--
  Created by IntelliJ IDEA.
  User: falling
  Date: 16/7/8
  Time: 上午11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>个人信息</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style>
        #information {
            padding: 70px 200px 0 200px;
            font-family: "微软雅黑";
        }
    </style>
</head>
<body>
<%Usertablebean user = (Usertablebean) request.getSession().getAttribute("user");%>

<div id="information">
    <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title"><%=user.getUsername()%>的个人信息</h4>
        </div>
        <div class="panel-body">
            <div class="form-group">
                姓名 <input type="text" name="title" class="form-control" id="name" value="<%=user.getName()%>">
            </div>
            <div class="form-group">
                联系方式 <input type="text" name="title" class="form-control" id="tel" value="<%=user.getTel()%>">
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-primary" onclick="updateInfo()">修改</button>
        </div>
    </div>

    <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title">修改密码</h4>
        </div>
        <div class="panel-body">
            <div class="form-group">
                旧密码 <input type="password" name="title" class="form-control" id="oldPassword" >
            </div>
            <div class="form-group">
                新密码 <input type="password" name="title" class="form-control" id="newPassword">
            </div>
            <div class="form-group">
                重复新密码 <input type="password" name="title" class="form-control" id="password1">
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-primary" onclick="updatePassword()">修改</button>
        </div>
    </div>
</div>

<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    function updateInfo() {
        if($("#name").val().trim()!=""&&$("#tel").val().trim()!="") {
            $.ajax({
                url: "updateUserInfo",
                type: "post",
                data: {
                    "user.name": $("#name").val().trim(),
                    "user.tel": $("#tel").val().trim()
                }
            }).success(function (data) {
                var re = JSON.parse(data);
                if(re=="success") {
                    alert("修改成功");
                    location.reload();
                }else{
                    alert(re.toString());
                }
            }).error(function () {
                alert("error");
            })
        }else{
            alert("信息不能为空");
        }
    }
    function updatePassword() {
        if($("#newPassword").val().trim()!="" &&$("#newPassword").val().trim()==$("#password1").val().trim()) {
            $.ajax({
                url: "updateUserInfo",
                type: "post",
                data: {
                    "oldPassword":$("#oldPassword").val().trim(),
                    "user.password": $("#newPassword").val().trim()
                }
            }).success(function (data) {
                var re = JSON.parse(data);
                if(re=="success") {
                    alert("修改成功");
                    location.reload();
                }else{
                    alert(re.toString());
                }
            }).error(function () {
                alert("error");
            })
        }else{
            alert("新密码不能为空并且必须相等!")
        }
    }
</script>

</body>
</html>
