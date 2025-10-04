import java.util.Scanner;

public class UsernameChecker {
    public static void main(String[] args) {
        // Predefined usernames (like taken usernames in a database)
        String[] takenUsernames = {"nisha123", "coderX", "javaPro", "admin", "guest"};

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a username: ");
        String username = sc.nextLine();

        boolean available = true;

        // Check if username exists in the taken list
        for (String taken : takenUsernames) {
            if (taken.equalsIgnoreCase(username)) {
                available = false;
                break;
            }
        }

        // Show result
        if (available) {
            System.out.println("✅ Username is available!");
        } else {
            System.out.println("❌ Username already taken. Try another.");
        }
    }
}
