import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Calculate and display the factorial
        long factorial = calculateFactorial(number);
        System.out.println("Factorial of " + number + " is: " + factorial);

        // Close the scanner
        scanner.close();
    }

    static long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }
}
