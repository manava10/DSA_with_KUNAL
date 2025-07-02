package DP;//package DP;
import java.util.Scanner;
//public class fibonacciDP {
//    static int[] fib;
//    public static void main(String[] args) {
//        //First i am writing a recursive code , then i will write a memoization then bottomUp\
//        System.out.println("Enter the value for which ");
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        fib = new int[n+1];
//        for(int i=0;i<=n;i++){
//            fib[i]=-1;
//        }
//        System.out.println(fibonaci(n));
//    }
//    public static int fibonaci(int n){
//        if(n==0){
//            return 0;
//        }
//        if(n==1){
//            return 1;
//        }
//        if(fib[n]!=-1) return fib[n];
//        int a = fibonaci(n-1);
//        int b = fibonaci(n-2);
//        fib[n] = a+b;
//        return fib[n];
//    }
//}

public class fibonacciDP{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n for which you wanna find the fibonacci seq");
        int n = sc.nextInt();
        System.out.println(fibBottomUp(n));

    }
    public static int fibBottomUp(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2]; //This is one directional Dynammic Programming , There is no need or two matrix or Array here.
        }
        return dp[n];
    }
}