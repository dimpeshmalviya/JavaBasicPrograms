// filename: Armstrong.java
// Compile: javac Armstrong.java
// Run: java Armstrong 153

public class Armstrong {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Armstrong <number>");
            return;
        }
        int num = Integer.parseInt(args[0]);
        int original = num, sum = 0, digits = 0;

        int temp = num;
        while (temp > 0) {
            digits++;
            temp /= 10;
        }

        temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }

        if (sum == original)
            System.out.println(original + " is an Armstrong number.");
        else
            System.out.println(original + " is not an Armstrong number.");
    }
}
