<%@ page import="java.util.List" %>
<%@ page import="bean.Goodstablebean" %>
<%@ page import="dao.DAOImpl" %>
<%@ page import="dao.DAO" %>
<%@ page import="service.GeneralService" %>
<%@ page import="util.SpringGetBeanUtil" %>
<%@ page import="java.util.Map" %>
<%@ page import="javax.persistence.criteria.CriteriaBuilder" %><%--
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
    Map<Integer, Integer> goodsMap = (Map) request.getSession().getAttribute("goodsMap");
    GeneralService service = (GeneralService) SpringGetBeanUtil.getBean("generalService");
    double sum = 0;
    Goodstablebean bean = new Goodstablebean();
%>

<div class="container">
    <table class="table table-hover">
        <tr>
            <th>商品名称</th>
            <th>图片</th>
            <th>单价</th>
            <th>数量</th>
            <th>选项</th>
        </tr>
        <%
            if (goodsMap != null) {
                for (Map.Entry entry : goodsMap.entrySet()) {
                    bean.setId((Integer) entry.getKey());
                    bean = (Goodstablebean) service.get(bean);
                    sum += bean.getPrice() * (int) entry.getValue();
        %>
        <tr>
            <td><%= bean.getName() %>
            </td>
            <td><img src="<%= bean.getImgUrl() %>" height="50" width="50"/>
            </td>
            <td><%= bean.getPrice()%>
            </td>
            <td><%= entry.getValue()%>
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


<nav class="navbar navbar-default navbar-fixed-bottom " role="navigati on">
    <div class="container ">
        <div class="navbar-right">
            <div class="navbar-nav">
                <b class="navbar-brand">一共 <%=sum%> 元</b>
            </div>
            <div class="navbar-nav navbar-right">
                <button class="btn btn-danger btn-pay-money" data-toggle="modal" data-target="#paymoney">付款</button>
            </div>
        </div>
    </div>
</nav>


<!-- 结算 -->
<div class="modal fade" id="paymoney" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">付款</h4>
            </div>
            <div class="panel-body">
                <div class="form-group">
                    送货地点 <input type="text" name="title" class="form-control" id="location">
                </div>
                <div class="form-group">
                    总价格：<%=sum%> 元
                </div>
                <div class="form-group">
                    备注 <input type="text" name="title" class="form-control" id="remark">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="pay">付款</button>
            </div>
        </div>
    </div>
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
        });

        $("#pay").click(function () {
            if ($('#location').val() == "") {
                alert("请输入送货地址");
            } else {
                $.ajax({
                    url: "pay",
                    type: "post",
                    data: {
                        "bean.location": $('#location').val(),
                        "bean.total":<%=sum%>,
                        "bean.remark": $('#remark').val()
                    }
                }).success(function () {
                    alert("购买成功");
                    location.reload();
                }).error(function () {
                    alert("商品余量不足");
                })
            }
        });
    })
</script>
</body>
</html>
