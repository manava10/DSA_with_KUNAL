package easy;
public class SumOfDigits {
    public static void main(String[] args) {
        
        int n = 55;
        //We have to find the sum of digits using the Recursion.
        System.out.println( sumOfDigits(n));
    }
    static int sumOfDigits(int n){
        if(n%10==n){
            return n ;
        }
        return (n%10)+ sumOfDigits(n/10);
    } 
}
