package com.healthtracker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;

public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        String csvFile = "D:\\Studies\\JAVA\\Programs\\HealthAndWellnessTracker\\src\\com\\healthtracker\\foodItems.csv";
        Set<String> foodItems = Health_And_Wellness_Tracker.loadFoodItems(csvFile);

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your height (cm): ");
        double height = sc.nextDouble();
        System.out.print("Enter your weight (kg): ");
        double weight = sc.nextDouble();
        sc.nextLine();

        Health_And_Wellness_Tracker tracker = new Health_And_Wellness_Tracker(height, weight);

        System.out.println("Available Food Items:");
        for (String food : foodItems) {
            System.out.println("- " + food);
        }

        while (true) {
            System.out.print("Enter a food item you consumed (or type 'exit' to finish): ");
            String userFoodItem = sc.nextLine();
            if (userFoodItem.equalsIgnoreCase("exit"))
                break;

            if (!foodItems.contains(userFoodItem)) {
                System.out.println("Invalid choice. Select from available food items.");
                continue;
            }

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                br.readLine();
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data[7].trim().equalsIgnoreCase(userFoodItem)) {
                        double calories = Double.parseDouble(data[0]);
                        double fat = Double.parseDouble(data[1]);
                        double transFat = Double.parseDouble(data[2]);
                        double saturatedFat = Double.parseDouble(data[3]);
                        double sodium = Double.parseDouble(data[4]);
                        double cholesterol = Double.parseDouble(data[5]);
                        double carbs = Double.parseDouble(data[6]);

                        tracker.addFoodItem(calories, fat, transFat, saturatedFat, sodium, cholesterol, carbs);
                        System.out.println("Added " + userFoodItem + " to your diet.");
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error reading food data: " + e.getMessage());
            }
        }

        System.out.printf("Your BMI: %.2f\n", tracker.calculateBMI());
        System.out.println("Health Risks: " + tracker.assessRisks());
        System.out.println("Wellness Recommendations: " + tracker.wellnessRecommendations());
        System.out.printf("Your Health Score: %.2f\n", tracker.calculateHealthScore());
        System.out.printf(
                "Current Intake: Calories: %.2f kcal (Recommended: ~2000 kcal), Fat: %.2f g (Recommended: <70 g), Carbs: %.2f g (Recommended: <300 g)\n",
                tracker.getTotalCalories(), tracker.getTotalFat(), tracker.getTotalCarbs());
    }
}
