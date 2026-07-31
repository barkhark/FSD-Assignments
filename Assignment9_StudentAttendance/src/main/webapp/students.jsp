<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.lab.a9.Student"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Students</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>

<div class="container">

    <nav>
        <a href="students">Students</a> |
        <a href="viewAttendance">View Attendance</a>
    </nav>

    <p class="visit-badge">
        Page visited <%= request.getAttribute("visitCount") %> time(s) this session
    </p>

    <h2>Student List</h2>

    <table>

        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Roll No</th>
        </tr>

        <%
            List<Student> students =
                (List<Student>) request.getAttribute("students");

            if (students != null) {
                for (Student s : students) {
        %>

        <tr>
            <td><%= s.getStudentId() %></td>
            <td><%= s.getStudentName() %></td>
            <td><%= s.getRollNo() %></td>
        </tr>

        <%
                }
            }
        %>

    </table>

    <div class="add-form">

        <h3>Add New Student</h3>

        <form action="students" method="post">

            <label>Name</label>
            <input type="text" name="studentName" required>

            <label>Roll No</label>
            <input type="text" name="rollNo" required>

            <button class="submit-btn" type="submit">
                Add Student
            </button>

        </form>

    </div>

</div>

</body>
</html>