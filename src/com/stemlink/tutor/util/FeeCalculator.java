package com.stemlink.tutor;

public class FeeCalculator {

    private FeeCalculator() {} // Prevent instantiation

    private static final double STANDARD_RATE = 1500.0;
    private static final double URGENT_RATE = 2500.0;
    private static final double GROUP_RATE = 1200.0;
    private static final double PLATFORM_FEE_PERCENTAGE = 0.15;

    public static double calculateBaseFee(String bookingType, int hours) {
        switch (bookingType.toUpperCase()) {
            case "STANDARD":
                return hours * STANDARD_RATE;
            case "URGENT":
                return hours * URGENT_RATE;
            case "GROUP":
                return hours * GROUP_RATE;
            default:
                throw new IllegalArgumentException("Invalid booking type");
        }
    }

    public static double calculatePlatformFee(double baseFee) {
        return baseFee * PLATFORM_FEE_PERCENTAGE;
    }

    public static double calculateTotal(String bookingType, int hours) {
        double baseFee = calculateBaseFee(bookingType, hours);
        return baseFee + calculatePlatformFee(baseFee);
    }
}