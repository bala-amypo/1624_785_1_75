package com.example.demo.util;

public class RiskLevelUtils {

    public static String determineRiskLevel(int score) {
        if (score <= 0) return "LOW";
        if (score <= 50) return "MEDIUM";
        return "HIGH";
    }
}
