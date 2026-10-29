package com.houarizegai.calculator;

public final class CalculatorSettings {

    private static final CalculatorSettings instance =
            new CalculatorSettings();

    private String selectedTheme;

    private CalculatorSettings() {
    }

    public static CalculatorSettings getInstance() {
        return instance;
    }

    public String getSelectedTheme() {
        return selectedTheme;
    }

    public void setSelectedTheme(String theme) {
        this.selectedTheme = theme;
    }
}
