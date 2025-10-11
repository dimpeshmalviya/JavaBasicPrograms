
import java.util.*;

public class CountSort {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int mx = arr[0];
        for (int i : arr) {
            if (i > mx) {
                mx = i;
            }
        }

        int[] countArray = new int[mx + 1];

        for (int i : arr) {
            countArray[i]++;
        }

        int index = 0;
        for (int i = 0; i <= mx; i++) {
            while (countArray[i] > 0) {
                arr[index] = i;
                index++;
                countArray[i]--;
            }
        }
    }
}
