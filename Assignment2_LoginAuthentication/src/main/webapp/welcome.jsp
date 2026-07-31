<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // JSP Implicit object "session" used directly
    String user = (String) session.getAttribute("username");
    if (user == null) {
        response.sendRedirect("index.html");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="container welcome-box">
  <h2>Welcome, <%= user %>!</h2>
  <p>You have successfully logged in.</p>
  <p>Session ID: <%= session.getId() %></p>
  <a class="logout-btn" href="logout">Logout</a>
</div>
</body>
</html>
