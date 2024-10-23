import java.util.*;

public class Iteration {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 150);
        hm.put("China", 200);
        hm.put("US", 50);
        hm.put("Nepal", 30);

        //Iterate -> O(1)
        //We can also do this using entrySet.
        Set<String> keys = hm.keySet();

        System.out.println(keys);

        for (String k : keys) {
            System.out.println("Key = " + k + " and value = " + hm.get(k));
        }
    }
}
