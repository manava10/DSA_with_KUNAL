package easy;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(calFact(10));
        
    }
    static int calFact(int n){
        if(n==1){
            return n;
        }else{
            return n*calFact(n-1);
        }
    }
}
