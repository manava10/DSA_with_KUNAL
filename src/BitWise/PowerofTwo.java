package BitWise;
import java.util.Scanner;
public class PowerofTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number you wanna check if it is power of two or not");

        int num = sc.nextInt();

        System.out.println("The given number is power of two:" + isPower(num));

    }
    private static boolean isPower(int a){

        if(a==1){
            return false;
        }
        int m = 0;
        while(a>0){
            int k = a&1;
            if(k==1){
                m++;
            }
            a=a>>1;
        }
        return m==1;
    }
}

//Code to check If a given number is power of two using the famous bit operator.
