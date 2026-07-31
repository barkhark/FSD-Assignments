<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Successful</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="container">
  <div class="success-icon">&#10004;</div>
  <h2>Registration Successful</h2>
  <table class="info-table">
    <tr><td>Name</td><td><%= request.getAttribute("name") %></td></tr>
    <tr><td>PRN</td><td><%= request.getAttribute("prn") %></td></tr>
    <tr><td>Email</td><td><%= request.getAttribute("email") %></td></tr>
    <tr><td>Mobile</td><td><%= request.getAttribute("mobile") %></td></tr>
    <tr><td>Course</td><td><%= request.getAttribute("course") %></td></tr>
  </table>
  <br>
  <a href="index.html">Register Another Student</a>
</div>
</body>
</html>
