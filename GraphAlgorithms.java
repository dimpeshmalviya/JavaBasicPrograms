import java.util.*;

/**
 * GraphAlgorithms.java
 *
 * A collection of commonly used graph algorithms useful for solving complex problems.
 * Includes:
 * - BFS, DFS
 * - Dijkstra (non-negative weights)
 * - Bellman-Ford (handles negative edges and detects negative cycles)
 * - Floyd-Warshall (all-pairs shortest paths)
 * - Topological sort (Kahn's algorithm)
 * - Kruskal and Prim (Minimum Spanning Tree)
 * - Kosaraju's strongly connected components
 * - A simple Union-Find implementation
 *
 * Small demo is included in main() to show usage.
 */
public class GraphAlgorithms {

    static class Edge {
        int from, to;
        long weight;

        Edge(int f, int t, long w) { from = f; to = t; weight = w; }
        Edge(int f, int t) { this(f, t, 1); }
        public String toString() { return String.format("(%d->%d, w=%d)", from, to, weight); }
    }

    static class Graph {
        final int n;
        final List<Edge>[] adj;
        final boolean directed;

        @SuppressWarnings("unchecked")
        Graph(int n, boolean directed) {
            this.n = n;
            this.directed = directed;
            adj = new List[n];
            for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        }

        void addEdge(int u, int v, long w) {
            adj[u].add(new Edge(u, v, w));
            if (!directed) adj[v].add(new Edge(v, u, w));
        }

        void addEdge(int u, int v) { addEdge(u, v, 1); }
    }

