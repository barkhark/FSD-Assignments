package com.lab.a10;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/courses")
public class CourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final CourseDAO dao = new CourseDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        StudentUser student = (session != null) ? (StudentUser) session.getAttribute("student") : null;
        if (student == null) {
            response.sendRedirect("index.html");
            return;
        }
        try {
            List<Course> allCourses = dao.getAllCourses();
            List<Course> registered = dao.getRegisteredCourses(student.getStudentId());
            request.setAttribute("courses", allCourses);
            request.setAttribute("registered", registered);
            request.setAttribute("student", student);
            request.getRequestDispatcher("courses.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage(), e);
        }
    }
}
