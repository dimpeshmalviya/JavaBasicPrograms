import java.util.*;

public class MajorityElements {
    public static void main(String[] args) {
        
        int arr[] = {1,3,2,5,1,3,1,5,1}; 
        int majority1 = Integer.MIN_VALUE, majority2 = Integer.MIN_VALUE , count1 = 0 , count2 = 0;
        
        for(int i=0;i<arr.length;i++){
            
            if(arr[i] == majority1) {
                count1++;
            } else if(arr[i] == majority2){
                count2++;
            } else if(count1 == 0){
                majority1 = arr[i];
                count1 = 1;
            } else if(count2 == 0){
                majority2 = arr[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0 ;
        count2 = 0;

        for(int i=0;i<arr.length;i++){
            if(arr[i] == majority1) count1++;
            if(arr[i] == majority2) count2++;
        }

        List<Integer> majority = new ArrayList<>();

        if(count1 > arr.length/3) majority.add(majority1);
        if(count2 > arr.length/3) majority.add(majority2);

        majority.forEach(System.out::println);
    }
}


//Time complexity of this code is O(N) , Space Complexity is O(1);
