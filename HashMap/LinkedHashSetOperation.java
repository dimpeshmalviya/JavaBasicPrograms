import java.util.*;

//ordered set

public class LinkedHashSetOperation {
    public static void main(String args[]){
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Vidisha");
        cities.add("Noida");
        cities.add("Mumbai");

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Vidisha");
        lhs.add("Noida");
        lhs.add("Mumbai");

        System.out.println(cities);
        System.out.println(lhs);
    }
}
