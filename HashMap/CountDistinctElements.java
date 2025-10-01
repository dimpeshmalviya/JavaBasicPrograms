import java.util.*;

public class CountDistinctElements {
    public static void main(String[] args) {
        int arr[] = {4,3,2,5,6,7,3,4,2,1};
        HashSet<Integer> hset = new HashSet<>();

        for(int i=0;i<arr.length;i++){
            hset.add(arr[i]);
        }
        System.out.println(hset.size());
    }
}