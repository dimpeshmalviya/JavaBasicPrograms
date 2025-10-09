import java.util.*;

public class DiceRoller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String choice;
        System.out.println("🎲 Would you like to roll the dice? (y/n): ");
        choice = sc.nextLine();
        while (choice.equalsIgnoreCase("y")) {
            int dice = random.nextInt(6) + 1;
            System.out.println("🎲 You rolled: " + dice);
            System.out.print("Roll again? (y/n): ");
            choice = sc.nextLine();
        };

        System.out.println("Bye! 👋");
    }
}