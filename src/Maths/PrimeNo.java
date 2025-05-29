import java.security.Key;
import java.util.Scanner;
public class PrimeNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<n;i++){
            System.out.println(i+"  "+isPrime(i));
        }
    }
    static boolean isPrime(int k){
        if(k<=1){
            return false;
        }
        int c = 2;
        while( c*c <= k){
            if(k%c==0){
                return false;
            }
            c++;
        }
        return true;
    }

}
