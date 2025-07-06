package DP.String;
class lcsTabulation{
    public static void main(String[] args) {
        String a = "abcde";
        String b = "bcde";
        System.out.println("The length of lcs in the given substring is :"+lcsLength(a,b));
    }
    public static int lcsLength(String a,String b){
        //First of all we have to make a dp Table.
        int[][] dp = new int[a.length()+1][b.length()+1];
        //There is no need of initialization dont worry.
        for(int i=1;i<=a.length();i++){
            for(int j=1;j<=b.length();j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[a.length()][b.length()];

    }
}