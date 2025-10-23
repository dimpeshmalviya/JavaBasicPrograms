public class MaxSumNoAdjacent {

    // Function to find the maximum sum such that no two elements are adjacent
    public static int findMaxSum(int[] nums) {
        // Edge case: if array is empty
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Edge case: if only one element
        if (nums.length == 1) {
            return nums[0];
        }

        // dp[i] will store the maximum sum until index i with the constraint
        int[] dp = new int[nums.length];

        // Base cases
        dp[0] = nums[0];                          // Only one element to pick
        dp[1] = Math.max(nums[0], nums[1]);       // Pick the larger of the first two

        // Fill dp array
        for (int i = 2; i < nums.length; i++) {
            // Either pick current element + dp[i-2], or skip current element (dp[i-1])
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        // The last element of dp contains the result
        return dp[nums.length - 1];
    }

    // Test the code
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 7, 10};
        int[] nums2 = {3, 2, 5, 10, 7};
        int[] nums3 = {5};
        int[] nums4 = {5, 5, 10, 100, 10, 5};
        int[] nums5 = {}; // edge case: empty array

        System.out.println("Test 1: " + findMaxSum(nums1)); // Expected: 13
        System.out.println("Test 2: " + findMaxSum(nums2)); // Expected: 15
        System.out.println("Test 3: " + findMaxSum(nums3)); // Expected: 5
        System.out.println("Test 4: " + findMaxSum(nums4)); // Expected: 110 (5 + 100 + 5)
        System.out.println("Test 5: " + findMaxSum(nums5)); // Expected: 0
    }
}
