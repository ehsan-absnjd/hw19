<%@ page import="ir.maktab.ticketsystem.entity.Ticket" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Frequency
  Date: 12/25/2021
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tickets</title>
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
<table class="table">
    <thead>
    <tr>
        <th scope="col">ticket id</th>
        <th scope="col">trip id</th>
        <th scope="col">origin</th>
        <th scope="col">destination</th>
        <th scope="col">date</th>
        <th scope="col">time</th>
        <th scope="col">full name</th>
        <th scope="col">gender</th>
        <th scope="col">delete!</th>
    </tr>
    </thead>
        <% List<Ticket> tickets = (List<Ticket>) request.getAttribute("tickets");
if (tickets!=null){
    for (Ticket ticket : tickets){ %>
    <tr>
        <th scope="col"> <%= ticket.getId()%></th>
        <th scope="col"><%= ticket.getTrip().getId()%></th>
        <th scope="col"><%= ticket.getTrip().getOrigin()%></th>
        <th scope="col"><%= ticket.getTrip().getDestination()%></th>
        <th scope="col"><%= ticket.getTrip().getDate()%></th>
        <th scope="col"><%= ticket.getTrip().getTime()%></th>
        <th scope="col"><%= ticket.getFullName()%></th>
        <th scope="col"><%= ticket.isGender() ? "male" : "female"%></th>
        <td><a href="<%=request.getContextPath()%>/deleteticket?ticketid=<%= ticket.getId()%>" >click to delete </a> </td>
    </tr>
    <% }}%>
</table>
</body>
</html>
