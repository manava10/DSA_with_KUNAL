package DP.UnboundedKnapSack;
class CoinChangeVariation1{
    public static void main(String[] args) {
        int[] coin = {1,2,3};
        int target = 4;
        int n = coin.length;
        System.out.println("The max no of combination of coin taken from the array of coin to reach the target is :"+ maxWays(coin,target,n));

    }
    public static int maxWays(int[] coin,int target, int n){
        int[][] dp = new int[n+1][target+1];
        for(int i=0;i<=target;i++){
            dp[0][i] = 0;
        }
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        //Now fill the Dynamic Programming Table according to Unbounded KnapSack Conditions.
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(coin[i-1]<=j){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coin[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][target];

    }
}