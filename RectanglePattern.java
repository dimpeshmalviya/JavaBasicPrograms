public class RectanglePattern {
    public static void main(String[] args) {
        int m = 4; // Number of rows
        int n = 6; // Number of columns

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
