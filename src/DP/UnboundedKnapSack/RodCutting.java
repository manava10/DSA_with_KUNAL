package DP.UnboundedKnapSack;
class RodCutting{
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = price.length;
        System.out.println("Maximum profit: " + rodCut(price, n));
    }
    public static int rodCut(int[] price,int N){
        int[] length = new int[N];
        for(int i=0;i<N;i++){
            length[i] = i+1;
        }
        int[][] dp = new int[N+1][N+1];
        for(int i = 1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(length[i-1]<j){
                    dp[i][j] = Math.max(dp[i-1][j],price[i-1]+dp[i][j-length[i-1]]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][N];
    }
}

// This is a classical problem of Unbounded KnapSack.