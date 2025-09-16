package constructors;

public class Course {
    // Instance variables
    private String courseName;
    private int duration; // in months
    private double fee;

    // Class variable (shared by all courses)
    private static String instituteName = "ABC Institute";

    // Constructor
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method
    public void displayCourseDetails() {
        System.out.println("Institute: " + instituteName +
                ", Course: " + courseName +
                ", Duration: " + duration + " months" +
                ", Fee: " + fee);
    }

    // Class method (to update institute name)
    public static void updateInstituteName(String newName) {
        instituteName = newName;
        System.out.println("Institute name updated to: " + instituteName);
    }
}

