package com.lab.a10;

public class Course {
    private int courseId;
    private String courseName;
    private String courseCode;
    private int seats;

    public Course(int courseId, String courseName, String courseCode, int seats) {
        this.courseId = courseId; this.courseName = courseName;
        this.courseCode = courseCode; this.seats = seats;
    }
    public int getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getCourseCode() { return courseCode; }
    public int getSeats() { return seats; }
}
