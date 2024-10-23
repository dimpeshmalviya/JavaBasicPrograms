import java.util.*;

public class UnionAndIntersection {
    // Union of 2 arrays
    public static void Union(int arr1[], int arr2[]) { // O(n+m)
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }

        System.out.println(set.size());
        // Printing the elements of the array
        // System.out.println(set);
    }

    // Intersection of 2 arrays
    public static void Intersection(int arr1[], int arr2[]) { // O(n+m)
        HashSet<Integer> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                count++;
                set.remove(arr2[i]);
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };

        Union(arr1, arr2);
        Intersection(arr1, arr2);
    }
}
