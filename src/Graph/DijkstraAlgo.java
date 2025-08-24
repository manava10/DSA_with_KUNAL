package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgo {
    int V;
    List<List<Pair>> adj;
    DijkstraAlgo(int V){
        this.V = V;
        adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
    }
    static class Pair{
        int node;
        int dist;
        Pair(int node,int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public static void main(String[] args) {
        //Makws teh object of Main Class
        DijkstraAlgo graph = new DijkstraAlgo(5);
        graph.addEdge(0,1,1);
        graph.addEdge(0,2,3);
        graph.addEdge(0,3,3);
        graph.addEdge(0,4,1);
        graph.addEdge(1,2,1);
        graph.addEdge(3,4,1);
        graph.calDijk();
    }
    public void calDijk(){
        int[] dist = new int[V]; //We have made a array to find the distance with 0 as source node.
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0; //Have to initialize the initial distance of o to 0 is 0. Else,  it will not execute and show infinity.
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        //First of all , push the source node in the priority queuue with a dist 0
        pq.offer(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair temp = pq.poll();
            int u = temp.dist;
            int n = temp.node;
            for(Pair p : adj.get(n)){
                int  nd = p.node;
                int  di = p.dist;
                if(dist[nd]>u+di){
                    dist[nd]= u+di;
                    pq.offer(new Pair(nd,dist[nd]));
                }
            }
        }
        System.out.println("THe distance vector we are printing ");
        for(int i=0;i<V;i++){
            System.out.println(dist[i]+" ");
        }
    }
    public void addEdge(int src,int dest,int wt){
        adj.get(src).add(new Pair(dest,wt));
        adj.get(dest).add(new Pair(src,wt)); //As the graph is undirected , so we are adding two way edges.
    }
}