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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="<%= request.getContextPath()%>/findtrips">find trip</a>
    </div>
    <div class="container-fluid">
        <a class="navbar-brand" href="<%= request.getContextPath()%>/seetickets">see tickets</a>
    </div>
    <div class="container-fluid">
        <a class="navbar-brand" href="<%= request.getContextPath()%>/logout">log out</a>
    </div>
</nav>
<% Object message = request.getAttribute("message");
    if(message!=null) {%>
<div class="alert alert-secondary" role="alert">
    <%= message%>
</div>
<% } %>

</body>
</html>
