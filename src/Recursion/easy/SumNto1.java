package Recursion.easy;

public class SumNto1 {
    public static void main(String[] args) {
        System.out.println(sum(10));
    }
    static int sum(int n){
        if(n==0){
            return 0;
        }else{
            return n+sum(n-1);
        }
    }  
}
