package com.example.unitconverter;

import java.util.ArrayList;

public class History {
    // This class will contain the list of conversion results
    // For reusability while the app is running, we will use a Singleton pattern
    // This means that we will only have one instance of this class

    // The instance of the class
    private static History instance;
    // The list of conversion results, an arrayList
    private ArrayList<ConversionResult> conversionResults;

    // Constructor, will be private as we will use the getInstance method
    private History() {
        conversionResults = new ArrayList<>();
    }

    // Method to get the instance of the class
    public static History getInstance() {
        if (instance == null) {
            instance = new History();
        }
        return instance;
    }

    // Method to add a conversion result to the list
    public void addConversionResult(ConversionResult conversionResult) {
        // Add the conversion result to the list in the first position
        // So when we add a new conversion result, it will be shown at the top of the list
        conversionResults.add(0, conversionResult);
    }

    // Method to get the list of conversion results
    public ArrayList<ConversionResult> getConversionResults() {
        return conversionResults;
    }

    // Method to clear the list of conversion results
    public void clearConversionResults() {
        conversionResults.clear();
    }
}
