package com.lab.a10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    /** Validates login and returns a StudentUser if valid, else null. */
    public StudentUser validateLogin(String username, String password) throws SQLException {
        String sql = "SELECT * FROM students WHERE username=? AND password=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new StudentUser(rs.getInt("student_id"), rs.getString("username"), rs.getString("full_name"));
                }
            }
        }
        return null;
    }

    public List<Course> getAllCourses() throws SQLException {
        String sql = "SELECT * FROM courses ORDER BY course_id";
        List<Course> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Course(rs.getInt("course_id"), rs.getString("course_name"),
                        rs.getString("course_code"), rs.getInt("seats")));
            }
        }
        return list;
    }

    public void registerCourse(int studentId, int courseId) throws SQLException {
        String sql = "INSERT IGNORE INTO registrations (student_id, course_id) VALUES (?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.executeUpdate();
        }
    }

    public List<Course> getRegisteredCourses(int studentId) throws SQLException {
        String sql = "SELECT c.* FROM courses c JOIN registrations r ON c.course_id = r.course_id "
                + "WHERE r.student_id = ? ORDER BY c.course_id";
        List<Course> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Course(rs.getInt("course_id"), rs.getString("course_name"),
                            rs.getString("course_code"), rs.getInt("seats")));
                }
            }
        }
        return list;
    }
}
