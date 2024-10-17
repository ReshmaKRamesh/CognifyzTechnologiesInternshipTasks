import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        // Initialize Random and Scanner objects
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Generate a random number between 1 and 10
        int secretNumber = random.nextInt(10) + 1;
        int attempts = 3;
        boolean hasWon = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 10. You have 3 attempts to guess it.");

        // Game loop for 3 attempts
        while (attempts > 0) {
            System.out.print("Enter your guess: ");
            int guess;

            try {
                guess = scanner.nextInt(); // Capture user input

                // Check the guess
                if (guess < 1 || guess > 10) {
                    System.out.println("Please guess a number between 1 and 10.");
                    continue;
                } else if (guess < secretNumber) {
                    System.out.println("Too low!");
                } else if (guess > secretNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You've guessed the number correctly!");
                    hasWon = true;
                    break;  // End the game if guessed correctly
                }

                attempts--;
                System.out.println("You have " + attempts + " attempts left.");

            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }

        if (!hasWon) {
            System.out.println("Game over! The correct number was " + secretNumber + ".");
        }

        scanner.close();
    }
}
