package com.lab.a8;

public class FeedbackBean {
    private String name;
    private String email;
    private String subject;
    private String message;
    private int rating;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
}
