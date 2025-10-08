import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};

        radixSort(arr);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
    }

    // Main radix sort function
    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        // Do counting sort for every digit. exp is 10^i (i = 0,1,2..)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    // A utility function to get the maximum value in the array
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // A function to do counting sort of arr[] according to the digit represented by exp
    public static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // output array
        int[] count = new int[10]; // count array for digits 0-9

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Change count[i] so that count[i] now contains actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy the output array to arr[], so that arr[] now contains sorted numbers according to current digit
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}
