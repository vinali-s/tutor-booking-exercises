package com.stemlink.tutor;

import java.time.LocalDateTime;

public class BookingValidator {

    private BookingValidator() {} // Prevent instantiation

    // Validates if booking time is in the future
    public static boolean isValidBookingTime(LocalDateTime bookingTime) {
        return bookingTime.isAfter(LocalDateTime.now());
    }

    // Validates if duration is between 1 - 4 hours
    public static boolean isValidDuration(int hours) {
        return hours >= 1 && hours <= 4;
    }

    // Validates slot overlap
    public static boolean isSlotAvailable(
            LocalDateTime newStart,
            LocalDateTime newEnd,
            LocalDateTime existingStart,
            LocalDateTime existingEnd
    ) {
        return newStart.isAfter(existingEnd) || newEnd.isBefore(existingStart);
    }
}
