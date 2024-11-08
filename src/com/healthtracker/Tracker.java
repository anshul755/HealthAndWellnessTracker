package com.healthtracker;

public interface Tracker {
    void addFoodItem(double calories, double fat, double transFat, double saturatedFat, double sodium,double cholesterol, double carbs);

    double calculateHealthScore();

    String assessRisks();

    String wellnessRecommendations();
}