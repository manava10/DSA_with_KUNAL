import java.util.Scanner;
public class SquareRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter the value for which you want to get Square root");
        int p = sc.nextInt();
        System.out.println("Enter the number of precison you want");
        System.out.println(sqrt(n,p));
    }
    static double sqrt(int n, int p){
        int s=0;
        int e=n;

        double incr = 0.1;
        double root = 0.0;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(mid*mid==n){
                return mid;
            }
            if(mid * mid > n){
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        
//The below loop is for decimal points. The below loop is for decimal points
        
        for(int i=0;i<p;i++){
            while(root * root <= n){
                root = root+incr;
            }
            root = root-incr;
            incr = incr/10;
        }

        return root;
    }
}
//AweStrucking Code.
