<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.lab.a9.Student"%>
<%@ page import="com.lab.a9.AttendanceRecord"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attendance</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>

<div class="container">

    <nav>
        <a href="students">Students</a> |
        <a href="viewAttendance">View Attendance</a>
    </nav>

    <h2>Attendance for <%= request.getAttribute("selectedDate") %></h2>

    <form action="viewAttendance" method="get" style="margin-bottom:20px;">
        <label>Select Date:</label>
        <input type="date" name="date"
            value="<%= request.getAttribute("selectedDate") %>">
        <button class="btn present" type="submit">Go</button>
    </form>

    <table>
        <tr>
            <th>Roll No</th>
            <th>Name</th>
            <th>Status</th>
        </tr>

        <%
            List<AttendanceRecord> records =
                (List<AttendanceRecord>) request.getAttribute("records");

            if (records != null) {
                for (AttendanceRecord r : records) {
        %>

        <tr>
            <td><%= r.getRollNo() %></td>
            <td><%= r.getStudentName() %></td>
            <td><%= r.getStatus() %></td>
        </tr>

        <%
                }
            }
        %>

    </table>

    <div class="add-form">

        <h3>Mark Attendance</h3>

        <form action="markAttendance" method="post">

            <label>Student</label>

            <select name="studentId" required>

            <%
                List<Student> students =
                    (List<Student>) request.getAttribute("students");

                if (students != null) {
                    for (Student s : students) {
            %>

                <option value="<%= s.getStudentId() %>">
                    <%= s.getStudentName() %> (<%= s.getRollNo() %>)
                </option>

            <%
                    }
                }
            %>

            </select>

            <label>Date</label>

            <input type="date"
                   name="attendanceDate"
                   value="<%= request.getAttribute("selectedDate") %>"
                   required>

            <label>Status</label>

            <select name="status" required>
                <option value="Present">Present</option>
                <option value="Absent">Absent</option>
            </select>

            <button class="submit-btn" type="submit">
                Mark Attendance
            </button>

        </form>

    </div>

</div>

</body>
</html>