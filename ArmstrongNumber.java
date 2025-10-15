/*
 * ArmstrongNumber.java
 * Program to check if a given number is an Armstrong Number
 *
 * Example:
 * Input: 153
 * Output: 153 is an Armstrong Number
 *
 * Compilation:
 * javac ArmstrongNumber.java
 * 
 * Run:
 * java ArmstrongNumber
 */

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input from user
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int originalNumber = num;
        int digits = String.valueOf(num).length(); // Number of digits in the number
        int sum = 0;

        // Calculate the sum of digits raised to the power of total digits
        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digits);
            num /= 10;
        }

        // Check if sum equals the original number
        if (sum == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong Number");
        } else {
            System.out.println(originalNumber + " is Not an Armstrong Number");
        }

        sc.close();
    }
}
