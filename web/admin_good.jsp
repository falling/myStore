<%@ page import="bean.Goodstablebean" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>管理员页面</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding: 70px 0 0 0;
            font-family: "微软雅黑";
        }
    </style>
</head>
<body>
<!-- 导航栏 -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <b class="navbar-brand">后台管理</b>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="#">管理商品</a></li>
            <li><a href="#">未接订单</a></li>
            <li><a href="#">已接订单</a></li>
            <li><a href="#">已完成订单</a></li>
            <li><a href="#">报表</a></li>
        </ul>
        <form class="navbar-form navbar-right">
            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#addGood">
                添加商品
            </button>
        </form>
    </div>
</nav>
<%
    List<Goodstablebean> goodsList = (List<Goodstablebean>) request.getAttribute("goodsList");
%>
<%-- 这个页面 --%>
<div class="container">
    <table class="table table-hover">
        <tr>
            <th>商品名称</th>
            <th>图片</th>
            <th>价格</th>
            <th>类型</th>
            <th>剩余</th>
            <th>选项</th>
        </tr>
        <%
            for (Goodstablebean good : goodsList) {
        %>
        <tr>
            <td><%= good.getName() %>
            </td>
            <td><img src="<%= good.getImgUrl() %>"/>
            </td>
            <td><%= good.getPrice()%>
            </td>
            <td><%= good.getType() %>
            </td>
            <td><%= good.getLeft() %>
            </td>
            <td data-foodId= <%= good.getId() %>>
                <button class="btn btn-danger btn-delete-food">删除</button>
                <button type="button" class="btn btn-warning btn-update-good" data-toggle="modal" data-target="#updateGood">
                    修改
                </button>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>

<!-- 添加食物窗口 -->
<div class="modal fade" id="addGood" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加商品</h4>
            </div>
            <div class="form-inline">
                <div class="form-group">
                    商品名称 <input type="text" name="title" class="form-control" id="add-foodname">
                </div>
                <div class="form-group">
                    商品价格 <input type="text" name="title" class="form-control" id="add-foodprice">
                </div>
                <div class="form-group">
                    类型
                    <select class="form-control" id="add-foodType">
                        <option>饮料</option>
                        <option>肉类</option>
                        <option>素类</option>
                    </select>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="add-do">创建</button>
            </div>
        </div>
    </div>
</div>

<!-- 修改商品 -->
<div class="modal fade" id="updateGood" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改商品</h4>
            </div>
            <div class="form-inline">
                <div class="form-group">
                    商品名称 <input type="text" name="title" class="form-control" id="update-foodname">
                </div>
                <div class="form-group">
                    商品价格 <input type="text" name="title" class="form-control" id="update-goodprice">
                </div>
                <div class="form-group">
                    剩下数量 <input type="text" name="title" class="form-control" id="update-goodprice">
                </div>
                <div class="form-group">
                    类型
                    <select class="form-control" id="update-foodType">
                        <option>饮料</option>
                        <option>肉类</option>
                        <option>素类</option>
                    </select>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="update-do">更新</button>
            </div>
        </div>
    </div>
</div>

<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script>
    $(function () {

        //增加新Food
        $('#add-do').click(function () {
            $.ajax({
                url: "/addFood",
                type: 'post',
                data: {
                    foodname:$('#add-foodname').val(),
                    foodprice:$('#add-foodprice').val(),
                    foodtype:$('#add-foodType').val()
                }
            }).success(function () {
                alert("成功");
               location.reload("/adminFood");
            });
        });

        $(".btn-delete-food").click(function(){
            var foodid = $(this).parent().attr("data-foodId");
            $.ajax({
                url: "/deleteFood",
                type: 'post',
                data: {
                    id:foodid
                }
            }).success(function () {
                alert("删除成功");
                location.reload("/adminFood");
            });
        });


        //搬运数据
        var foodid = 0;
        $(".btn-update-food").click(function(){
            foodid = $(this).parent().attr("data-foodId");

            var $tr = $(this).parent().prevAll();

            $('#update-foodprice').val($tr.eq(1).html());
            $('#update-foodname').val($tr.eq(2).html());

            if( $tr.eq(0).html().trim() == '荤'){
                $('#update-foodType option').eq(0).attr("selected","selected");
            }
            else {
                $('#update-foodType option').eq(1).attr("selected","selected");
            }
        });

        $('#update-do').click(function () {
            $.ajax({
                url: "/updateFood",
                type: 'post',
                data: {
                    id:foodid,
                    foodname:$('#update-foodname').val(),
                    foodprice:$('#update-foodprice').val(),
                    foodtype:$('#update-foodType').val()
                }
            }).success(function () {
                alert("修改成功");
                location.reload("/adminFood");
            });
        });
    })
</script>

</body>
</html>