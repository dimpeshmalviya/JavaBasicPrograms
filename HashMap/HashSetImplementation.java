import java.util.*;

public class HashSetImplementation {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(1);
        set.add(2);

        System.out.println(set); // this will print only unique values

        set.remove(2);

        if(set.contains(2)){
            System.out.println("Set contains 2");
        }else{
            System.out.println("Set does not contains 2");
        }

        System.out.println(set.size());
        set.clear();

        System.out.println(set.size());
        System.out.println(set.isEmpty());
    }
}
