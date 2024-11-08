package com.healthtracker;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Health_And_Wellness_Tracker extends NutritionTracker {
    private final double height;
    private final double weight;

    public Health_And_Wellness_Tracker(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public double calculateBMI() {
        return weight / Math.pow(height / 100, 2);
    }

    public static Set<String> loadFoodItems(String csvFile) {
        Set<String> foodItems = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 8)
                    foodItems.add(data[7].trim());
            }
        } catch (IOException e) {
            System.out.println("Error loading food items: " + e.getMessage());
        }
        return foodItems;
    }
}
