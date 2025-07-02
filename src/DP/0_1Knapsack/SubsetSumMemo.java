package DP;
public class SubsetSumMemo {
    public static boolean knapSack(int[] arr,int n, int target, boolean[][] dp){
        //first lets cover the base case;
        for(int i =0;i<=n;i++){
            for(int j=0;j<=target;j++){
                if(i==0 && j==0){
                    dp[i][j] = true;
                }
                else if(i==0 && j>0){
                    dp[i][j] = false;
                }
                else if(i>0 && j==0){
                    dp[i][j] = true;
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(arr[i-1]<=j){
                    //Then we will have two options either to take that one or to leave that one .
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
    public static void main(String[] args) {
        int[] arr = {2,3,7,8,10};
        int target = 11;
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][target+1];
        boolean result = knapSack(arr,n,target,dp);
        System.out.println(result);

    }
}