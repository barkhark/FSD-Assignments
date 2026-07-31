package com.lab.a9;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/markAttendance")
public class MarkAttendanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final AttendanceDAO dao = new AttendanceDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            String status = request.getParameter("status");
            java.sql.Date date = java.sql.Date.valueOf(request.getParameter("attendanceDate"));
            dao.markAttendance(studentId, date, status);
            response.sendRedirect("viewAttendance?date=" + request.getParameter("attendanceDate"));
        } catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage(), e);
        }
    }
}
