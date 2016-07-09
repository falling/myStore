<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>购买页面</title>

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
            <a href="#" class="navbar-brand">店铺</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="customerorders.jsp">查看订单</a></li>
        </ul>
        <ul class="nav navbar-right">
            <li><a href="logout">注销</a></li>
            <li><a href="userInfomation.jsp">个人信息</a></li>
        </ul>
    </div>
</nav>


<div class="container">
    <div class="row">
        <div>
            <table id="table" class="table table-hover">
                <tr>
                    <th>食品名称</th>
                    <th>图片</th>
                    <th>售价</th>
                    <th>剩余数量</th>
                    <th>类型</th>
                    <th>选项</th>
                </tr>
            </table>
        </div>
    </div>
</div>

<nav class="navbar navbar-default navbar-fixed-bottom " role="navigation">
    <div class="container ">
        <div class="navbar-right ">
            <button class='btn btn-primary ' onclick='shop()'>查看购物车</button>
        </div>
    </div>
</nav>


<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    //加载table的信息
    $(function () {
        $.ajax({
            url: "loadGoods",
            type: "post"
        }).success(function (data) {
            var obj = JSON.parse(data);
            $.each(obj, function (i, ob) {
                var row = "<tr>" +
                        "<td>" + ob.name + "</td>" +
                        "<td><img src='" + ob.imgUrl + "'height='50' width='50'/></td>" +
                        "<td>" + ob.price + "</td>" +
                        "<td>" + ob.number + "</td>" +
                        "<td>" + ob.type + "</td>" +
                        "<td><button class='btn btn-primary btn-buy' onclick='buy("+ob.id+")'>来一份</button></td>" +
                        "</tr>";
                $("#table tr:last").after(row);
            });

        }).error(function () {
            alert("failed");
        });
    });
</script>
<script>
    //加入购物车
    function buy(id) {
        $.ajax({
            url: "cart",
            type: "post",
            data:{
                goodsId:id,
                action:"add"
            }
        }).success(function(){
            alert("已加入购物车");
        }).error(function(){

        })
    }
    function shop(){
        self.location="buy.jsp";
    }
</script>

</body>
</html>