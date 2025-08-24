package Graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class BellmanFord{
    int V;
    //As we are writing code for bellman for , we will make a matrix
    List<List<Pair>> adj;
    BellmanFord(int V){
        this.V = V;
        adj =  new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
    }
    class Pair{
        int v;
        int d;
        Pair(int v,int d){
            this.v = v;
            this.d = d;
        }
    }
    public void addEdge(int u,int v,int d){
        adj.get(u).add(new Pair(v,d)); //As this is unidirectionl Graph, SO, done like this.
    }

    public static void main(String[] args) {
        BellmanFord graph = new BellmanFord(5); //We have defined the graph having 5 vertices.
        int[] u = {0,0,0,1,1,2};
        int[] v = {1,2,4,2,3,4};
        int[] d = {1,3,8,2,1,-1};
        for(int i=0;i<u.length;i++){
            graph.addEdge(u[i],v[i],d[i]); //THis will add the edge in the graph.
        }
        graph.calcDistance();
    }
    public void calcDistance(){
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        for(int i=0;i<V-1;i++){
            //I have to iterate all the edges , then only anything can be done;
            for(int u=0;u<V;u++){
                for(Pair p:adj.get(u)){
                    //Relax the edge.
                    int v = p.v;
                    int d = p.d;
                    if(dist[u]==Integer.MAX_VALUE){
                        continue;
                    }
                    if(dist[v]>d+dist[u]){
                        dist[v] = dist[u]+d; //So, minimized the distance;
                    }
                }
            }

        }
        for(int u=0;u<V;u++){
            for(Pair p:adj.get(u)){
                //Relax the edge.
                int v = p.v;
                int d = p.d;
                if(dist[u]!=Integer.MAX_VALUE && dist[v]>d+dist[u]){
                   //The distance is still trying to improve , it means , that The graph contains a cycle.
                    System.out.println("The graph contains a cycle,");
                    return ;
                }
            }
        }
        System.out.println("So, the single source shortest pathis");
        for(int num:dist){
            System.out.print(num);
        }
    }
}
