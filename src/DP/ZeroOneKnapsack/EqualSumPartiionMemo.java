package DP.ZeroOneKnapsack;
class EqualSumPartitionMemo{
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        int total =0;
        for(int num:arr){
            total+=num;
        }
        if(total%2!=0){
            System.out.println("Cannot be partioned");
        }else{
            Boolean[][] dp = new Boolean[arr.length+1][(total/2)+1];
            boolean result = isEqual(arr,arr.length,total/2,dp);
            System.out.println("The give array is partioned :"+result);
        }
    }
    static boolean isEqual(int[] arr,int n,int target,Boolean[][] dp){
        if(target == 0){
            dp[n][target] = true;
            return dp[n][target];
        }
        if(n==0){
            dp[n][target] = false;
            return dp[n][target];
        }
        if(dp[n][target]!=null){
            return dp[n][target];
        }
        if(arr[n-1]<=target){
            dp[n][target] = isEqual(arr,n-1,target-arr[n-1],dp) || isEqual(arr,n-1,target,dp);
            return dp[n][target];
        }
        dp[n][target] = isEqual(arr,n-1,target,dp);
        return dp[n][target];
    }
}