    // ---------- BFS (returns distance array and parent array) ----------
    public static int[] bfs(Graph g, int src) {
        int[] dist = new int[g.n];
        Arrays.fill(dist, -1);
        Deque<Integer> dq = new ArrayDeque<>();
        dist[src] = 0; dq.add(src);
        while (!dq.isEmpty()) {
            int u = dq.poll();
            for (Edge e : g.adj[u]) {
                int v = e.to;
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    dq.add(v);
                }
            }
        }
        return dist;
    }

    // ---------- DFS (returns discovery order) ----------
    public static List<Integer> dfs(Graph g) {
        boolean[] vis = new boolean[g.n];
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < g.n; i++) if (!vis[i]) dfsVisit(g, i, vis, order);
        return order;
    }

    private static void dfsVisit(Graph g, int u, boolean[] vis, List<Integer> order) {
        vis[u] = true;
        order.add(u);
        for (Edge e : g.adj[u]) if (!vis[e.to]) dfsVisit(g, e.to, vis, order);
    }

    // ---------- Dijkstra (non-negative weights) ----------
    public static long[] dijkstra(Graph g, int src) {
        final long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[g.n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new int[]{0, src}); // stores {dist, node} but dist as int for PQ; cast where needed

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            long d = cur[0];
            int u = cur[1];
            if (d != dist[u]) continue;
            for (Edge e : g.adj[u]) {
                int v = e.to; long w = e.weight;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[]{(int)dist[v], v});
                }
            }
        }
        return dist;
    }

    // ---------- Bellman-Ford (detects negative cycles) ----------
    public static Optional<long[]> bellmanFord(Graph g, int src) {
        final long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[g.n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        List<Edge> all = new ArrayList<>();
        for (int u = 0; u < g.n; u++) all.addAll(g.adj[u]);

        for (int i = 1; i <= g.n - 1; i++) {
            boolean updated = false;
            for (Edge e : all) {
                if (dist[e.from] != INF && dist[e.from] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[e.from] + e.weight; updated = true;
                }
            }
            if (!updated) break;
        }
        // check negative cycle
        for (Edge e : all) {
            if (dist[e.from] != INF && dist[e.from] + e.weight < dist[e.to]) return Optional.empty();
        }
        return Optional.of(dist);
    }

    // ---------- Floyd-Warshall (all-pairs shortest paths) ----------
    public static long[][] floydWarshall(Graph g) {
        final long INF = Long.MAX_VALUE / 4;
        int n = g.n;
        long[][] d = new long[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) d[i][j] = (i == j ? 0 : INF);
        for (int u = 0; u < n; u++) for (Edge e : g.adj[u]) d[e.from][e.to] = Math.min(d[e.from][e.to], e.weight);
        for (int k = 0; k < n; k++) for (int i = 0; i < n; i++) if (d[i][k] < INF)
            for (int j = 0; j < n; j++) if (d[k][j] < INF)
                d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
        return d;
    }

    // ---------- Topological sort (Kahn's algorithm) ----------
    public static Optional<List<Integer>> topologicalSort(Graph g) {
        if (!g.directed) throw new IllegalArgumentException("Topological sort requires a directed graph");
        int n = g.n; int[] indeg = new int[n];
        for (int u = 0; u < n; u++) for (Edge e : g.adj[u]) indeg[e.to]++;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) if (indeg[i] == 0) q.add(i);
        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll(); order.add(u);
            for (Edge e : g.adj[u]) if (--indeg[e.to] == 0) q.add(e.to);
        }
        if (order.size() != n) return Optional.empty();
        return Optional.of(order);
    }

    // ---------- Union-Find for Kruskal ----------
    static class UnionFind {
        int[] p, r;
        UnionFind(int n) { p = new int[n]; r = new int[n]; for (int i = 0; i < n; i++) p[i] = i; }
        int find(int x) { return p[x] == x ? x : (p[x] = find(p[x])); }
        boolean union(int a, int b) {
            a = find(a); b = find(b); if (a == b) return false;
            if (r[a] < r[b]) p[a] = b; else if (r[b] < r[a]) p[b] = a; else { p[b] = a; r[a]++; }
            return true;
        }
    }

    // ---------- Kruskal's MST (returns edges in MST) ----------
    public static List<Edge> kruskalMST(Graph g) {
        if (g.directed) throw new IllegalArgumentException("Kruskal requires undirected graph");
        List<Edge> edges = new ArrayList<>();
        for (int u = 0; u < g.n; u++) for (Edge e : g.adj[u]) if (e.from < e.to) edges.add(e);
        edges.sort(Comparator.comparingLong(e -> e.weight));
        UnionFind uf = new UnionFind(g.n);
        List<Edge> mst = new ArrayList<>();
        for (Edge e : edges) if (uf.union(e.from, e.to)) mst.add(e);
        return mst;
    }

    // ---------- Prim's MST (returns total weight) ----------
    public static long primMSTWeight(Graph g, int src) {
        if (g.directed) throw new IllegalArgumentException("Prim requires undirected graph");
        final long INF = Long.MAX_VALUE / 4; boolean[] used = new boolean[g.n];
        long[] dist = new long[g.n]; Arrays.fill(dist, INF);
        dist[src] = 0; long total = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new int[]{0, src});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll(); int u = cur[1]; long d = cur[0];
            if (used[u]) continue; used[u] = true; total += d;
            for (Edge e : g.adj[u]) if (!used[e.to] && e.weight < dist[e.to]) {
                dist[e.to] = e.weight; pq.add(new int[]{(int)dist[e.to], e.to});
            }
        }
        return total;
    }

    // ---------- Kosaraju's algorithm for SCCs ----------
    public static List<List<Integer>> kosarajuSCC(Graph g) {
        if (!g.directed) throw new IllegalArgumentException("Kosaraju requires directed graph");
        boolean[] vis = new boolean[g.n];
        Deque<Integer> order = new ArrayDeque<>();
        for (int i = 0; i < g.n; i++) if (!vis[i]) dfsOrder(g, i, vis, order);
        // build transpose
        Graph tr = new Graph(g.n, true);
        for (int u = 0; u < g.n; u++) for (Edge e : g.adj[u]) tr.addEdge(e.to, e.from, e.weight);
        Arrays.fill(vis, false);
        List<List<Integer>> comps = new ArrayList<>();
        while (!order.isEmpty()) {
            int v = order.pollLast();
            if (!vis[v]) {
                List<Integer> comp = new ArrayList<>();
                dfsCollect(tr, v, vis, comp);
                comps.add(comp);
            }
        }
        return comps;
    }

    private static void dfsOrder(Graph g, int u, boolean[] vis, Deque<Integer> order) {
        vis[u] = true;
        for (Edge e : g.adj[u]) if (!vis[e.to]) dfsOrder(g, e.to, vis, order);
        order.add(u);
    }

    private static void dfsCollect(Graph g, int u, boolean[] vis, List<Integer> comp) {
        vis[u] = true; comp.add(u);
        for (Edge e : g.adj[u]) if (!vis[e.to]) dfsCollect(g, e.to, vis, comp);
    }

    // ----------------- Demo main -----------------
    public static void main(String[] args) {
        System.out.println("GraphAlgorithms demo");

        // small directed graph for shortest path and SCC demo
        Graph dg = new Graph(6, true);
        dg.addEdge(0, 1, 5);
        dg.addEdge(0, 2, 3);
        dg.addEdge(1, 2, 2);
        dg.addEdge(2, 3, 7);
        dg.addEdge(3, 1, -6);
        dg.addEdge(4, 5, 1);

        System.out.println("BFS from 0: " + Arrays.toString(bfs(dg, 0)));
        System.out.println("DFS order: " + dfs(dg));

        System.out.println("Bellman-Ford from 0 (detect neg-cycle): ");
        Optional<long[]> bf = bellmanFord(dg, 0);
        if (bf.isPresent()) System.out.println(Arrays.toString(bf.get())); else System.out.println("Negative cycle detected");

        System.out.println("Kosaraju SCCs: " + kosarajuSCC(dg));

        // undirected graph for MST
        Graph ug = new Graph(5, false);
        ug.addEdge(0, 1, 2); ug.addEdge(0, 3, 6);
        ug.addEdge(1, 2, 3); ug.addEdge(1, 3, 8);
        ug.addEdge(1, 4, 5); ug.addEdge(2, 4, 7);

        List<Edge> mst = kruskalMST(ug);
        System.out.println("Kruskal MST edges: " + mst);
        System.out.println("Prim MST total weight from 0: " + primMSTWeight(ug, 0));

        // topological sort demo
        Graph dag = new Graph(6, true);
        dag.addEdge(5, 2); dag.addEdge(5, 0); dag.addEdge(4, 0);
        dag.addEdge(4, 1); dag.addEdge(2, 3); dag.addEdge(3, 1);
        Optional<List<Integer>> topo = topologicalSort(dag);
        System.out.println("Topological order (if present): " + topo.orElse(Arrays.asList()));

        System.out.println("Demo finished.");
    }
}
