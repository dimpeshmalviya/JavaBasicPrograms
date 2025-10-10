import java.util.Random;
import java.util.Scanner;

public class DiceSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String userInput;

        System.out.println("🎲 Welcome to the Dice Simulator!");

        do {
            // Simulate a dice roll (1 to 6)
            int diceRoll = random.nextInt(6) + 1;
            System.out.println("You rolled: " + diceRoll);

            // Ask user if they want to roll again
            System.out.print("Roll again? (y/n): ");
            userInput = scanner.nextLine().trim().toLowerCase();
        } while (userInput.equals("y"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
