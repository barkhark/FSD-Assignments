package com.lab.a9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

    public void addStudent(Student s) throws SQLException {
        String sql = "INSERT INTO students (student_name, roll_no) VALUES (?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, s.getStudentName());
            ps.setString(2, s.getRollNo());
            ps.executeUpdate();
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        String sql = "SELECT * FROM students ORDER BY student_id";
        List<Student> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Student(rs.getInt("student_id"), rs.getString("student_name"), rs.getString("roll_no")));
            }
        }
        return list;
    }

    public void markAttendance(int studentId, java.sql.Date date, String status) throws SQLException {
        String sql = "INSERT INTO attendance (student_id, attendance_date, status) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setDate(2, date);
            ps.setString(3, status);
            ps.executeUpdate();
        }
    }

    public List<AttendanceRecord> getAttendanceByDate(java.sql.Date date) throws SQLException {
        String sql = "SELECT a.attendance_id, a.student_id, s.student_name, s.roll_no, a.attendance_date, a.status "
                + "FROM attendance a JOIN students s ON a.student_id = s.student_id "
                + "WHERE a.attendance_date = ? ORDER BY s.roll_no";
        List<AttendanceRecord> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, date);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    AttendanceRecord r = new AttendanceRecord();
                    r.setAttendanceId(rs.getInt("attendance_id"));
                    r.setStudentId(rs.getInt("student_id"));
                    r.setStudentName(rs.getString("student_name"));
                    r.setRollNo(rs.getString("roll_no"));
                    r.setAttendanceDate(rs.getDate("attendance_date"));
                    r.setStatus(rs.getString("status"));
                    list.add(r);
                }
            }
        }
        return list;
    }
}
