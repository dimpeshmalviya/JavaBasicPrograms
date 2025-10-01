// filename: Factorial.java
// Compile: javac Factorial.java
// Run: java Factorial 6
public class Factorial {
 public static long factorial(int n) {
 if (n <= 1) return 1;
 return n * factorial(n - 1);
 }
 public static void main(String[] args) {
 if (args.length == 0) {
 System.out.println("Usage: java Factorial <number>");
 return;
 }
 int num = Integer.parseInt(args[0]);
 System.out.println("Factorial of " + num + " = " + factorial(num));
 }
}
