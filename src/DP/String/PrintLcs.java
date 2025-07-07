package DP.String;
class PrintLcs {
    public static void main(String[] args) {
        String a = "abac";
        String b = "cab";
        lengthLcs(a,b);
    }
    public static void lengthLcs(String a,String b){
        int[][] dp = new int[a.length()+1][b.length()+1];
        for(int i=1;i<=a.length();i++){
            for(int j=1;j<=b.length();j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println("The lcs of given string is :"+printLcs1( a,b, dp));
    }
    public static String printLcs1(String a,String b,int[][] dp){
        StringBuilder sb = new StringBuilder();
        int m = a.length();
        int n = b.length();
        int i = m;
        int j = n;
        while(i>0 && j>0){
            if(a.charAt(i-1)==b.charAt(j-1)){
                sb.append(a.charAt(i-1));
                i--;j--;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }
        return sb.reverse().toString();
    }
}

// So this is the code for printing the LCS