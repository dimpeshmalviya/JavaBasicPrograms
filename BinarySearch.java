import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " sorted elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input target element
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        // Perform binary search
        int result = binarySearch(arr, key);

        // Display result
        if (result == -1)
            System.out.println("Element not found!");
        else
            System.out.println("Element found at index: " + result);

        sc.close();
    }

    // Binary Search Method
    public static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2; // prevent integer overflow

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1; // Element not found
    }
}
