//So, This code is to find the cycle detection in Undirected Graph
package Graph;
import java.util.*;
class CycleDetection{
    int V;
    List<List<Integer>> adj;
    CycleDetection(int V){
        this.V = V;
        adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
    }
    static class Pair{
        int node;
        int parent;
        Pair(int node,int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    public void addEdge(int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u); // For undirected Graph.
    }
    public static void main(String[] args){
        CycleDetection graph = new CycleDetection(5); //Our Graph has 5 vertices.
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        //So these are the edge of the graph .
        //Lets call the dfs function to see the dfs.
        graph.dfs(0);
        graph.bfs(0);
        graph.isCyclic(0,-1);
    }
    public void dfs(int node){
        //So this is the function for the bfs, Now we will make a helper functionn to complete this.
        boolean[] visited = new boolean[V];
        System.out.println("The Dfs of the given graph is");
        dfsHelper(node,visited);
    }
    public void bfs(int node){
        int[] visited = new int[V];
        System.out.println("The bfs traversal of the given graph is");
        bfsHelper(node,visited);
    }
    public void isCyclic(int node , int parent){
        if(isCyclicHelper(node,parent)){
            System.out.println("The given graph  is Cyclic");
        }else{
            System.out.println("The given graph is acyclic");
        }
    }
    private boolean isCyclicHelper(int node,int parent){
        boolean[] visited = new boolean[V];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node,parent));
        visited[node] = true;
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int child = temp.node;
            int par = temp.parent;
            for(int neighbour : adj.get(child)){
                if(!visited[neighbour]){
                    q.offer(new Pair(neighbour,child));
                    visited[neighbour] = true;
                }else if(visited[neighbour] && neighbour!=par){
                    return true;
                }
            }
        }
        return false;
    }
    private void bfsHelper(int node,int[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = 1;
        while(!q.isEmpty()){
            int temp = q.poll();
            System.out.println(temp+" ");
            for(int neighbour : adj.get(temp)){
                if(visited[neighbour]==0){
                    visited[neighbour] = 1;
                    q.add(neighbour);
                }
            }
        }
    }
    private void dfsHelper(int node,boolean[] visited){
        visited[node] = true;
        System.out.println(node+" ");
        for(int neighbour:adj.get(node)){
            if(!visited[neighbour]){
                dfsHelper(neighbour,visited);
            }
        }
    }
}