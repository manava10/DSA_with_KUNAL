import java.util.Scanner;
public class MagicNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        int i=1;
        while(n>0){
            int k = (n&1);
            ans += (int)( k * Math.pow(5, i));
            i++;
            n=n>>1;
        }
        System.out.println(ans);
    }
}

//Amazon Coding Question

//Log(N) is the complexity of this given number
