<%@ page import="ir.maktab.ticketsystem.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Frequency
  Date: 12/24/2021
  Time: 9:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if (!((User)session.getAttribute("user") ).isAdmin() ){
    request.getRequestDispatcher("/").forward(request,response);
}
%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Home</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="<%= request.getContextPath()%>/logout">log out</a>
    </div>
</nav>
<% Object error = request.getAttribute("error");
    if(error!=null) {%>
<div class="alert alert-danger" role="alert">
    <%= error%>
</div>
<% }%>
<form action= "<%= request.getContextPath()%>/addtrip" method="post">
    <div class ="row">
        <div class="col-8">
<div class="mb-3">
    <label for="origin" class="form-label">origin</label>
    <input type="text" name="origin" class="form-control" id="origin" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="destination" class="form-label">destination</label>
    <input type="text" name="destination" class="form-control" id="destination">
</div>
<div class="mb-3">
    <label for="date" class="form-label">date</label>
    <input type="text" name="date" class="form-control" id="date">
</div>
<div class="mb-3">
    <label for="time" class="form-label">time</label>
    <input type="text" name="time" class="form-control" id="time">
</div>
        </div>
    </div>


<button type="submit" class="btn btn-primary">Add Trip</button>
</form>
</body>
</html>
