package DP.ZeroOneKnapsack;
class EqualSumPartitionTab{
    public static void main(String[] args) {
        //We are writint the most effficient code for equal sum partitioning .
        //Here, We go baby.
        int[] arr = {1,5,10,8};
        int total = 0;
        int n = arr.length;
        for(int num:arr){
            total+=num;
        }
        if(total%2!=0){
            System.out.println("The given array cannot be partioned ");
        }else{
            Boolean[][] dp = new Boolean[n+1][(total/2)+1]; // This is a
            //Base Case
            for(int j=0;j<=(total/2);j++){
                dp[0][j] = false;
            }
            for(int i=0;i<=n;i++){
                dp[i][0] = true;
            }
            for(int i=1;i<=n;i++){
                for(int j=1;j<=(total/2);j++){
                    if(arr[i-1]<=j){
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            System.out.println("The given array can be equally partitioned :"+dp[n][total/2]);
        }
    }
}