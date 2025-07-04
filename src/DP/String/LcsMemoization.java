package DP.String;
class LcsMemoization{
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "bce";

        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                dp[i][j] = -1;
            }
        }
        System.out.println("The length of lcs is :"+lcsLeng(s1,s2,0,0,dp));
    }
    public static int lcsLeng(String s1,String s2,int p, int k,int[][]dp){
        if(s1.length()==p || s2.length()==k){
            return 0;
        }
        if(dp[p][k]!=-1){
            return dp[p][k];
        }
        if(s1.charAt(p)==s2.charAt(k)){
            dp[p][k] = 1+lcsLeng(s1,s2,p+1,k+1,dp);
            return dp[p][k];
        }else{
            dp[p][k] = Math.max(lcsLeng(s1,s2,p+1,k,dp),lcsLeng(s1,s2,p,k+1,dp));
            return dp[p][k];
        }
    }
}