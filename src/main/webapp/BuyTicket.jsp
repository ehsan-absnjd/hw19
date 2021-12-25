<%--
  Created by IntelliJ IDEA.
  User: Frequency
  Date: 12/25/2021
  Time: 1:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>buy ticket</title>
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
<form action= "<%= request.getContextPath()%>/buyticket" method="post">
    <div class ="row">
        <div class="col-8">
            <div class="mb-3">
                <label for="fullName" class="form-label">full name</label>
                <input type="text" name="fullname" class="form-control" id="fullName" aria-describedby="emailHelp">
            </div>
            <div class="mb-3">
                <label for="male" class="form-check-label">male</label>
                <input type="radio" name="gender" class="form-check-input" id="male" aria-describedby="emailHelp" value="male">
                <label for="female" class="form-check-label">female</label>
                <input type="radio" name="gender" class="form-check-input" id="female" aria-describedby="emailHelp" value="female">
            </div>
            <input type="hidden" name="tripid" value="<%= request.getAttribute("tripid")%>">

        </div>
    </div>
<button type="submit" class="btn btn-primary">Add Trip</button>
</form>
</body>
</html>
