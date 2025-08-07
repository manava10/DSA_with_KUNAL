package Graph;
import java.util.*;
class TopoLogicalSort{
    int V;
    List<List<Integer>> adj;
    TopoLogicalSort(int V){
        this.V = V;
        adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
    }
    public static void main(String[] args) {
        //Making a object for the Graph Class
        TopoLogicalSort graph = new TopoLogicalSort(6);
        graph.addEdge(5,0);
        graph.addEdge(5,2);
        graph.addEdge(4,0);
        graph.addEdge(4,1);
        graph.addEdge(2,3);
        graph.addEdge(3,1);
        graph.topoLogicalSort();
    }
    public void topoLogicalSort(){
        boolean[] visited = new boolean[V];
        Stack<Integer> ans = new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,visited,ans);
            }
        }
        while(!ans.isEmpty()){
            System.out.println(ans.pop()+" ");
        }
    }
    public void dfs(int node,boolean[] visited,Stack<Integer> stack){
        visited[node] =  true;
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour,visited,stack);
            }
        }
        stack.push(node); // Now lets print the Topological Sorting ,
    }
    public void addEdge(int u, int v){
        adj.get(u).add(v); //Directed Graph , So, we are using this only;
    }
}