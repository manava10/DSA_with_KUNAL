package Recursion.easy;

public class SortedArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3};
        System.out.println("The given array is Sorted Array: "+ sortedArray(arr, 0));  
    }
    static boolean sortedArray(int[] arr, int i){
        if(i == arr.length-2){
            return arr[i]<arr[i+1];
            //This block is Recursion Termination condition.
        }
        boolean temp = arr[i]<arr[i+1];
        return (temp) && sortedArray(arr, i+1);
    }
}
