package senario_based;

// File name: EventEase.java

import java.util.*;

// Interface for scheduling events
interface ISchedulable {
    void schedule();
    void reschedule(String newDate);
    void cancel();
}

// User class (event organizer)
class User {
    private String name;
    private String email;
    private String phone; // sensitive data

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    // Encapsulation: sensitive info only via methods
    public String getContactInfo() {
        return email + " / " + phone;
    }
}

// Base Event class
class Event implements ISchedulable {
    private static int idCounter = 1; // auto-increment eventId
    private final int eventId; // cannot be changed after assignment
    protected String eventName;
    protected String location;
    protected String date;
    protected int attendees;
    private double baseCost; // encapsulated
    private double servicesCost; // catering, decoration etc.

    protected double discount;

    protected User organizer;

    // Constructor with default services
    public Event(String eventName, String location, String date, int attendees, User organizer) {
        this.eventId = idCounter++;
        this.eventName = eventName;
        this.location = location;
        this.date = date;
        this.attendees = attendees;
        this.organizer = organizer;
        this.baseCost = attendees * 100; // arbitrary base cost per attendee
        this.servicesCost = 0;
        this.discount = 0;
    }

    // Constructor with services
    public Event(String eventName, String location, String date, int attendees, double servicesCost, double discount, User organizer) {
        this(eventName, location, date, attendees, organizer);
        this.servicesCost = servicesCost;
        this.discount = discount;
    }

    public int getEventId() {
        return eventId;
    }

    public double calculateTotalCost() {
        return baseCost + servicesCost - discount;
    }

    @Override
    public void schedule() {
        System.out.println("Scheduling a generic event: " + eventName + " on " + date);
    }

    @Override
    public void reschedule(String newDate) {
        System.out.println("Rescheduling event " + eventName + " from " + date + " to " + newDate);
        this.date = newDate;
    }

    @Override
    public void cancel() {
        System.out.println("Event " + eventName + " has been canceled.");
    }

    public void showDetails() {
        System.out.println("Event ID: " + eventId + " | Name: " + eventName + " | Type: " + this.getClass().getSimpleName() +
                " | Location: " + location + " | Date: " + date + " | Attendees: " + attendees +
                " | Organizer: " + organizer.getName() +
                " | Total Cost: $" + calculateTotalCost());
    }
}

// BirthdayEvent class
class BirthdayEvent extends Event {

    public BirthdayEvent(String eventName, String location, String date, int attendees, User organizer) {
        super(eventName, location, date, attendees, organizer);
    }

    public BirthdayEvent(String eventName, String location, String date, int attendees, double servicesCost, double discount, User organizer) {
        super(eventName, location, date, attendees, servicesCost, discount, organizer);
    }

    @Override
    public void schedule() {
        System.out.println("Birthday Event " + eventName + " is scheduled with balloons and cake on " + date);
    }
}

// ConferenceEvent class
class ConferenceEvent extends Event {

    public ConferenceEvent(String eventName, String location, String date, int attendees, User organizer) {
        super(eventName, location, date, attendees, organizer);
    }

    public ConferenceEvent(String eventName, String location, String date, int attendees, double servicesCost, double discount, User organizer) {
        super(eventName, location, date, attendees, servicesCost, discount, organizer);
    }

    @Override
    public void schedule() {
        System.out.println("Conference Event " + eventName + " is scheduled with projector and seating on " + date);
    }
}

// Main class
public class EventEase {
    public static void main(String[] args) {
        User organizer1 = new User("Alice", "alice@example.com", "1234567890");
        User organizer2 = new User("Bob", "bob@example.com", "9876543210");

        // Create events
        Event birthday = new BirthdayEvent("Alice's Birthday", "Central Park", "2025-10-01", 50, 200, 50, organizer1);
        Event conference = new ConferenceEvent("Tech Conference", "Grand Hall", "2025-11-15", 200, 1000, 200, organizer2);

        // Schedule events (polymorphism)
        birthday.schedule();
        conference.schedule();

        // Show details
        birthday.showDetails();
        conference.showDetails();

        // Reschedule an event
        birthday.reschedule("2025-10-05");
        birthday.showDetails();

        // Cancel an event
        conference.cancel();
    }
}
