package com.lab.a3;

public class ResultBean {
    private String name;
    private int m1, m2, m3, m4, m5;
    private int total;
    private double percentage;
    private String grade;
    private String status;

    public ResultBean(String name, int m1, int m2, int m3, int m4, int m5) {
        this.name = name;
        this.m1 = m1; this.m2 = m2; this.m3 = m3; this.m4 = m4; this.m5 = m5;
        calculate();
    }

    private void calculate() {
        total = m1 + m2 + m3 + m4 + m5;
        percentage = total / 5.0;

        // Grade calculation based on percentage
        if (percentage >= 90) grade = "A+";
        else if (percentage >= 80) grade = "A";
        else if (percentage >= 70) grade = "B";
        else if (percentage >= 60) grade = "C";
        else if (percentage >= 50) grade = "D";
        else grade = "F";

        // Pass/Fail: fail if any subject < 40 or overall percentage < 40
        boolean anyFail = (m1 < 40 || m2 < 40 || m3 < 40 || m4 < 40 || m5 < 40);
        status = (anyFail || percentage < 40) ? "FAIL" : "PASS";
    }

    public String getName() { return name; }
    public int getTotal() { return total; }
    public double getPercentage() { return percentage; }
    public String getGrade() { return grade; }
    public String getStatus() { return status; }
}
