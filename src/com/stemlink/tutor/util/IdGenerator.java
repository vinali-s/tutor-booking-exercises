package com.stemlink.tutor.util;

public class IdGenerator {
    private static int studentCounter = 1;
    private static int mentorCounter = 1;
    private static int bookingCounter = 1;

    public static synchronized String generateStudentId() {
        String id = String.format("STU-%03d", studentCounter++);
        return id;
    }

    public static synchronized String generateMentorId() {
        String id = String.format("MEN-%03d", mentorCounter++);
        return id;
    }

    public static synchronized String generateBookingId() {
        String id = String.format("BK-%03d", bookingCounter++);
        return id;
    }

    // Prevent instantiation
    private IdGenerator() {}
}