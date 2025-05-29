import java.util.Scanner;

public class EvenOdd{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value for which you wanna check odd or even");
        int n = sc.nextInt();
        if((n&1)==1){
            System.out.println("The given number is Odd");
        }else{
            System.out.println("The given number is Even");
        }
    }
}