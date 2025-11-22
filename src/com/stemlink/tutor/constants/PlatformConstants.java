package com.stemlink.tutor.constants;

public class PlatformConstants {
    // Booking rules
    public static final int MIN_BOOKING_HOURS = 1;
    public static final int MAX_BOOKING_HOURS = 4;
    public static final int MAX_ADVANCE_BOOKING_DAYS = 30;

    // Fee structure
    public static final double STANDARD_HOURLY_RATE = 1500.0;
    public static final double URGENT_MULTIPLIER = 1.5;
    public static final double GROUP_DISCOUNT = 0.8;
    public static final double PLATFORM_FEE_PERCENTAGE = 0.15;

    // Ratings
    public static final double MIN_MENTOR_RATING = 1.0;
    public static final double MAX_MENTOR_RATING = 5.0;
    public static final double MINIMUM_ACCEPTABLE_RATING = 3.0;

    // Prevent instantiation
    private PlatformConstants() {
        throw new AssertionError("Cannot instantiate constants class");
    }
}
