package com.lab.a9;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final AttendanceDAO dao = new AttendanceDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Track number of visits using session (session handling demo)
        HttpSession session = request.getSession();
        Integer visits = (Integer) session.getAttribute("visitCount");
        session.setAttribute("visitCount", visits == null ? 1 : visits + 1);

        try {
            List<Student> students = dao.getAllStudents();
            request.setAttribute("students", students);
            request.setAttribute("visitCount", session.getAttribute("visitCount"));
            request.getRequestDispatcher("students.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Student s = new Student();
            s.setStudentName(request.getParameter("studentName"));
            s.setRollNo(request.getParameter("rollNo"));
            dao.addStudent(s);
            response.sendRedirect("students");
        } catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage(), e);
        }
    }
}
