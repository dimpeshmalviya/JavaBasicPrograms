// compatible version
import java.util.*;

public class TopologicalSort {

    public static void topoSortDFS(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        Stack stack = new Stack();   // <-- no <Integer>
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, adj);
            }
        }
        System.out.print("Topological Sort (DFS): ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    private static void dfs(int node, boolean[] visited, Stack stack, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        for (int neighbor : (ArrayList<Integer>) adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack, adj);
            }
        }
        stack.push(node);
    }

    public static void topoSortKahn(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int neighbor : (ArrayList<Integer>) adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < v; i++) if (indegree[i] == 0) queue.add(i);

        ArrayList<Integer> topoOrder = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);
            for (int neighbor : (ArrayList<Integer>) adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) queue.add(neighbor);
            }
        }

        System.out.print("Topological Sort (Kahn's Algorithm): ");
        for (int n : topoOrder) System.out.print(n + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());

        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        topoSortDFS(V, adj);
        topoSortKahn(V, adj);
    }
}
