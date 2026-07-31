<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<div class="container">
    <h2>User Login</h2>

    <% if(request.getAttribute("error") != null) { %>
        <p style="color:red; text-align:center;">
            <%= request.getAttribute("error") %>
        </p>
    <% } %>

    <form action="login" method="post">

        <label>Username:</label>
        <input type="text" name="username" required>

        <label>Password:</label>
        <input type="password" name="password" required>

        <button type="submit">Login</button>

    </form>
</div>

</body>
</html>