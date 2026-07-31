<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salary Slip</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="container">
  <h2>Salary Slip - <%= request.getAttribute("name") %></h2>
  <table class="info-table">
    <tr><td>Basic Salary</td><td>&#8377; <%= String.format("%.2f", (Double) request.getAttribute("basic")) %></td></tr>
    <tr><td>HRA (20%)</td><td>&#8377; <%= String.format("%.2f", (Double) request.getAttribute("hra")) %></td></tr>
    <tr><td>DA (30%)</td><td>&#8377; <%= String.format("%.2f", (Double) request.getAttribute("da")) %></td></tr>
    <tr><td>Gross Salary</td><td>&#8377; <%= String.format("%.2f", (Double) request.getAttribute("gross")) %></td></tr>
    <tr><td>PF Deduction (12%)</td><td>&#8377; <%= String.format("%.2f", (Double) request.getAttribute("pf")) %></td></tr>
    <tr><td>Tax Deduction</td><td>&#8377; <%= String.format("%.2f", (Double) request.getAttribute("tax")) %></td></tr>
    <tr><td>Net Salary</td><td class="net">&#8377; <%= String.format("%.2f", (Double) request.getAttribute("net")) %></td></tr>
  </table>
  <br><a href="index.html">Calculate Another</a>
</div>
</body>
</html>
