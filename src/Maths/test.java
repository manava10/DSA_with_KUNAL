import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        System.out.println(sqrt(number));
    }
    static int sqrt(int number){
        int s =0;
        int e =number;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(mid*mid == number){
                return mid;
            }
            else if(mid * mid > number){
                e = mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return s-1;
    }
}
