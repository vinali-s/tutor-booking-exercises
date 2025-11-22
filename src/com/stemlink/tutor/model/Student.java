package com.stemlink.tutor.model;

public class Student {
    private final String studentId;   // STU-001 format
    private String name;
    private String email;

    // Static variables
    private static int totalStudents = 0;
    private static int studentCounter = 1;

    public Student(String name, String email) {
        this.name = name;
        this.email = email;

        this.studentId = String.format("STU-%03d", studentCounter);

        studentCounter++;
        totalStudents++;
    }

    public String getDetails() {
        return studentId + ", " + name + ", " + email;
    }

    public static int getTotalStudents() {
        return totalStudents;
    }
}
