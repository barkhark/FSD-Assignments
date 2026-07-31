<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lab.a10.Course" %>
<%@ page import="com.lab.a10.StudentUser" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Registration</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<%
    StudentUser student = (StudentUser) request.getAttribute("student");
    List<Course> registered = (List<Course>) request.getAttribute("registered");
    java.util.Set<Integer> registeredIds = new java.util.HashSet<>();
    if (registered != null) for (Course c : registered) registeredIds.add(c.getCourseId());
%>
<div class="container">
  <nav>
    Welcome, <%= student.getFullName() %> | <a href="logout">Logout</a>
  </nav>
  <h2>Available Courses</h2>
  <table>
    <tr><th>Code</th><th>Course Name</th><th>Seats</th><th>Action</th></tr>
    <%
        List<Course> courses = (List<Course>) request.getAttribute("courses");
        for (Course c : courses) {
    %>
    <tr>
      <td><%= c.getCourseCode() %></td>
      <td><%= c.getCourseName() %></td>
      <td><%= c.getSeats() %></td>
      <td>
        <% if (registeredIds.contains(c.getCourseId())) { %>
          <span class="registered-tag">Registered</span>
        <% } else { %>
          <form class="inline" action="registerCourse" method="post">
            <input type="hidden" name="courseId" value="<%= c.getCourseId() %>">
            <button class="btn add" type="submit">Register</button>
          </form>
        <% } %>
      </td>
    </tr>
    <% } %>
  </table>

  <h2>My Registered Courses</h2>
  <table>
    <tr><th>Code</th><th>Course Name</th></tr>
    <%
        if (registered != null && !registered.isEmpty()) {
            for (Course c : registered) {
    %>
    <tr><td><%= c.getCourseCode() %></td><td><%= c.getCourseName() %></td></tr>
    <%
            }
        } else {
    %>
    <tr><td colspan="2">No courses registered yet.</td></tr>
    <% } %>
  </table>
</div>
</body>
</html>
