<%@ page import="java.util.List" %>
<%@ page import="bean.Goodstablebean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户点菜</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding: 70px 0 0 0;
            font-family: "微软雅黑";
        }

        .nav > li > button {
            display: block;
            position: relative;
            padding: 10px 15px;
            line-height: 20px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <b class="navbar-brand">店铺</b>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/userServlet?day=0">素类</a></li>
            <li><a href="/userServlet?day=1">荤类</a></li>
            <li><a href="/userServlet?day=2">饮料</a></li>
            <li><a href="/userServlet?day=2">历史订单</a></li>
            <li><a href="/userInfo">查看订单</a></li>
        </ul>
    </div>
</nav>


<%--<h1 class="text-primary text-center">${requestScope.title}</h1>--%>

<div class="container">
    <div class="row">
        <div>
            <table id="table" class="table table-hover">
                <tr>
                    <th>食品名称</th>
                    <th>图片</th>
                    <th>售价</th>
                    <th>类型</th>
                    <th>剩余数量</th>
                    <th>选项</th>
                </tr>
            </table>
        </div>
    </div>
</div>

<nav class="navbar navbar-default navbar-fixed-bottom navbar-left" role="navigation">
    <div class="container">
        <ul class="nav navbar-nav">
            <li><a href="#">查看购物车</a></li>
        </ul>
    </div>
</nav>


<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    $(function () {
        $.ajax({
            url: "loadGoods",
            type: "post"
        }).success(function (data) {
            var obj = JSON.parse(data);
            $.each(obj,function(i,ob){
                var row = "<tr>" +
                        "<td>" + ob.name + "</td>" +
                        "<td><img src='" + ob.imgUrl + "'height='50' width='50'/></td>" +
                        "<td>" + ob.price + "</td>" +
                        "<td>" + ob.type + "</td>" +
                        "<td>" + ob.number + "</td>" +
                        "<td><button class='btn btn-primary btn-buy'>来一份</button></td>" +
                        "</tr>";
                $("#table tr:last").after(row);
            });

        }).error(function () {
            alert("failed");
        });
    });
</script>
<script>
    <%--$(function () {--%>
    <%--$('.btn-buy').click(function () {--%>
    <%--var $tr = $(this).parent().prevAll();--%>
    <%--var price = Number($tr.eq(1).html().trim());--%>

    <%--if(money > price){--%>
    <%--$.ajax({--%>
    <%--url: "/buyServlet",--%>
    <%--type: 'post',--%>
    <%--data: {--%>
    <%--foodid:$(this).attr('data-fid'),--%>
    <%--price:price,--%>
    <%--day:"${requestScope.title}"--%>
    <%--}--%>
    <%--}).success(function () {--%>
    <%--alert("success");--%>
    <%--location.reload("/userServelt?day=${requestScope.day}");--%>
    <%--});--%>
    <%--} else{--%>
    <%--alert("您的余额不足。");--%>
    <%--}--%>
    <%--});--%>
    <%--})--%>
</script>

</body>
</html>