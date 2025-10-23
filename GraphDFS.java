import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GraphDFS {
    private int V;
    private List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public GraphDFS(int V) {
        this.V = V;
        adj = (List<Integer>[]) new ArrayList[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public void dfsRecursive(int s) {
        boolean[] visited = new boolean[V];
        dfsRec(s, visited);
        System.out.println();
    }

    private void dfsRec(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : adj[v]) if (!visited[n]) dfsRec(n, visited);
    }

    public void dfsIterative(int s) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                visited[v] = true;
                System.out.print(v + " ");
                for (int i = adj[v].size() - 1; i >= 0; i--) stack.push(adj[v].get(i));
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GraphDFS g = new GraphDFS(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.dfsRecursive(0);
        g.dfsIterative(0);
    }
}