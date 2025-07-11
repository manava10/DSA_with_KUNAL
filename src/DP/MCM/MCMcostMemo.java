package DP.MCM;



class MCMcostMemo{
    public static void main(String[] args) {
        int[] arr = {20,30, 50 ,60 ,10};
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println("The optimal number of matrix multiplication is :"+solve(arr,1,n-1,dp));
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(dp[i][j]+ "     ");
            }
            System.out.println();
        }
    }
    static int solve(int[] arr,int i, int j,int[][] dp){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int minCost = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost1 = solve(arr,i,k,dp);
            int cost2 = solve(arr,k+1,j,dp);
            int finalcost = cost1+cost2+ arr[i-1]*arr[k]*arr[j];
            minCost = Math.min(minCost,finalcost);
        }
        dp[i][j] = minCost;
        return dp[i][j];
    }
}