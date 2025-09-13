package inheritance;

// Save this file as CourseHierarchy.java

// Base class
class Course {
    String courseName;
    int duration; // duration in weeks

    // Constructor
    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    // Method to display course info
    public void displayInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}

// Subclass: OnlineCourse
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    // Constructor
    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Subclass: PaidOnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount; // percentage

    // Constructor
    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fee: ₹" + fee);
        System.out.println("Discount: " + discount + "%");
        double finalPrice = fee - (fee * discount / 100);
        System.out.println("Final Price after Discount: ₹" + finalPrice);
    }
}

// Main class
public class CourseHierarchy {
    public static void main(String[] args) {
        // Base Course
        Course c1 = new Course("Basic English", 6);
        c1.displayInfo();
        System.out.println("-----------------------------");

        // Online Course
        OnlineCourse c2 = new OnlineCourse("Java Programming", 8, "Udemy", true);
        c2.displayInfo();
        System.out.println("-----------------------------");

        // Paid Online Course
        PaidOnlineCourse c3 = new PaidOnlineCourse("Full Stack Development", 12, "Coursera", true, 12000, 20);
        c3.displayInfo();
    }
}
