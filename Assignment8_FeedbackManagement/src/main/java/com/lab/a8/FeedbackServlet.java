package com.lab.a8;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submitFeedback")
public class FeedbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final FeedbackDAO dao = new FeedbackDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Server-side form validation
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        String ratingStr = request.getParameter("rating");

        if (name == null || name.trim().isEmpty()
                || email == null || !email.contains("@")
                || subject == null || subject.trim().isEmpty()
                || message == null || message.trim().isEmpty()
                || ratingStr == null) {
            request.setAttribute("error", "Please fill all fields correctly.");
            request.getRequestDispatcher("index.html").forward(request, response);
            return;
        }

        FeedbackBean fb = new FeedbackBean();
        fb.setName(name);
        fb.setEmail(email);
        fb.setSubject(subject);
        fb.setMessage(message);
        fb.setRating(Integer.parseInt(ratingStr));

        try {
            dao.saveFeedback(fb);
            request.setAttribute("name", name);
            request.getRequestDispatcher("success.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage(), e);
        }
    }
}
