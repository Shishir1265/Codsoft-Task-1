import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class Number_game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int difficulty = 0;
        int minRange = 0;
        int maxRange = 0;
        int attempts = 5;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!🎮");

        do {
            difficulty = selectDifficulty(scanner);
            minRange = getMinRange(difficulty);
            maxRange = getMaxRange(difficulty);

            System.out.println("A random number between " + minRange + " and " + maxRange + " has been generated. You have " + attempts + " attempts.");

            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

            for (int attempt = 1; attempt <= attempts; attempt++) {
                System.out.print("Enter your guess: ");
                int userGuess = getUserInput(scanner);

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score = score + difficulty;
                    break;
                } else if (Math.abs(userGuess - randomNumber) < 6) {
                    if (userGuess < randomNumber) {
                        System.out.println("Higher. Try again.");
                    } else {
                        System.out.println("Lower. Try again.");
                    }
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                if (attempt == attempts) {
                    System.out.println("Out of attempts. The correct number was: " + randomNumber);
                    score--;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        if (score<0) {score = 0;}

        System.out.println("Game over. You guessed the correct number " + score + " times.🏆");
        scanner.close();
    }
    
    public static int selectDifficulty(Scanner scanner) {
        int difficulty = 0;
        while (true) {
            System.out.print("Select difficulty - 1, 2, or 3: ");
            try {
                difficulty = scanner.nextInt();
                if (difficulty == 1 || difficulty == 2 || difficulty == 3) {
                    break;
                } else {
                    System.out.println("Invalid input. Please choose 1, 2, or 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
        }
        return difficulty;
    }

    public static int getUserInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
        }
    }

    public static int getMinRange(int difficulty) {
        if (difficulty == 1) {
            return 1;
        } else if (difficulty == 2) {
            return 1;
        } else if (difficulty == 3) {
            return 1;
        }
        return 1;
    }

    public static int getMaxRange(int difficulty) {
        if (difficulty == 1) {
            return 30;
        } else if (difficulty == 2) {
            return 100;
        } else if (difficulty == 3) {
            return 200;
        }
        return 100;
    }
}