# HealthAndWellnessTracker

The Java project starts with a package declaration (package com.healthtracker;) in each of the four files, organizing the classes under the same namespace for better management.

The Tracker interface in Tracker.java defines methods that any class implementing this interface must provide, including addFoodItem(...) for adding food item details, calculateHealthScore() for calculating the health score, assessRisks() for evaluating health risks based on dietary intake, and wellnessRecommendations() for providing dietary recommendations.

The NutritionTracker class in NutritionTracker.java implements the Tracker interface, maintaining private instance variables for tracking total calories, fat, carbohydrates, and other nutritional data. It provides concrete implementations for the methods defined in the Tracker interface and includes methods to add food items and compute health scores based on the total nutritional data.

The HealthAndWellnessTracker class in Health_And_Wellness_Tracker.java extends the NutritionTracker class, inheriting its methods and properties. It adds fields for height and weight, along with a method to calculate Body Mass Index (BMI). This class includes a static method to load food items from a CSV file into a set, allowing the program to check user input against available food items.

The Main class in Main.java contains the main method, which serves as the entry point of the application. It manages the overall flow by interacting with the user and utilizing the other classes.

When the program is executed, it first loads food items from the specified CSV file (foodItems.csv) by calling the loadFoodItems method, which reads the file and adds the food item names to a set. Next, it prompts the user to enter their height and weight using the Scanner class. After obtaining this information, it creates an instance of HealthAndWellnessTracker, passing the user-provided height and weight to its constructor.

The program then displays the list of available food items loaded from the CSV file and enters a loop that continues until the user types "exit". Within this loop, it prompts the user to enter a food item they consumed. It checks if the input matches any of the available food items and, if valid, reads the corresponding nutritional data from the CSV file to add the food item to the tracker.

In the case of invalid input or errors while reading the CSV file, appropriate exception handling is in place to notify the user without crashing the program. After the user finishes entering food items, the program calculates the BMI and various health metrics, displaying the results to the user. This includes the health risks associated with their dietary choices and wellness recommendations tailored to their intake.

Finally, it outputs the current nutritional intake for calories, fat, and carbohydrates compared to recommended daily values. The program concludes by closing the Scanner object to free resources.

Overall, this Java project serves as a user-friendly health and wellness tracker that allows users to monitor their dietary habits, calculate important health metrics, and receive personalized recommendations based on their input, demonstrating effective use of OOP concepts and file handling.