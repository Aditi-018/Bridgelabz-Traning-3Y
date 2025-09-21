package senario_based;

// File name: EduMentorApp.java

import java.util.ArrayList;
import java.util.List;

// Interface for certification
interface ICertifiable {
    void generateCertificate();
}

// Base User class
abstract class User {
    private String name;
    private String email;
    private int userId;

    public User(String name, String email, int userId) {
        this.name = name;
        this.email = email;
        this.userId = userId;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getUserId() { return userId; }

    public abstract void printDetails();
}

// Learner class
class Learner extends User implements ICertifiable {
    private List<Quiz> completedQuizzes;

    public Learner(String name, String email, int userId) {
        super(name, email, userId);
        completedQuizzes = new ArrayList<>();
    }

    public void takeQuiz(Quiz quiz, List<String> answers) {
        quiz.submitAnswers(answers);
        completedQuizzes.add(quiz);
        System.out.println(getName() + " completed quiz: " + quiz.getQuizName() +
                " | Score: " + quiz.getScore() + "%");
    }

    @Override
    public void generateCertificate() {
        System.out.println("🎓 Learner " + getName() + " receives a certificate for completing short courses.");
    }

    @Override
    public void printDetails() {
        System.out.println("Learner: " + getName() + ", Email: " + getEmail());
    }
}

// Instructor class
class Instructor extends User {
    public Instructor(String name, String email, int userId) {
        super(name, email, userId);
    }

    @Override
    public void printDetails() {
        System.out.println("Instructor: " + getName() + ", Email: " + getEmail());
    }
}

// Quiz class
class Quiz {
    private String quizName;
    private List<String> questions;
    private List<String> answers; // correct answers, encapsulated
    private List<String> learnerAnswers;
    private double score;

    public Quiz(String quizName, List<String> questions, List<String> answers) {
        this.quizName = quizName;
        this.questions = questions;
        this.answers = new ArrayList<>(answers); // encapsulation: cannot modify externally
        this.learnerAnswers = new ArrayList<>();
        this.score = 0;
    }

    public String getQuizName() { return quizName; }
    public double getScore() { return score; }

    public void submitAnswers(List<String> learnerAnswers) {
        this.learnerAnswers = learnerAnswers;
        calculateScore();
    }

    private void calculateScore() {
        int correctCount = 0;
        for (int i = 0; i < answers.size() && i < learnerAnswers.size(); i++) {
            if (answers.get(i).equalsIgnoreCase(learnerAnswers.get(i))) {
                correctCount++; // operator +
            }
        }
        score = ((double) correctCount / answers.size()) * 100; // percentage calculation
    }
}

// Main Application
public class EduMentorApp {
    public static void main(String[] args) {
        // Create instructor
        Instructor instr = new Instructor("Dr. Mehta", "mehta@edumentor.com", 101);
        instr.printDetails();

        // Create learner
        Learner learner = new Learner("Aditi", "aditi@edumentor.com", 201);
        learner.printDetails();

        // Create quiz
        List<String> questions = new ArrayList<>();
        questions.add("Capital of India?");
        questions.add("2 + 2 = ?");
        List<String> answers = new ArrayList<>();
        answers.add("Delhi");
        answers.add("4");
        Quiz quiz1 = new Quiz("General Knowledge", questions, answers);

        // Learner takes quiz
        List<String> learnerAns = new ArrayList<>();
        learnerAns.add("Delhi");
        learnerAns.add("4");
        learner.takeQuiz(quiz1, learnerAns);

        // Generate certificate
        learner.generateCertificate();
    }
}


