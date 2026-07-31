package com.lab.a10;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/registerCourse")
public class RegisterCourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final CourseDAO dao = new CourseDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        StudentUser student = (session != null) ? (StudentUser) session.getAttribute("student") : null;
        if (student == null) {
            response.sendRedirect("index.html");
            return;
        }
        try {
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            dao.registerCourse(student.getStudentId(), courseId);
            response.sendRedirect("courses");
        } catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage(), e);
        }
    }
}
