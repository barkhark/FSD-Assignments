package com.lab.a8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeedbackDAO {
    public void saveFeedback(FeedbackBean fb) throws SQLException {
        String sql = "INSERT INTO feedback (name, email, subject, message, rating) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, fb.getName());
            ps.setString(2, fb.getEmail());
            ps.setString(3, fb.getSubject());
            ps.setString(4, fb.getMessage());
            ps.setInt(5, fb.getRating());
            ps.executeUpdate();
        }
    }
}
