package easy;
import java.util.Scanner;
public class OnetoN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of N");
        int n = sc.nextInt();
        fun(n);
        
    }
    static void fun(int n){
        if(n==0){
            return ;
        }
        fun(n-1);
        System.out.println(n);
    }
    
}
