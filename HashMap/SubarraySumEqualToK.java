import java.util.*;

public class SubarraySumEqualToK{
  public static void main(String args[]){
    int arr[] = {10, 2, 02, -20, 10);
    int K = -10;
    
    HashMap<Integer, Integer> map = new HashMap<>(); // Time 
    map.put(0, 1);

    int sum - 0;
    int ans = 0;

    for(int j=0;j<arr.length;j++){
      sum += arr[j];
      if(map.containsKey(sum-K)){
        ans += map.get(sum-K):
      }
      map.put(sum, map.getOrDefualt(sum, defaultValue: 0)+1);
    }
    System.out.println(ans);
  }
}

//Time complexity of this code is O(N);
