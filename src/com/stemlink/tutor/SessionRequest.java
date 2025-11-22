package com.stemlink.tutor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class SessionRequest {

    // Final fields
    private final String studentId;
    private final String mentorId;
    private final String subject;

    // ... other fields
    private String sessionNotes;
    private List<String> materialsNeeded;
    private boolean isUrgent;
    private LocalDateTime preferredTime;
    private int maxStudents;

    // Private constructor
    private SessionRequest(Builder builder) {
        this.studentId = builder.studentId;
        this.mentorId = builder.mentorId;
        this.subject = builder.subject;

        this.sessionNotes = builder.sessionNotes;
        this.materialsNeeded = new ArrayList<>(builder.materialsNeeded);
        this.isUrgent = builder.isUrgent;
        this.preferredTime = builder.preferredTime;
        this.maxStudents = builder.maxStudents;
    }

    // Getters only
    public String getStudentId() { return studentId; }
    public String getMentorId() { return mentorId; }
    public String getSubject() { return subject; }
    public String getSessionNotes() { return sessionNotes; }
    public List<String> getMaterialsNeeded() { return new ArrayList<>(materialsNeeded); }
    public boolean isUrgent() { return isUrgent; }
    public LocalDateTime getPreferredTime() { return preferredTime; }
    public int getMaxStudents() { return maxStudents; }


    @Override
    public String toString() {
        String type = (maxStudents > 1)
                ? "Group (max " + maxStudents + " students)"
                : "Individual";

        return "SessionRequest {\n" +
                "  Student: " + studentId + " | Mentor: " + mentorId + "\n" +
                "  Subject: " + subject + "\n" +
                "  Type: " + type + " | Urgent: " + (isUrgent ? "Yes" : "No") + "\n" +
                "  Notes: " + (sessionNotes.isEmpty() ? "(none)" : sessionNotes) + "\n" +
                "  Materials: " + (materialsNeeded.isEmpty() ? "(none)" : materialsNeeded) + "\n" +
                "  Preferred Time: " + (preferredTime == null ? "Not specified" : preferredTime) + "\n" +
                "}";
    }

    // Static nested Builder class
    public static class Builder {

        // Required parameters (final)
        private final String studentId;
        private final String mentorId;
        private final String subject;

        // Optional parameters (with defaults)
        private String sessionNotes = "";
        private List<String> materialsNeeded = new ArrayList<>();
        private boolean isUrgent = false;
        private LocalDateTime preferredTime = null;
        private int maxStudents = 1;

        // Constructor with required parameters
        public Builder(String studentId, String mentorId, String subject) {
            this.studentId = studentId;
            this.mentorId = mentorId;
            this.subject = subject;
        }

        // Fluent setter methods
        public Builder sessionNotes(String notes) {
            this.sessionNotes = notes;
            return this;
        }

        public Builder materialsNeeded(List<String> materials) {
            this.materialsNeeded = new ArrayList<>(materials);
            return this;
        }

        public Builder isUrgent(boolean urgent) {
            this.isUrgent = urgent;
            return this;
        }

        public Builder preferredTime(LocalDateTime time) {
            this.preferredTime = time;
            return this;
        }

        public Builder maxStudents(int count) {
            this.maxStudents = count;
            return this;
        }

        // Build with validation
        public SessionRequest build() {

            // Subject must not be empty
            if (subject == null || subject.trim().isEmpty()) {
                throw new IllegalArgumentException("Subject cannot be empty");
            }

            // Group session validation
            if ( maxStudents < 1) {
                throw new IllegalArgumentException("Group sessions must allow at least 2 students");
            }

            // Urgent validation
            if (isUrgent && preferredTime != null) {
                LocalDateTime maxAllowed = LocalDateTime.now().plusDays(7);
                if (preferredTime.isAfter(maxAllowed)) {
                    throw new IllegalArgumentException("Urgent sessions must be scheduled within 7 days");
                }
            }

            return new SessionRequest(this);
        }
    }
}

