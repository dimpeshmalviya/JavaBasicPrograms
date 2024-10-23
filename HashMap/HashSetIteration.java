import java.util.*;

public class HashSetIteration {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Vidisha");
        cities.add("Bhopal");
        cities.add("Mumbai");

        // Iterator it = cities.iterator();
        // while(it.hasNext()){
        //     System.out.println(it.next());
        // }

        for(String city : cities){
            System.out.println(city);
        }
    }
}
