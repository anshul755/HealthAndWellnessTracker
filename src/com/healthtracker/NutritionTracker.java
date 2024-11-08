package com.healthtracker;

public class NutritionTracker implements Tracker {
    protected double totalCalories = 0;
    protected double totalFat = 0;
    protected double totalTransFat = 0;
    protected double totalSatFat = 0;
    protected double totalSodium = 0;
    protected double totalChol = 0;
    protected double totalCarbs = 0;

    @Override
    public void addFoodItem(double calories, double fat, double transFat, double saturatedFat, double sodium,double cholesterol, double carbs) {
        this.totalCalories += calories;
        this.totalFat += fat;
        this.totalTransFat += transFat;
        this.totalSatFat += saturatedFat;
        this.totalSodium += sodium;
        this.totalChol += cholesterol;
        this.totalCarbs += carbs;
    }

    @Override
    public double calculateHealthScore() {
        double score = 100.0;
        if (totalCalories > 2000)
            score -= (totalCalories - 2000) / 20;
        if (totalFat > 70)
            score -= (totalFat - 70) * 2;
        if (totalSatFat > 10)
            score -= (totalSatFat - 10) * 3;
        if (totalSodium > 1500)
            score -= (totalSodium - 1500) / 100;
        if (totalChol > 200)
            score -= (totalChol - 200) / 50;
        return Math.max(0, Math.min(score, 100));
    }

    @Override
    public String assessRisks() {
        StringBuilder risks = new StringBuilder();
        if (totalCalories > 2000)
            risks.append("Risk of high calorie intake.\n");
        if (totalSodium > 1500)
            risks.append("Risk of high sodium intake.\n");
        if (totalFat > 70 || totalTransFat > 0.1)
            risks.append("Risk of heart issues due to high fat.\n");
        return risks.toString();
    }

    @Override
    public String wellnessRecommendations() {
        StringBuilder recommendations = new StringBuilder();
        if (totalCalories > 2000)
            recommendations.append("Consider reducing calorie intake.\n");
        if (totalSodium > 1500)
            recommendations.append("Reduce sodium intake.\n");
        if (totalFat > 70)
            recommendations.append("Lower fat intake.\n");
        return recommendations.toString();
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public double getTotalFat() {
        return totalFat;
    }

    public double getTotalCarbs() {
        return totalCarbs;
    }
}
