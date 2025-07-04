package DP.UnboundedKnapSack;
class RodCutting2{
    public static void main(String[] args) {
        int[] length = {1, 2, 4};
		int[] price  = {2, 5, 9};
	    int rodLength = 5;
        System.out.println("The maximum profit by cutting rod according tho given constraint is "+rodCut(length,price,rodLength));
    }
    public static int rodCut(int[] length,int[] price,int N){
        int n = length.length;
        int[][] dp =new  int[n+1][N+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=N;j++){
                if(length[i-1]<=j){
                    dp[i][j] = Math.max(price[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][N];
    }
}