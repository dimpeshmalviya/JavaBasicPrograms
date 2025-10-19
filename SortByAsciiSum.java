import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class SortByAsciiSum {

    // Helper method to calculate the sum of ASCII values for a string
    private static int getAsciiSum(String s) {
        int sum = 0;
        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // Add the ASCII value of the character to the sum
            sum += (int) c;
        }
        return sum;
    }

    public static void main(String[] args) {
        // Create an ArrayList of strings to be sorted
        List<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "cherry", "date"));

        System.out.println("Original list: " + list);

        // Sort the list using a custom Comparator
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // Compare based on the ASCII sum of each string
                return getAsciiSum(s1) - getAsciiSum(s2);
            }
        });

        System.out.println("Sorted list: " + list);
    }
}
