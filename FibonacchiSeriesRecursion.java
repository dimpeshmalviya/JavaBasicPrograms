public class FibonacchiSeriesRecursion {

    // Recursive method to calculate nth Fibonacci number
    public static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    // Main method to print Fibonacci series up to n terms
    public static void main(String[] args) {
        int n = 10; // Change this value to print more or fewer terms
        System.out.println("Fibonacci series up to " + n + " terms:");
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
    }

}
