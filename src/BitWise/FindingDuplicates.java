package BitWise;
public class FindingDuplicates {
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3};
        //We are finding the unique among them;
         System.out.println(DuplicateElement(arr));
    }
    static int DuplicateElement(int[] arr){
        int unique=0;
        for(int n:arr){
            unique ^=n; 
        }
        return unique;
    }  
}
