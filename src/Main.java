import com.stemlink.tutor.model.Booking;
import com.stemlink.tutor.model.Mentor;
import com.stemlink.tutor.model.Student;
import com.stemlink.tutor.model.Subject;
import com.stemlink.tutor.util.BookingValidator;
import com.stemlink.tutor.util.FeeCalculator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BookingSystem {
    // Store created objects (in-memory)
    private static final List<Student> students = new ArrayList<>();
    private static final List<Mentor> mentors = new ArrayList<>();
    private static final List<Subject> subjects = new ArrayList<>();
    private static final List<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   STEM Link Tutor Booking System     ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        // 1. Initialize platform with subjects
        initializeSubjects();

        // 2. Register students and mentors
        registerUsers();

        // 3. Create bookings
        createBookings();

        // 4. Display system statistics
        displayStatistics();
    }

    private static void initializeSubjects() {
        System.out.println("📚 Initializing subjects...");
        // TODO: Create 5 different subjects
        // Example: new Subject("JAVA-01", "Core Java OOP", 40, "PROGRAMMING")
    }

    private static void registerUsers() {
        System.out.println("\n👥 Registering users...");
        // TODO: Create 3 students and 3 mentors
    }

    private static void createBookings() {
        System.out.println("\n📅 Creating bookings...");
        // TODO: Create 5 different bookings
        // - At least one should fail validation
        // - Use different booking times and durations
        // - Calculate and display fees
    }

    private static void displayStatistics() {
        System.out.println("\n📊 System Statistics");
        System.out.println("═══════════════════════════════════════");
        // TODO: Display:
        // - Total students registered
        // - Total mentors registered
        // - Total subjects available
        // - Total bookings created
        // - Total revenue (sum of all booking fees)
        // - Average booking duration
    }

    // Helper method to create and validate a booking
    private static void attemptBooking(
            String studentId,
            String mentorId,
            String subject,
            LocalDateTime scheduledTime,
            int duration
    ) {
        System.out.println("\n  Attempting booking:");
        System.out.println("    Student: " + studentId);
        System.out.println("    Mentor: " + mentorId);
        System.out.println("    Subject: " + subject);
        System.out.println("    Time: " + scheduledTime);
        System.out.println("    Duration: " + duration + " hours");

        // Validate
        if (!BookingValidator.isValidBookingTime(scheduledTime)) {
            System.out.println("    ❌ Invalid booking time (must be in future)");
            return;
        }

        if (!BookingValidator.isValidDuration(duration)) {
            System.out.println("    ❌ Invalid duration (must be 1-4 hours)");
            return;
        }

        // Create booking
        Booking booking = new Booking(studentId, mentorId, subject, scheduledTime, duration);
        bookings.add(booking);

        // Calculate fees
        double baseFee = FeeCalculator.calculateBaseFee("STANDARD", duration);
        double platformFee = FeeCalculator.calculatePlatformFee(baseFee);
        double total = baseFee + platformFee;

        System.out.println("    ✅ Booking created: " + booking.getBookingId());
        System.out.println("    💰 Fees - Base: LKR " + baseFee +
                " | Platform: LKR " + platformFee +
                " | Total: LKR " + total);
    }
}
