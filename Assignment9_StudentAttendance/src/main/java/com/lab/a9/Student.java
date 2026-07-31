package com.lab.a9;

public class Student {
    private int studentId;
    private String studentName;
    private String rollNo;

    public Student() {}
    public Student(int studentId, String studentName, String rollNo) {
        this.studentId = studentId; this.studentName = studentName; this.rollNo = rollNo;
    }
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public String getRollNo() { return rollNo; }
    public void setRollNo(String rollNo) { this.rollNo = rollNo; }
}
