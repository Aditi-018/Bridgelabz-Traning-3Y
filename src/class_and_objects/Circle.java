package class_and_objects;

// File name: Circle.java


public class Circle {

    // non-static variable
    double radius;

    // constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // method for calculating area of circle
    public void areaCircle() {
        System.out.printf("Area of circle: %.4f", (Math.PI * radius * radius));
    }

    // method for calculating circumference of circle
    public void circumferenceCircle() {
        System.out.printf("\nCircumference of circle: %.4f", (2 * Math.PI * radius));
    }

    // main method
    public static void main(String[] args) {
        Circle circle = new Circle(2.5); // constructor invoked

        circle.areaCircle(); // area method call
        circle.circumferenceCircle(); // circumference method call
    }
}

