import java.util.*;

//HashMaps are unordered Map.

public class Operations{
    public static void main(String args[]){
        //Create
        HashMap<String, Integer> hm = new HashMap<>();
        //Insert
        hm.put("India", 100);
        hm.put("US", 50);
        hm.put("China", 150);
        
        System.out.println(hm);

        //Get
        int population = hm.get("India");
        System.out.println(population);

        System.out.println(hm.get("Nepal")); // this will print null

        //ContainsKey
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Indonasia"));

        //remove
        hm.remove("China");
        System.out.println(hm);

        //Size
        System.out.println(hm.size());

        //isEmpty
        // Clear function ->
        hm.clear();
        System.out.println(hm.isEmpty());
        
    }
}