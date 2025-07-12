package DP.MCM;
import java.util.*;
class PalindromePartition{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string :");
        String input = sc.nextLine();
        int i = 0;
        int j = input.length()-1;
        System.out.println("The min of number of cut required is :"+ ways(input,i,j));
    }
    static int ways(String input,int i, int j){
        //First of all we well check if the given string is Palindrome
        if(isPalindrome(input,i,j)){
            return 0;
        }
        int minCut = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int left = ways(input,i,k);
            int right = ways(input,k+1,j);
            int cost = left+right+1;
            minCut = Math.min(minCut,cost);
        }
        return minCut;
    }
    static boolean isPalindrome(String s,int i,int j){
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