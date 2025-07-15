package DP.ZeroOneKnapsack;
public class KnapSackTabulation{
    public static int knapSack(int[] wt,int[] val,int W,int n,int[][] dp){
        // Initialize , it is same as base condition in Recursion.
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(wt[i-1]<=j){
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        //I want print the dynamic Programming Table, Let's Do it . Yay..
        System.out.println("DP Table:");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                System.out.print(dp[i][j] + "\t"); // tab for better alignment
            }
            System.out.println();
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] wt = {1,2,3};
        int[] val = {10,15,40};
        int W = 5;
        int n = wt.length;
        int[][] dp = new int[n+1][W+1];
        int maxProfit = knapSack(wt,val,W,n,dp);
        System.out.println("Max Profit:"+maxProfit);
        long endTime = System.nanoTime();    // End time
        long duration = endTime - startTime;
        System.out.println("Execution time in milliseconds: " + (duration / 1_000_000.0) + " ms");// Time taken in nanoseconds
    }
}