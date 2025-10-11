public class TwoSum {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 5, 7, 10, 12 }; // Sorted array
        int target = 15;

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                System.out.println("Pair found: " + arr[left] + " + " + arr[right]);
                return;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println("No pair found.");
    }
}
