package DP;

import java.util.Arrays;

public class KnapSackTopMemo {

    public static int knapSack(int[] wt,int[] value,int W,int n,int[][] dp){
        //Base Case
        if(n==0||W==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        if(wt[n-1]>W){
            dp[n][W] = knapSack(wt,value,W,n-1,dp);
        }else{
            int include = knapSack(wt,value,W-wt[n-1],n-1,dp)+value[n-1];
            int exclude = knapSack(wt,value,W,n-1,dp);
            dp[n][W] = Math.max(include,exclude);
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] wt = {1,2,3,4};
        int[] value = {2,5,2,4};
        int n = wt.length;
        int W = 10;
        int[][] dp = new int[n+1][W+1];
        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }
        int MaxProfit = knapSack(wt,value,W,n,dp);
        System.out.println("Max Profit: "+MaxProfit);
        long endTime = System.nanoTime();    // End time
        long duration = endTime - startTime;
        System.out.println("Execution time in milliseconds: " + (duration / 1_000_000.0) + " ms");// Time taken in nanoseconds
    }

}
//This is topDown approach of the KnapSack Problem.