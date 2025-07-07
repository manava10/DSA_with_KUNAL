package DP.String;
class Substring{
    public static void main(String[] args) {
        String a = "acdfgjdhk";
        String b = "cdfgi";
        System.out.println("The max length of substring of given two string is "+lengthSubstring(a,b));

    }
    public static int lengthSubstring(String a, String b){
        int[][] dp = new int[a.length()+1][b.length()+1];
        int maxLength = 0;
        for(int i=1;i<a.length()+1;i++){
            for(int j = 1;j<b.length()+1;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    maxLength = Math.max(maxLength,dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }

        }
        return maxLength;
        //The is code of substring.
    }


}