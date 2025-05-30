package Maths;

// Printing prime Number from 1 to a given n.
//Time complexity is Root n
import java.util.Scanner;
public class PrimeNo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=2;i<=n;i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }

    }
    static boolean isPrime(int k){
        if(k<=1){
            return false;
        }
        int p=2;
        while((p*p)<k || (p*p)==k){
            if(k%p==0){
                return false;
            }
            p++;
        }
        return true;
    }
}
