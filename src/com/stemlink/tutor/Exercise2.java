package com.stemlink.tutor;

import com.stemlink.tutor.util.BookingValidator;
import com.stemlink.tutor.util.DateTimeFormatterUtil;
import com.stemlink.tutor.util.FeeCalculator;

import java.time.LocalDateTime;

public class Exercise2 {
    public static void main(String[] args) {
        // Test BookingValidator
        System.out.println("=== Testing BookingValidator ===");
        LocalDateTime futureTime = LocalDateTime.now().plusDays(2);
        System.out.println("Future time valid? " +
                BookingValidator.isValidBookingTime(futureTime));
        System.out.println("3 hours valid? " +
                BookingValidator.isValidDuration(3));
        System.out.println("5 hours valid? " +
                BookingValidator.isValidDuration(5));

        // Test FeeCalculator
        System.out.println("\n=== Testing FeeCalculator ===");
        System.out.println("Standard 2h: LKR " +
                FeeCalculator.calculateTotal("STANDARD", 2));
        System.out.println("Urgent 3h: LKR " +
                FeeCalculator.calculateTotal("URGENT", 3));

        // Test DateTimeFormatter
        System.out.println("\n=== Testing DateTimeFormatter ===");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Standard: " +
                DateTimeFormatterUtil.formatDateTime(now));
        System.out.println("Long: " +
                DateTimeFormatterUtil.formatDateLong(now));
        System.out.println("Time: " +
                DateTimeFormatterUtil.formatTime(now));
    }
}


