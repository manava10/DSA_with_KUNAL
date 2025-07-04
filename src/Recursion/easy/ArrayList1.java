package easy;
import java.util.List;
import java.util.ArrayList;
public class ArrayList1{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,6,7};
        int target = 4;
        List<Integer> ans = new ArrayList<>();
        search(arr, target, 0,ans);
        System.out.println(ans);
        // We have given an array we have to find the index of occurrence of target;
    }
    static List<Integer> search(int[] arr, int target, int index,List<Integer> ans){
        //This is the recursive function// 
        if(index==arr.length){
            return ans;
        }
        if(arr[index]==target){
            ans.add(index);
        }
        //Recursive Function Call.
        return search(arr, target, index+1, ans);
    }
}