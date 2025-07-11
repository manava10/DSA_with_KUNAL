package DP.MCM;
public class PalindromePartition{
    public static void main(String[] args) {
        String given = "aaaaa";
        //We have given a string , We have to find the minimum no of cuts so that all the parts are in palindrome.
        int i = 0;
        int j = given.length()-1;
        if(given.length()==0){
            System.out.println("Not possible to make palindrome");
        }else{
            System.out.println("The minimum no of cuts required so that the given string is partioned to make each part a Palindrome is :"+ minWays(given,i,j));
        }

    }
    static int minWays(String s,int i, int j){
        if((i==j) || isPalindrome(s,i,j)){
            return 0;
        }
        int minCut = Integer.MAX_VALUE;
        for(int k = i;k<j;k++){
            int cutCost1 = minWays(s,i,k);
            int cutCost2 = minWays(s,k+1,j);
            int result = cutCost1+cutCost2+1;
            minCut = Math.min(minCut,result);
        }
        return minCut;
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