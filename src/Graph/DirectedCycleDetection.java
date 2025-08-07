package Graph;
import java.util.*;
class DirectedCycleDetection{
    int V;
    List<List<Integer>> adj;
    DirectedCycleDetection(int V){
        this.V = V;
        adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
    }
    public void addEdge(int v,int u){
        adj.get(v).add(u); // As the graph is directed so only one edge
    }
    public static void main(String[] args){
        DirectedCycleDetection graph = new DirectedCycleDetection(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(2,0);
        if(graph.isCyclic()){
            System.out.println("The given graph is Cyclic");
        }else{
            System.out.println("The given graph is not Cyclic");
        }
    }
    public boolean isCyclic(){
        boolean[] visited = new boolean[V];
        boolean[] rS = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(helperIsCyclic(i,visited,rS)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean helperIsCyclic(int i,boolean [] visited,boolean [] rS){
        visited[i] = true;
        rS[i] = true;
        for(int neighbour: adj.get(i)){
            if(!visited[neighbour]){
               if(helperIsCyclic(neighbour,visited,rS)) {
                   return true;
               }
            }else{
                if(rS[neighbour]){
                    return true;
                }
            }
        }
        rS[i] = false;
        return false;
    }

}