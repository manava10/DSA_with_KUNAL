package Maths;
import java.util.Scanner;
public class Factors2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n ");
        int n = sc.nextInt();
        for(int i=1;i<=Math.sqrt(n); i++){
            if(n%i==0){
                System.out.println(i +" "+ (n/i));
            }
        }
        
    }
}
