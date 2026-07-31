<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.lab.a3.ResultBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<%
    ResultBean result = (ResultBean) request.getAttribute("result");
%>
<div class="container">
  <h2>Result of <%= result.getName() %></h2>
  <table class="info-table">
    <tr><td>Total Marks</td><td><%= result.getTotal() %> / 500</td></tr>
    <tr><td>Percentage</td><td><%= String.format("%.2f", result.getPercentage()) %>%</td></tr>
    <tr><td>Grade</td><td><%= result.getGrade() %></td></tr>
    <tr>
      <td>Status</td>
      <td class="<%= result.getStatus().equals("PASS") ? "pass" : "fail" %>">
        <%= result.getStatus() %>
      </td>
    </tr>
  </table>
  <br><a href="index.html">Enter Another Result</a>
</div>
</body>
</html>
