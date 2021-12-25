<%@ page import="ir.maktab.ticketsystem.entity.Trip" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Frequency
  Date: 12/25/2021
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>trips</title>
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
<form action= "<%= request.getContextPath()%>/findtrips" method="post">
    <div class ="row">
        <div class="col-3">
            <div class="mb-3">
                <label for="origin" class="form-label">origin</label>
                <input type="text" name="origin" class="form-control" id="origin" aria-describedby="emailHelp">
            </div>
        </div>
        <div class="col-3">
            <div class="mb-3">
                <label for="destination" class="form-label">destination</label>
                <input type="text" name="destination" class="form-control" id="destination">
            </div>
        </div>
        <div class="col-2">
            <div class="mb-3">
                <label for="date" class="form-label">date</label>
                <input type="text" name="date" class="form-control" id="date">
            </div>
        </div>
    </div>
    <button type="submit" class="btn btn-primary mb-3 col-2">search</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">trip id</th>
        <th scope="col">origin</th>
        <th scope="col">destination</th>
        <th scope="col">date</th>
        <th scope="col">time</th>
        <th scope="col">buy!</th>
    </tr>
    </thead>
        <% List<Trip> trips = (List<Trip>) request.getAttribute("trips");
if (trips!=null){
    for (Trip trip : trips){ %>
<tr>
    <td><%= trip.getId() %></td>
    <td><%= trip.getOrigin() %></td>
    <td><%= trip.getDestination() %></td>
    <td><%= trip.getDate() %></td>
    <td><%= trip.getTime() %></td>
    <td><a href="<%=request.getContextPath()%>/buyticket?tripid=<%= trip.getId()%>" >click to buy</td>
</tr>

<%} }%>
    </table>
</body>
</html>
