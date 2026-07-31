<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lab.a7.model.Employee" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="container">
  <h2>Employee Management System (MVC)</h2>

  <form class="search-box" action="employees" method="get">
    <input type="hidden" name="action" value="search">
    <input type="text" name="keyword" placeholder="Search by name, department or designation">
    <button class="btn edit" type="submit">Search</button>
    <a class="btn" style="background:#7f8c8d;" href="employees?action=list">Reset</a>
  </form>

  <table>
    <tr><th>ID</th><th>Name</th><th>Department</th><th>Designation</th><th>Salary</th><th>Actions</th></tr>
    <%
    @SuppressWarnings("unchecked")
    List<Employee> employees = (List<Employee>) request.getAttribute("employees");
    if (employees != null) {
            for (Employee e : employees) {
    %>
    <tr>
      <td><%= e.getEmpId() %></td>
      <td><%= e.getEmpName() %></td>
      <td><%= e.getDepartment() %></td>
      <td><%= e.getDesignation() %></td>
      <td>&#8377; <%= e.getSalary() %></td>
      <td>
        <a class="btn edit" href="employees?action=edit&id=<%= e.getEmpId() %>">Edit</a>
        <a class="btn delete" href="employees?action=delete&id=<%= e.getEmpId() %>" onclick="return confirm('Delete this employee?');">Delete</a>
      </td>
    </tr>
    <% } } %>
  </table>

  <div class="add-form">
    <h3>Add New Employee</h3>
    <form action="employees" method="post">
      <input type="hidden" name="action" value="add">
      <label>Name</label>
      <input type="text" name="empName" required>
      <label>Department</label>
      <input type="text" name="department" required>
      <label>Designation</label>
      <input type="text" name="designation" required>
      <label>Salary</label>
      <input type="number" step="0.01" name="salary" required>
      <button class="submit-btn" type="submit">Add Employee</button>
    </form>
  </div>
</div>
</body>
</html>
