import java.util.Scanner;
public class Factors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=20; i++){
            if(n%i==0){
                System.out.println(i);
            }
        }
        
    }
}

//Time complexity O(N);
