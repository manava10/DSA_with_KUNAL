package DP.ZeroOneKnapsack;
public class KnapSackRecursion{
    public static int knapSack(int[] wt,int[] val,int W,int n){
        if(n==0 || W==0){
            return 0;
        }
        if(W<wt[n-1]){
            return knapSack(wt,val,W,n-1);
        }else{
            int include = val[n-1] + knapSack(wt,val,W-wt[n-1],n-1);
            int exclude =   knapSack(wt,val,W,n-1);
            return Math.max(include,exclude);
        }
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] wt = {1,2,3,5,2,6};
        int[] val = {3,5,2,9,4,6};
        int W = 10;
        int maxProfit = knapSack(wt,val,W,wt.length);
        System.out.println("Maximum Value: "+ maxProfit);

        long endTime = System.nanoTime();    // End time
        long duration = endTime - startTime;
        System.out.println("Execution time in milliseconds: " + (duration / 1_000_000.0) + " ms");// Time taken in nanoseconds

    }
}
// I have written this using Recursion.