package com.example.unitconverter;

public class ConversionResult {
    Double fromValue;
    Double toValue;
    ConversionType type;

    public ConversionResult(Double fromValue, Double toValue, ConversionType type) {
        this.fromValue = fromValue;
        this.toValue = toValue;
        this.type = type;
    }
    // Getters
    public Double getFromValue() {
        return fromValue;
    }
    public Double getToValue() {
        return toValue;
    }
    public ConversionType getType() {
        return type;
    }
    // No setters as we don't want to change the values once the object is created

}
