package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

class Graph{
    int V;
    List<List<Integer>> adj;
    Graph(int V){
        this.V = V;
        adj =  new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
    }
    public static void main(String[] args){
        Graph graph = new Graph(8);
        // So, we have given the number of vertex in our Graph to be five.
        graph.addEdge(0, 2);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3 );
        System.out.println("the bfs of the given graph is :");
        graph.bfs(0);
        System.out.println("the dfs of the given graph is :");
        graph.dfs(0);
    }
    public void addEdge(int u,int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // Make it bidirectional // We can see this is undirected.
    }
    public void bfs(int start){
        //we are giving the first node
        boolean[] visited = new boolean[V]; // This  is like if this node have been visited  or not
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node+" ");
            for(int neighbour : adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    queue.offer(neighbour);
                }
            }
        }
        System.out.println();

    }
    public void dfs(int start){
        boolean[] visitedArray = new boolean[V];
        dfsHelper(start,visitedArray);
    }
    private void dfsHelper(int start,boolean[] visited){
        visited[start] = true;
        System.out.print(start+ " ");
        for(int neighbour : adj.get(start)){
            if(!visited[neighbour]){
                dfsHelper(neighbour,visited);
                //this is the dfs traversal .
            }
        }
    }
}