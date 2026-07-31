package com.lab.a10;

public class StudentUser {
    private int studentId;
    private String username;
    private String fullName;

    public StudentUser(int studentId, String username, String fullName) {
        this.studentId = studentId; this.username = username; this.fullName = fullName;
    }
    public int getStudentId() { return studentId; }
    public String getUsername() { return username; }
    public String getFullName() { return fullName; }
}
