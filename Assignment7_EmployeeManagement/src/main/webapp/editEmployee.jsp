<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.lab.a7.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<%
    Employee emp = (Employee) request.getAttribute("employee");
%>
<div class="container">
  <h2>Edit Employee</h2>
  <div class="add-form">
    <form action="employees" method="post">
      <input type="hidden" name="action" value="update">
      <input type="hidden" name="empId" value="<%= emp.getEmpId() %>">
      <label>Name</label>
      <input type="text" name="empName" value="<%= emp.getEmpName() %>" required>
      <label>Department</label>
      <input type="text" name="department" value="<%= emp.getDepartment() %>" required>
      <label>Designation</label>
      <input type="text" name="designation" value="<%= emp.getDesignation() %>" required>
      <label>Salary</label>
      <input type="number" step="0.01" name="salary" value="<%= emp.getSalary() %>" required>
      <button class="submit-btn" type="submit">Update Employee</button>
    </form>
  </div>
  <br><a href="employees?action=list">Back to List</a>
</div>
</body>
</html>
