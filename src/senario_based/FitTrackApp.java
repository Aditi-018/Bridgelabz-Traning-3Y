package senario_based;

// File name: FitTrackApp.java

import java.util.ArrayList;
import java.util.List;

// Interface for tracking workouts
interface ITrackable {
    void startWorkout();
    void stopWorkout();
}

// UserProfile class
class UserProfile {
    private String name;
    private int age;
    private double weight; // encapsulated
    private String goal;
    private double dailyTargetCalories;

    public UserProfile(String name, int age, double weight) {
        this(name, age, weight, "General Fitness", 500); // default goal and target
    }

    public UserProfile(String name, int age, double weight, String goal, double dailyTargetCalories) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.goal = goal;
        this.dailyTargetCalories = dailyTargetCalories;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getWeight() { return weight; }
    public String getGoal() { return goal; }
    public double getDailyTargetCalories() { return dailyTargetCalories; }

    public void updateWeight(double weight) {
        this.weight = weight;
    }

    public void printProfile() {
        System.out.println("User: " + name + ", Age: " + age + ", Weight: " + weight + "kg, Goal: " + goal);
    }
}

// Base Workout class
abstract class Workout implements ITrackable {
    private String type;
    private int duration; // in minutes
    protected double caloriesBurned; // protected for inheritance
    private boolean isActive;

    public Workout(String type, int duration) {
        this.type = type;
        this.duration = duration;
        this.caloriesBurned = 0;
        this.isActive = false;
    }

    public double getCaloriesBurned() { return caloriesBurned; }

    @Override
    public void startWorkout() {
        isActive = true;
        System.out.println(type + " workout started for " + duration + " minutes.");
    }

    @Override
    public void stopWorkout() {
        isActive = false;
        calculateCalories();
        System.out.println(type + " workout stopped. Calories burned: " + caloriesBurned);
    }

    protected abstract void calculateCalories(); // polymorphism
}

// CardioWorkout
class CardioWorkout extends Workout {
    public CardioWorkout(int duration) {
        super("Cardio", duration);
    }

    @Override
    protected void calculateCalories() {
        // Simple formula: caloriesBurned = duration * 8
        caloriesBurned = super.caloriesBurned + 8 * super.getCaloriesBurned(); // operator usage
        caloriesBurned = 8 * caloriesBurned; // simplified formula
    }
}

// StrengthWorkout
class StrengthWorkout extends Workout {
    public StrengthWorkout(int duration) {
        super("Strength", duration);
    }

    @Override
    protected void calculateCalories() {
        // Simple formula: caloriesBurned = duration * 6
        caloriesBurned = 6 * super.getCaloriesBurned(); // operator usage
    }
}

// Tracker class
class Tracker {
    private UserProfile user;
    private List<Workout> workoutLogs;

    public Tracker(UserProfile user) {
        this.user = user;
        this.workoutLogs = new ArrayList<>();
    }

    public void logWorkout(Workout workout) {
        workout.startWorkout();
        workout.stopWorkout();
        workoutLogs.add(workout);
    }

    public void showDailyProgress() {
        double totalCalories = 0;
        for (Workout w : workoutLogs) {
            totalCalories += w.getCaloriesBurned(); // operator +
        }
        double remaining = user.getDailyTargetCalories() - totalCalories; // operator -
        System.out.println("Total calories burned today: " + totalCalories);
        System.out.println("Remaining calories to reach daily target: " + remaining);
    }
}

// Main App
public class FitTrackApp {
    public static void main(String[] args) {
        // Create user profile
        UserProfile user = new UserProfile("Aditi", 22, 55, "Weight Loss", 600);
        user.printProfile();

        // Create tracker
        Tracker tracker = new Tracker(user);

        // Log workouts
        Workout cardio = new CardioWorkout(30); // 30 mins
        Workout strength = new StrengthWorkout(20); // 20 mins

        tracker.logWorkout(cardio);
        tracker.logWorkout(strength);

        // Show daily progress
        tracker.showDailyProgress();
    }
}
