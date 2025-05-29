package easy;
//LinearSearch with Recursion.
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {};
        int target = 2;
        int targetIndex = search(arr, 0, target);
        if(arr.length==0 || targetIndex==-1 ){
            System.out.println("The target is not present in the array.");
        }else{
            System.out.println("The target is present at the index:"+targetIndex);
        }
        //We have to search the target variable in array. by applying linear search in a recursive way.
    }
    static int search(int[] arr,int index,int target){
        if(arr.length>=index){
            return -1;
        }
        if(arr[index]==target){
            return index;
        }
        return search(arr, index+1,target);
    }
}
