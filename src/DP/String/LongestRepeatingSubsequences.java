package DP.String;
class LongestRepeatingSubsequences{
    public static void main(String[] args) {
        String given = "aabebcdd";
        int n = given.length();
        System.out.println("The length of lrs is "+lrslength(given,n));
    }
    static int lrslength(String given,int n){
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(given.charAt(i-1)==given.charAt(j-1) && i!=j){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println("The lrs is: "+printlrs(given,dp));
        return dp[n][n];
    }
    static String printlrs(String given,int[][] dp){

        StringBuilder sb = new StringBuilder();
        int x = given.length();
        int y = given.length();

        while(x>0 && y>0){
            if((given.charAt(x-1)==given.charAt(y-1)) && x!=y){
                sb.append(given.charAt(x-1));
                x--;
                y--;
            }else{
                if(dp[x-1][y]>dp[x][y-1]){
                    x--;
                }else{
                    y--;
                }
            }
        }
        return sb.reverse().toString();
    }
}