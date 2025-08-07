package Graph;
import java.util.*;
public class TopoLogicalSortBfs{
    int V;
    List<List<Integer>> adj;
    TopoLogicalSortBfs(int V){
        this.V = V;
        adj = new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
    }
    public static void main(String[] args) {
        TopoLogicalSortBfs graph = new TopoLogicalSortBfs(6);
        graph.addEdge(5,0);
        graph.addEdge(5,2);
        graph.addEdge(4,0);
        graph.addEdge(4,1);
        graph.addEdge(2,3);
        graph.addEdge(3,1);
        graph.topoLogicalSort();
    }
    public void topoLogicalSort(){
        List<Integer> ans = new ArrayList<>();
        int[] inDegree = new int[V];
        //First we have to calculate the indegree of each node
        for(int  i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                inDegree[adj.get(i).get(j)]++;
            }
        }
        bfs(ans,inDegree);
        System.out.println(ans);
    }
    public void bfs(List<Integer> ans,int[] inDegree){
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                queue.offer(i); //So, added the having the node as indegree equal to zero.
            }
        }
        while(!queue.isEmpty()){
            int  temp = queue.poll();
            ans.add(temp);
            for(int neighbour : adj.get(temp)){
                inDegree[neighbour]--; //Whe have subtracted one from the indegrre of node to which our curren node points to,
                if(inDegree[neighbour]==0){
                    queue.offer(neighbour);
                }
            }
        }
    }
    public void addEdge(int u,int v){
        adj.get(u).add(v);
    }
}