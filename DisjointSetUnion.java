import java.util.*;

public class DisjointSetUnion {

    static int getParent(int x, int[] parent) {
        if (parent[x] == x) return x;
        parent[x] = getParent(parent[x], parent);  // Path compression
        return parent[x];
    }

    static void unite(int a, int b, int[] parent, int[] rank) {
        int pa = getParent(a, parent);
        int pb = getParent(b, parent);

        if (pa == pb) return;  // Already in the same set

        if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        } else if (rank[pb] > rank[pa]) {
            parent[pa] = pb;
        } else {
            rank[pa]++;
            parent[pb] = pa;
        }
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] rank = new int[n];
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < q; i++) {
            String str = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            a--; b--;  // zero-based indexing

            if (str.charAt(0) == 'u') {
                unite(a, b, parent, rank);
            } else {
                if (getParent(a, parent) == getParent(b, parent)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solve(sc);
        sc.close();
    }
}
