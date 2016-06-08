<%@ page import="java.util.List" %>
<%@ page import="bean.Goodstablebean" %>
<%@ page import="dao.DAOImpl" %>
<%@ page import="dao.DAO" %><%--
  Created by IntelliJ IDEA.
  User: falling
  Date: 2016/6/7
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>购物车</title>

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
            <b class="navbar-brand">购物车</b>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="main.jsp">继续购物</a></li>
        </ul>
    </div>
</nav>

<%
    List<Integer> goodsList = (List<Integer>) request.getSession().getAttribute("list");
    DAO dao = new DAOImpl();
    Goodstablebean bean = new Goodstablebean();
%>

<div class="container">
    <table class="table table-hover">
        <tr>
            <th>商品名称</th>
            <th>图片</th>
            <th>价格</th>
            <th>选项</th>
        </tr>
        <%
            if (goodsList != null) {
                for (int good : goodsList) {
                    bean.setId(good);
                    bean = (Goodstablebean) dao.get(bean);
        %>
        <tr>
            <td><%= bean.getName() %>
            </td>
            <td><img src="<%= bean.getImgUrl() %>" height="50" width="50"/>
            </td>
            <td><%= bean.getPrice()%>
            </td>
            <td data-goodId= <%= bean.getId() %>>
                <button class="btn btn-danger btn-delete-good">删除</button>
            </td>
        </tr>
        <%
                }
            } else {
                out.print("没有商品在购物车");
            }
        %>
    </table>
</div>

<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    $(function () {
        $(".btn-delete-good").click(function () {
            var goodid = $(this).parent().attr("data-goodId");
            $.ajax({
                url: "cart",
                type: "post",
                data: {
                    goodsId: goodid,
                    action: "delete"
                }

            }).success(function () {
                location.reload();
            })
        })
    })
</script>
</body>
</html>
