<%--
  Created by IntelliJ IDEA.
  User: falling
  Date: 2016/6/9
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script>var clickState</script>
    <title>用户订单</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding: 70px 0 0 0;
            font-family: "微软雅黑";
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a href="main.jsp" class="navbar-brand">店铺</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="#">查看订单</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div>
            <table id="OrderTable" class="table table-hover" data-toggle="modal" data-target="#DisplayDetails">
                <tr>
                    <th>订单号</th>
                    <th>购买时间</th>
                    <th>总价格</th>
                    <th>备注</th>
                    <th>状态</th>
                </tr>
            </table>
        </div>
    </div>
</div>

<!-- 订单详情的窗口 -->
<div class="modal fade" id="DisplayDetails" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">订单详情</h4>
            </div>
            <div class="panel-body">
                <table id="detailsTable" class="table table-hover">
                    <tr>
                        <th>食品名称</th>
                        <th>图片</th>
                        <th>售价</th>
                        <th>类型</th>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
                <script>
                    if(clickState ==1){
                        alert("1");
                        document.write("<button id='finish' type='button' class='btn btn-primary'>已经完成</button>");
                    }
                </script>
            </div>
        </div>
    </div>
</div>

<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    //加载table的信息
    $(function () {
        $.ajax({
            url: "loadOrder",
            type: "post",
            data:{
                action:"userOrder"
            }
        }).success(function (data) {
            var obj = JSON.parse(data);
            $.each(obj, function (i, ob) {
                var row = "<tr onclick=details("+ob.id+","+ob.state+")>" +
                        "<td>" + ob.id + "</td>" +
                        "<td>" + getTime(ob.time) + "</td>" +
                        "<td>" + ob.total + "</td>" +
                        "<td>" + ob.remark + "</td>" +
                        "<td>" + getState(ob.state) + "</td>" +
                        "</tr>";
                $("#OrderTable tr:last").after(row);
            });

        }).error(function () {
            alert("failed");
        });
    });

    //更具数值获取对应的ID
    function getState(state) {
        if (state == 0) {
            return "未接单";
        } else if (state == 1) {
            return "已接单";
        } else if (state == 2) {
            return "已经完成";
        }
    }

    //格式化输出时间
    function getTime(time) {
        var t = new Date(time);
        return t.getFullYear() + "年" + (t.getMonth() + 1) + "月" + t.getDate() + "日" + " " + t.getHours() + ":" + t.getMinutes() + ":" + t.getSeconds();
    }

    //显示订单详情
    function details(id,state) {
        clickState=state;
        $.ajax({
            url: "details",
            type: "post",
            data:{
                id:id
            }
        }).success(function (data) {
            //移除原来的数据
            $("#detailsTable tr:not(:first)").remove();
            var obj = JSON.parse(data);
            $.each(obj, function (i, ob) {
                var row = "<tr>" +
                        "<td>" + ob.name + "</td>" +
                        "<td><img src='" + ob.imgUrl + "'height='50' width='50'/></td>" +
                        "<td>" + ob.price + "</td>" +
                        "<td>" + ob.type + "</td>" +
                        "</tr>";
                $("#detailsTable tr:last").after(row);
            });

        }).error(function () {
            alert("failed");
        });
    }

</script>
</body>
</html>
