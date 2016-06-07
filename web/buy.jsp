<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: falling
  Date: 2016/6/7
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>buy</title>
</head>
<body>
<%
    List goods = (List) request.getSession().getAttribute("list");
    for (int i = 0; i < goods.size(); i++) {
        out.print(goods.get(i));
    }
%>
</body>
</html>
