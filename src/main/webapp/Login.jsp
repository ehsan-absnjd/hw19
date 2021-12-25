<%--
  Created by IntelliJ IDEA.
  User: Frequency
  Date: 12/23/2021
  Time: 6:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<% Object error = request.getAttribute("error");
    if(error!=null) {%>
<div class="alert alert-danger" role="alert">
    <%= error%>
</div>
<% }%>
<form action= "<%= request.getContextPath()%>/login" method="post">
    <div class ="row">
        <div class="col-8">
            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" name="username" class="form-control" id="username" aria-describedby="emailHelp">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" name="password" class="form-control" id="password">
            </div>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
</form>

<form class="mt-5" action= "<%= request.getContextPath()%>/register" method="post">
    <div class ="row">
        <div class="col-8">
            <div class="mb-3">
                <label for="username2" class="form-label">Username</label>
                <input type="text" name="username" class="form-control" id="username2" aria-describedby="emailHelp">
            </div>
            <div class="mb-3">
                <label for="password2" class="form-label">Password</label>
                <input type="password" name="password" class="form-control" id="password2">
            </div>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Register</button>
</form>

</body>
</html>
