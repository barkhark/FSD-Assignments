package com.lab.a9;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewAttendance")
public class ViewAttendanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final AttendanceDAO dao = new AttendanceDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String dateParam = request.getParameter("date");
            java.sql.Date date = (dateParam == null || dateParam.isEmpty())
                    ? java.sql.Date.valueOf(LocalDate.now())
                    : java.sql.Date.valueOf(dateParam);

            List<AttendanceRecord> records = dao.getAttendanceByDate(date);
            List<Student> students = dao.getAllStudents();

            request.setAttribute("records", records);
            request.setAttribute("students", students);
            request.setAttribute("selectedDate", date.toString());
            request.getRequestDispatcher("attendance.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage(), e);
        }
    }
}
