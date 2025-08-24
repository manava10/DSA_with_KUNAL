package Graph;
class DSU{
    private int[] parent;
    private int[] rank;
    public DSU(int n){
        parent = new int[n];
        rank = new int[n];
        //Initializing that every node is it own parent ;
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
    //FInd with path compression;
    public int  find(int x){
        if(parent[x]==x){
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    //FInd union by rank;
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX==rootY){
            return; //ALready in the same set . Both are already  in the same set;l
        }
        if(rank[rootX]>rank[rootY]){
            parent[rootY]=rootX;
        }else if(rank[rootY]>rank[rootX]){
            parent[rootX]=rootY;
        }else{
            //If both have same rank. then what shoudl we do
            parent[rootY]=rootX;
            rank[rootX]++; //this can be also written vice versa manner. right.

        }
    }
    public static void main(String[] args){
        //THis is the main method of the  implementation.
        //Making a object of this class.
        DSU dsu = new DSU(7); //We have take size as 7 so, the node are from 0  to 6.
    }

}