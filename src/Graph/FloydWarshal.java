package Graph;
class FloydWarshaL{
    int V; // NO of vertex
    int[][] adj ;
    FloydWarshaL(int V){
        this.V = V;
        adj = new int[V][V]; //as the total no of vertex is  V\
    }
    public void addEdge(int i,int j, int d){
        adj[i][j]=d; //This is adding universal edge;
    }

    public static void main(String[] args) {
        //Make a object of this class
        FloydWarshaL graph = new FloydWarshaL(5); //So, our graph has 5 vertex, 0,1,2,3,4
        //Please add the edge in the graph.
        graph.addEdge(0,1,1);
        graph.addEdge(1,3,2);
        graph.addEdge(3,4,3);
        graph.addEdge(3,1,1);
        graph.addEdge(3,0,5);
        graph.addEdge(0,2,4);
        graph.addEdge(2,0,5);
         //So, we have defined all our edges.
        for(int i=0;i< graph.V;i++){
            for(int j = 0; j < graph.V; j++){
                if(i==j){
                    graph.adj[i][j]=0; //As this denotes self loop.
                }
                else if(graph.adj[i][j]==0){
                    graph.adj[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        graph.calcDist();
    }
    private void calcDist(){
        //So, we will calculate the distance in this function
        for (int k =0;k<V;k++){
            //HERE, K ACTS AS MEDIATOR NODE.
            for(int i=0;i<V;i++){
                for(int j=0;j<V;j++){
                    if(adj[i][k]==Integer.MAX_VALUE || adj[k][j]==Integer.MAX_VALUE){
                        continue;
                    }
                    adj[i][j] = Math.min(adj[i][j],adj[i][k]+adj[k][j]); //If we are getting minimum thats ok, else just let that original
                }
            }
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj[i][j]==Integer.MAX_VALUE){
                    System.out.print("INF"+" ");
                }else{
                    System.out.print(adj[i][j]+" ");

                }
            }
            System.out.println();
        }
    }
}