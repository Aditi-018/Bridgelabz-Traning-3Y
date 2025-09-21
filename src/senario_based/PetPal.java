package senario_based;

// File name: PetPal.java

import java.util.Random;
import java.util.Scanner;

// Interface for interactions
interface IInteractable {
    void feed();
    void play();
    void sleep();
}

// Base class Pet
class Pet {
    protected String name;
    protected String type;
    protected int age;
    protected int energy;
    private int hunger; // encapsulated
    private int mood;   // encapsulated

    Random random = new Random();

    // Constructor with default values
    public Pet() {
        this.name = "Pet" + random.nextInt(100);
        this.type = "Unknown";
        this.age = random.nextInt(10) + 1;
        this.energy = random.nextInt(50) + 50;
        this.hunger = random.nextInt(50);
        this.mood = random.nextInt(50);
    }

    // Constructor with user-specified values
    public Pet(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.energy = random.nextInt(50) + 50;
        this.hunger = random.nextInt(50);
        this.mood = random.nextInt(50);
    }

    // Getter and Setter for hunger and mood
    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = Math.max(0, Math.min(100, hunger));
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = Math.max(0, Math.min(100, mood));
    }

    // Polymorphic method
    public void makeSound() {
        System.out.println("Some generic pet sound...");
    }

    // Show pet status
    public void status() {
        System.out.println(name + " the " + type + " | Age: " + age + " | Energy: " + energy + " | Hunger: " + hunger + " | Mood: " + mood);
    }
}

// Dog class
class Dog extends Pet implements IInteractable {

    public Dog() {
        super();
        this.type = "Dog";
    }

    public Dog(String name, int age) {
        super(name, "Dog", age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof Woof!");
    }

    @Override
    public void feed() {
        setHunger(getHunger() - 10);
        energy += 5;
        setMood(getMood() + 5);
        System.out.println(name + " enjoyed the food!");
    }

    @Override
    public void play() {
        energy -= 10;
        setMood(getMood() + 15);
        setHunger(getHunger() + 5);
        System.out.println(name + " is happily playing!");
    }

    @Override
    public void sleep() {
        energy += 20;
        setMood(getMood() + 5);
        System.out.println(name + " is sleeping peacefully.");
    }
}

// Cat class
class Cat extends Pet implements IInteractable {

    public Cat() {
        super();
        this.type = "Cat";
    }

    public Cat(String name, int age) {
        super(name, "Cat", age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow Meow!");
    }

    @Override
    public void feed() {
        setHunger(getHunger() - 15);
        energy += 5;
        setMood(getMood() + 10);
        System.out.println(name + " is purring happily!");
    }

    @Override
    public void play() {
        energy -= 5;
        setMood(getMood() + 20);
        setHunger(getHunger() + 5);
        System.out.println(name + " is chasing a toy!");
    }

    @Override
    public void sleep() {
        energy += 15;
        setMood(getMood() + 5);
        System.out.println(name + " is napping quietly.");
    }
}

// Bird class
class Bird extends Pet implements IInteractable {

    public Bird() {
        super();
        this.type = "Bird";
    }

    public Bird(String name, int age) {
        super(name, "Bird", age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Tweet Tweet!");
    }

    @Override
    public void feed() {
        setHunger(getHunger() - 5);
        energy += 5;
        setMood(getMood() + 10);
        System.out.println(name + " is happily eating seeds!");
    }

    @Override
    public void play() {
        energy -= 5;
        setMood(getMood() + 15);
        setHunger(getHunger() + 5);
        System.out.println(name + " is flying around joyfully!");
    }

    @Override
    public void sleep() {
        energy += 10;
        setMood(getMood() + 5);
        System.out.println(name + " is resting on its perch.");
    }
}

// Main class
public class PetPal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pet[] pets = new Pet[3];

        // Create pets
        pets[0] = new Dog("Buddy", 3);
        pets[1] = new Cat("Whiskers", 2);
        pets[2] = new Bird("Tweety", 1);

        // Interact with pets
        for (Pet pet : pets) {
            pet.status();
            pet.makeSound();
            if (pet instanceof IInteractable) {
                IInteractable interactablePet = (IInteractable) pet;
                interactablePet.feed();
                interactablePet.play();
                interactablePet.sleep();
            }
            pet.status();
            System.out.println("-----------------------------------");
        }

        sc.close();
    }
}

