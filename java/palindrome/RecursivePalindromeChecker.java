package java.palindrome;

import java.util.Scanner;

public class RecursivePalindromeChecker {

    public static boolean isPalindromeRecursive(String str) {
        // Base case: if the string is empty or has only one character, it's a palindrome
        if (str == null || str.length() <= 1) {
            return true;
        }

        // Compare the first and last characters
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            // Recursively check the substring without the first and last characters
            return isPalindromeRecursive(str.substring(1, str.length() - 1));
        } else {
            // If the first and last characters don't match, it's not a palindrome
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string or number: ");
        String input = sc.nextLine();
        sc.close();

        if (isPalindromeRecursive(input)) {
            System.out.println(input + " is a palindrome (recursive)!");
        } else {
            System.out.println(input + " is NOT a palindrome (recursive)!");
        }
    }
}