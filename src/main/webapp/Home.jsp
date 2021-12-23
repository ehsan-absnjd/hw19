<%@ page import="ir.maktab.ticketsystem.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Frequency
  Date: 12/23/2021
  Time: 10:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<% if(((User)session.getAttribute("user")).isAdmin() ) { %>
admin page

<% } else { %>
normal user
<% }%>

</body>
</html>
