package DP.MCM;
public class PalindromePartitionMemo{
    public static void main(String[] args) {
        String given = "nitin";
        //We have given a string , We have to find the minimum no of cuts so that all the parts are in palindrome.
        int i = 0;
        int j = given.length()-1;
        int[][] dp = new int[given.length()][given.length()];
        for(int row=0;row<=j;row++){
            for(int col=0;col<=j;col++){
                dp[row][col] = -1;
            }
        }
        if(given.length()==0){
            System.out.println("Not possible to make palindrome");
        }else{
            System.out.println("The minimum no of cuts required so that the given string is partioned to make each part a Palindrome is :"+ minWays(given,i,j,dp));
        }

    }
    static int minWays(String s,int i, int j,int[][] dp){
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if((i==j) || isPalindrome(s,i,j)){
            dp[i][j]=0;
            return dp[i][j];
        }

        int minCut = Integer.MAX_VALUE;
        for(int k = i;k<j;k++){
            int left =  minWays(s,i,k,dp);
            int right = minWays(s,k+1,j,dp);
            int result = left+right+1;
            minCut = Math.min(minCut,result);
        }
        dp[i][j] = minCut;
        return dp[i][j];
    }
    static boolean isPalindrome(String s,int i,int j){
        //this method is to find the if a given string is Palindrome or not.
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
//This pure recursive code is not much optimized, a little optimized code.
//This is pure Recursive code. Now i will memoize it to get the little optimized Version .
// So, i have written this . I am a little bit pround of myself.
