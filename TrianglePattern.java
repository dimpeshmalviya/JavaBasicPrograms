public class TrianglePattern {
    public static void main(String[] args) {
        int n = 5; // You can change this to any number

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
