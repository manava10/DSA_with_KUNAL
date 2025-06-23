package DP;
class KnapSackTabulation1{
    public static int knapSack(int[] wt,int[] val,int W,int n,int[][] dp){
        for(int i=0;i<=n;i++){
            for(int w=0;w<=W;w++){
                if(i==0 || w==0){
                    dp[i][w] = 0;
                }
                else if(wt[i-1]<w){
                    dp[i][w] = Math.max(val[i-1]+dp[i-1][w-wt[i-1]],dp[i-1][w]);
                }else{
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int[] wt = {2,4,1,5,8,3};
        int[] val = {8,6,10,9,7,3};
        int W = 8;
        int n = wt.length;
        int[][] dp = new int[n+1][W+1];
        int maxProfit = knapSack(wt,val,W,n,dp);
        System.out.println("Max Profit for the given arrangement is :"+maxProfit);
    }

}