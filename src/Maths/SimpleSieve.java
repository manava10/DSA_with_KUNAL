package Maths;

import java.util.Scanner;
public class SimpleSieve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n = sc.nextInt();
        Boolean[] arr = new Boolean[n+1];
        for(int i=2;i<=n;i++){
            arr[i] = true;
        }
        for(int i=2; i*i<n; i++){
            if(arr[i]){
                for(int j=i*i;j<=n;j=j+i){
                    arr[j]=false;
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(arr[i]){
                System.out.println(i);
            }
        }
    }
}

//Time Complexity O( N ln(ln N))
