import java.util.*;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 25};
        int[] result = findNextGreaterElements(nums);
        System.out.println("Next Greater Elements:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    public static int[] findNextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nextGreater = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Pop smaller elements
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            // If stack is empty, no greater element
            nextGreater[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push current element
            stack.push(nums[i]);
        }

        return nextGreater;
    }
}
