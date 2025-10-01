import java.util.Scanner;

/**
 * Write a Java program that prompts the user to enter an integer and then
 * counts the number of occurrences of the digit 5 in that integer.
 * The program should read the number from the user using a Scanner and output
 * the count of the digit 5.
 */
public class Counting_occurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int n  = scanner.nextInt();
        int count = 0;
        while (n > 0){
            int rem = n % 10;
            if (rem == 5){
                count ++ ;
            }
        n = n / 10;
        }
        System.out.println("Count = "+ count);
    }
}

