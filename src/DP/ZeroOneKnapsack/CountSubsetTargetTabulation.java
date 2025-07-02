package DP.ZeroOneKnapsack;
class CountSubsetTargetTabulation {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,8};
        int target = 5;
        int  n = arr.length;
        //We are doing it using tabulation bottom UP dynammic programming ,

        int[][] dp = new int[n+1][target+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;//When we have to find the subset having sum as zer0
        }
        for(int j=0;j<=target;j++){
            dp[0][j] = 0; // Base case, when we have we have to make target using array of size 0,
        }
        for(int i = 1;i <= n; i++){
            for(int j=1;j <=target ;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]]; // include + exclude.
                }else{
                    dp[i][j] = dp[i-1][j]; // This one is just exclude. without including ,
                }
            }
        }
        System.out.println("The number of ways of making the target by using differnt subset is :"+dp[n][target]);
        // I guess the code is all correct we should run this ,
    }
}