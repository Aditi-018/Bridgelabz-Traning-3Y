package java_method;

import java.util.Scanner;

public class RockPaperScissors {

    // Method to get computer choice using Math.random
    public static String getComputerChoice() {
        int choice = (int)(Math.random() * 3); // 0, 1, 2
        switch (choice) {
            case 0: return "rock";
            case 1: return "paper";
            case 2: return "scissors";
            default: return "rock"; // fallback
        }
    }

    // Method to find the winner
    public static String findWinner(String user, String computer) {
        if (user.equals(computer)) {
            return "draw";
        } else if ((user.equals("rock") && computer.equals("scissors")) ||
                (user.equals("paper") && computer.equals("rock")) ||
                (user.equals("scissors") && computer.equals("paper"))) {
            return "user";
        } else {
            return "computer";
        }
    }

    // Method to calculate averages and percentages
    public static String[][] calculateStats(int userWins, int computerWins, int draws, int totalGames) {
        String[][] stats = new String[3][3];

        stats[0][0] = "Player Wins";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f%%", (userWins * 100.0) / totalGames);

        stats[1][0] = "Computer Wins";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f%%", (computerWins * 100.0) / totalGames);

        stats[2][0] = "Draws";
        stats[2][1] = String.valueOf(draws);
        stats[2][2] = String.format("%.2f%%", (draws * 100.0) / totalGames);

        return stats;
    }

    // Method to display the 2D array in tabular format
    public static void displayResults(String[][] results) {
        System.out.printf("%-15s %-10s %-10s%n", "Category", "Count", "Percentage");
        System.out.println("----------------------------------------");
        for (String[] row : results) {
            System.out.printf("%-15s %-10s %-10s%n", row[0], row[1], row[2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int games = sc.nextInt();

        int userWins = 0, computerWins = 0, draws = 0;

        sc.nextLine(); // consume newline

        for (int i = 1; i <= games; i++) {
            System.out.print("Game " + i + " - Enter your choice (rock/paper/scissors): ");
            String userChoice = sc.nextLine().toLowerCase();
            String computerChoice = getComputerChoice();

            System.out.println("Computer chose: " + computerChoice);

            String winner = findWinner(userChoice, computerChoice);

            if (winner.equals("user")) {
                System.out.println("You win this round!");
                userWins++;
            } else if (winner.equals("computer")) {
                System.out.println("Computer wins this round!");
                computerWins++;
            } else {
                System.out.println("This round is a draw!");
                draws++;
            }
            System.out.println();
        }

        // Calculate and display stats
        String[][] stats = calculateStats(userWins, computerWins, draws, games);
        System.out.println("Game Summary:");
        displayResults(stats);

        sc.close();
    }
}

