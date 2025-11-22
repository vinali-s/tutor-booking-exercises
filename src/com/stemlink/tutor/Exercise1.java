package com.stemlink.tutor;

public class Exercise1 {
    public static void main(String[] args) {
        System.out.println("Creating students...");

        // TODO: Create 3 students
        // TODO: Print each student's details
        Student s1 = new Student("Alice Johnson", "alice@email.com");
        System.out.println("Student created: " + s1.getDetails());

        Student s2 = new Student("Bob Smith", "bob@email.com");
        System.out.println("Student created: " + s2.getDetails());

        Student s3 = new Student("Carol White", "carol@email.com");
        System.out.println("Student created: " + s3.getDetails());

        Student s4 = new Student("jane Root", "jane@email.com");

        System.out.println();
        // TODO: Print total students using static method
        System.out.println("Total students registered: " + Student.getTotalStudents());


    }
}

class Student {
    // TODO: Implement according to requirements
    // Instance variables
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