package Graph;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class KruskalAlgo{
    int V; //THis is vertex;
    private List<Edges> edges;
    private int[] rank;
    private int[] parent; //Have defined all the datatypes required for Kruskal.\
    KruskalAlgo(int V){
        this.V = V;
        rank = new int[V];
        parent = new int[V];
        edges = new ArrayList<>();
        for(int i = 0;i<V;i++){
            parent[i] = i;
        }
    }
    static class Edges{
        int u;
        int v;
        int w;
        Edges(int u,int v,int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    private  int find(int x){
        if(parent[x]==x){
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x] ; //THis is actually also known as path compressio
    }
    private void union(int x,int y){
        int parX = find(x);
        int parY = find(y);
        if(rank[parX]>rank[parY]){
            parent[parY] = parX;
        }else if(rank[parX]<rank[parY]){
            parent[parX] = parY;
        }else{
            parent[parY] = parX;
            rank[parX]++;
        }
    }//This is the union fn we have implemented;
    public static void main(String[] args) {
        KruskalAlgo graph = new KruskalAlgo(8);
        graph.edges.add(new Edges(1,2,5));
        graph.edges.add(new Edges(2,3,4));
        graph.edges.add(new Edges(3,4,3));
        graph.edges.add(new Edges(4,1,3));
        graph.edges.add(new Edges(1,5,8));
        graph.edges.add(new Edges(2,7,3));
        //As graph is unidirectional so, no need to procees that
        //SO, everything has been done, NOw i will write the code.//Now sort the edges.
        Collections.sort(graph.edges, Comparator.comparingInt(e->e.w));
        //Sorted on the basis of integer.
        int totalCost = 0;
        List<Edges> ans = new ArrayList<>();
        for(int i=0;i<graph.edges.size();i++){
            Edges temp = graph.edges.get(i);
            int u = temp.u;
            int v = temp.v;
            int w = temp.w;
             if(graph.find(u)==graph.find(v)){
                 continue;
             }else{
                 graph.union(u,v);
                 totalCost+=w;
                 ans.add(temp);
             }
        }
        System.out.println("The total minimum cost of this kruskal algorithm is that."+totalCost);
        System.out.println("And the edges are in given  format");
        for(Edges e : ans){
            System.out.println(e.u +"->"+e.v+"  Wt ="+e.w);
        }
    }
}