import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(50) + 1; // Random number between 1 and 50
        int guess = 0;
        int attempts = 0;
        int maxAttempts = 6;

        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("I'm thinking of a number between 1 and 50.");
        System.out.println("You have " + maxAttempts + " attempts to guess it!");

        // Loop until correct or attempts run out
        while (attempts < maxAttempts) {
            System.out.print("\nAttempt " + (attempts + 1) + ": Enter your guess -> ");
            guess = sc.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("\n:D Congratulations! You guessed it right in " + attempts + " attempts!");
                break; // Exit loop if guessed correctly
            }

            if (attempts == maxAttempts) {
                System.out.println("\nSorry, you've used all " + maxAttempts + " attempts.");
                System.out.println("The correct number was: " + numberToGuess);
            }
        }

        sc.close();
    }
}



/*
Execution 1:
Welcome to Guess the Number Game!
I'm thinking of a number between 1 and 50.
You have 6 attempts to guess it!

Attempt 1: Enter your guess -> 44
Too high!

Attempt 2: Enter your guess -> 33
Too high!

Attempt 3: Enter your guess -> 15
Too low!

Attempt 4: Enter your guess -> 23

:D Congratulations! You guessed it right in 4 attempts!


Execution 2:
Welcome to Guess the Number Game!
I'm thinking of a number between 1 and 50.
You have 6 attempts to guess it!

Attempt 1: Enter your guess -> 35
Too high!

Attempt 2: Enter your guess -> 25
Too high!

Attempt 3: Enter your guess -> 15
Too high!

Attempt 4: Enter your guess -> 5
Too low!

Attempt 5: Enter your guess -> 10
Too low!

Attempt 6: Enter your guess -> 13
Too low!

Sorry, you've used all 6 attempts.
The correct number was: 14
*/
