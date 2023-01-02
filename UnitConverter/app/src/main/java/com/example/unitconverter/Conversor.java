package com.example.unitconverter;

public class Conversor {
    // Constants for the conversion factors
    private static final double MILES_TO_KILOMETERS = 1.60934;
    private static final double KILOMETERS_TO_MILES = 0.621371;
    private static final double POUNDS_TO_KILOGRAMS = 0.453592;
    private static final double KILOGRAMS_TO_POUNDS = 2.20462;
    // It's better to multiply by 5 and then divide by 9 to get a more accurate result
    // private static final double FAHRENHEIT_TO_CELSIUS = 0.555556;
    private static final double CELSIUS_TO_FAHRENHEIT = 1.8; // As it's an exact value, we may use it directly

    // No need to create an instance of this class as it only contains static methods

    // Method to convert the value
    public static double convert(ConversionType type, double value) {
        switch (type) {
            case MILES_TO_KILOMETERS:
                return value * MILES_TO_KILOMETERS;
            case KILOMETERS_TO_MILES:
                return value * KILOMETERS_TO_MILES;
            case POUNDS_TO_KILOGRAMS:
                return value * POUNDS_TO_KILOGRAMS;
            case KILOGRAMS_TO_POUNDS:
                return value * KILOGRAMS_TO_POUNDS;
            case FAHRENHEIT_TO_CELSIUS:
                return ((value - 32) * 5 )/(double) 9;
            case CELSIUS_TO_FAHRENHEIT:
                return (value * CELSIUS_TO_FAHRENHEIT) + 32;
            default:
                return 0;
        }
    }
}
