package com.lab.a1;

import java.io.Serializable;

/**
 * Simple JavaBean representing a Student.
 */
public class StudentBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String prn;
    private String email;
    private String mobile;
    private String course;

    public StudentBean() {}

    public StudentBean(String name, String prn, String email, String mobile, String course) {
        this.name = name;
        this.prn = prn;
        this.email = email;
        this.mobile = mobile;
        this.course = course;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPrn() { return prn; }
    public void setPrn(String prn) { this.prn = prn; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
}
