//package com.stemlink.tutor.model;
//
//import java.time.LocalDateTime;
//import java.util.Objects;
//
//public class Booking {
//    private static int bookingCounter = 1;
//
//    private final String bookingId;
//    private final String studentId;
//    private final String mentorId;
//    private final String subject;
//    private final LocalDateTime scheduledTime;
//    private final int durationHours;
//    private final LocalDateTime createdAt;
//    private final String status;
//
//    public Booking(String studentId, String mentorId, String subject,
//                   LocalDateTime scheduledTime, int durationHours) {
//
//        this.bookingId = String.format("BK-%03d", bookingCounter++);
//
//        this.studentId = studentId;
//        this.mentorId = mentorId;
//        this.subject = subject;
//        this.scheduledTime = scheduledTime;
//        this.durationHours = durationHours;
//
//        this.createdAt = LocalDateTime.now();
//        this.status = "PENDING";
//    }
//
//    // Getters for all fields
//    public String getBookingId() { return bookingId; }
//    public String getStudentId() { return studentId; }
//    public String getMentorId() { return mentorId; }
//    public String getSubject() { return subject; }
//    public LocalDateTime getScheduledTime() { return scheduledTime; }
//    public int getDurationHours() { return durationHours; }
//    public LocalDateTime getCreatedAt() { return createdAt; }
//    public String getStatus() { return status; }
//
//    public String getBookingDetails() {
//        return "Booking ID: " + bookingId +
//                "\nStudent: " + studentId + " | Mentor: " + mentorId +
//                "\nSubject: " + subject +
//                "\nScheduled: " + scheduledTime +
//                "\nDuration: " + durationHours + " hours" +
//                "\nStatus: " + status +
//                "\nCreated: " + createdAt;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (!(obj instanceof com.stemlink.tutor.Booking)) return false;
//        com.stemlink.tutor.Booking other = (com.stemlink.tutor.Booking) obj;
//        return this.bookingId.equals(other.bookingId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(bookingId);
//    }
//}
