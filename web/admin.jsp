<%@ page import="bean.Usertablebean" %><%--
  Created by IntelliJ IDEA.
  User: falling
  Date: 2016/6/2
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理界面</title>
</head>
<body>
<%
    Usertablebean user = (Usertablebean) request.getSession().getAttribute("user");
%>
admin<%=user.getName()%>
</body>
</html>
