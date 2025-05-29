import java.util.Scanner;
public class PowerOfTwo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of n");

        int n = sc.nextInt();

        boolean ans = ( n & (n-1))==0;

        System.out.println("The given number is power of 2 : "+ans);
    }
}

//This is the second code.

