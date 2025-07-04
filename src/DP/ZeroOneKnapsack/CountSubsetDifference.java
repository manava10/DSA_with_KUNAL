//So, we are given a subset , and we need to find the no of pair of subset can be made with that given difference.
package DP.ZeroOneKnapsack;
class CountSubsetDifference{
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0};
        int diff = 0;
        int n = arr.length;
        //We have to divide the
        int total_sum = 0;
        for(int num:arr){
            total_sum += num;
        }
        int target = (total_sum+diff)/2;

        if((total_sum+diff)%2!=0 || target>total_sum){
            System.out.println("There are no such partiton exist.");
            return;
        }
        // s1-s2 = diff, s1+s2 = total_sum; 2s1 = diff + total_sum ;
        // Now, we have to find the no of subset that exist which sums up to target
        int[][] dp = new int[n+1][target+1];
        //Initialization of Dynamic Programming table
        for(int i=0;i<=target;i++){
            dp[0][i] = 0;
        }
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println("The no ways of dividing into two  subset such that pair gives a difference of the given "+diff+ " is  :"+dp[n][target]);

    }

}
