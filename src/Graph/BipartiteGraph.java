package Graph;
import java.util.*;

class BipartiteGraph {
    int V;
    List<List<Integer>> adj;
    int[] color;

    BipartiteGraph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        color = new int[V];
        Arrays.fill(color, -1);
    }

    public static void main(String[] args) {
        BipartiteGraph graph = new BipartiteGraph(7);
        // Example edges
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 0); // This will form an odd cycle → not bipartite
        // Check bipartiteness
        if (graph.isGraphBipartite()) {
            System.out.println("The given graph is Bipartite using DfS.");
        } else {
            System.out.println("The given graph is NOT Bipartite using DFS .");
        }
    }

    public boolean isGraphBipartite() {
        Arrays.fill(color, -1); // Reset color array for each full check
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!helperIsBipartiteDfs(i,0,color)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean helperIsBipartiteBfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        color[node] = 0;

        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int neighbour : adj.get(temp)) {
                if (color[neighbour] == -1) {
                    color[neighbour] = 1 - color[temp];
                    q.offer(neighbour);
                } else if (color[neighbour] == color[temp]) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean helperIsBipartiteDfs(int node,int colour,int[] color){
        color[node] = colour;
        for(int neighbour : adj.get(node)){
            if(color[neighbour]==-1){
                if(!helperIsBipartiteDfs(neighbour,1-colour,color)){
                    return false;
                }
            }else if(color[neighbour]==color[node]){
                return false;
            }
        }
        return true;
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // undirected
    }
}