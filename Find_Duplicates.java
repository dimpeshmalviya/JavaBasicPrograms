import java.util.Scanner;
import java.util.Arrays;
public class find_duplicates {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                System.out.println(true);
                break;
            }
        }
        System.out.println(false);
    
    }
}
