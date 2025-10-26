import java.util.*;

public class CombinationSumIII {
    
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    // Backtracking helper function
    private static void backtrack(List<List<Integer>> result, List<Integer> temp, int k, int remain, int start) {
        // Base case: if combination length == k and sum == n
        if (temp.size() == k && remain == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // Pruning: if sum exceeds or we already have k numbers, stop
        if (remain < 0 || temp.size() >= k) return;

        for (int i = start; i <= 9; i++) {
            temp.add(i);
            backtrack(result, temp, k, remain - i, i + 1);
            temp.remove(temp.size() - 1); // backtrack step
        }
    }

    // Main function to test
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements (k): ");
        int k = sc.nextInt();
        System.out.print("Enter target sum (n): ");
        int n = sc.nextInt();
        sc.close();

        List<List<Integer>> combinations = combinationSum3(k, n);

        System.out.println("\nAll valid combinations:");
        for (List<Integer> combo : combinations) {
            System.out.println(combo);
        }

        System.out.println("\nTotal combinations found: " + combinations.size());
    }
}
