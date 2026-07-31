package com.lab.a1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Handles the student registration form submission (Request Object usage).
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Read form data using the Request object
        String name = request.getParameter("name");
        String prn = request.getParameter("prn");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String course = request.getParameter("course");

        // Populate a JavaBean
        StudentBean student = new StudentBean(name, prn, email, mobile, course);

        // Forward data as request attributes
        request.setAttribute("name", student.getName());
        request.setAttribute("prn", student.getPrn());
        request.setAttribute("email", student.getEmail());
        request.setAttribute("mobile", student.getMobile());
        request.setAttribute("course", student.getCourse());

        request.getRequestDispatcher("success.jsp").forward(request, response);
    }
}
