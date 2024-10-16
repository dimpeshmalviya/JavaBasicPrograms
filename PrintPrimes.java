
import java.util.Scanner;

public class PrimeNumbersUsingSieve {
    
    // Function to use Sieve of Eratosthenes to find all primes up to a given limit
    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        
        // Initialize all entries to true. A value in isPrime[i] will be false if i is not prime.
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        
        // Apply sieve algorithm to mark non-primes
        for (int p = 2; p * p <= n; p++) {
            // If prime, mark its multiples as non-prime
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        
        return isPrime;
    }
    
    // Function to print primes and count them in a given range
    public static void printPrimesInRange(int start, int end) {
        // Find all primes up to end using Sieve of Eratosthenes
        boolean[] isPrime = sieveOfEratosthenes(end);
        int primeCount = 0;
        
        System.out.println("Prime numbers between " + start + " and " + end + ":");
        for (int i = start; i <= end; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
                primeCount++;
            }
        }
        
        System.out.println("\nTotal number of prime numbers: " + primeCount);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input initial and final values
        System.out.print("Enter the starting value: ");
        int start = scanner.nextInt();
        
        System.out.print("Enter the ending value: ");
        int end = scanner.nextInt();
        
        if (start < 2) {
            start = 2; // The smallest prime number is 2
        }
        
        // Print primes in the given range
        printPrimesInRange(start, end);
        
        scanner.close();
    }
}
