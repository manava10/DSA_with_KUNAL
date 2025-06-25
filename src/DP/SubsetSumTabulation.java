package DP;
public class SubsetSumTabulation {
    public static void main(String[] args) {
        //SO we are give a sum and a target and we have to chek if it can create
        int[] arr = {3,4,5,1,9};
        int target = 8;
        int n = arr.length;
        Boolean[][] dp = new Boolean[n+1][target+1];
        boolean a = checkSumExist(arr,target,n,dp);
        System.out.println(a);
    }
    public static boolean checkSumExist(int[] arr,int target,int n,Boolean[][] dp){
        if(target==0){
            return true;
        }if(n<=0){
            return false;
        }
        if(dp[n][target] != null){
            return dp[n][target];
        }
        if(arr[n-1]<=target){
            dp[n][target] = checkSumExist(arr,target-arr[n-1],n-1,dp) || checkSumExist(arr,target,n-1,dp);
        }else{
            dp[n][target] = checkSumExist(arr,target,n-1,dp);
        }
        return dp[n][target];
    }
}