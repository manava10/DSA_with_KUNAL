package Recursion.easy;
import java.util.List;
import java.util.ArrayList;
public class ArrayList2{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,6,7};
        int target = 4;
        List<Integer> ans = search(arr, target, 0);
        System.out.println(ans);
        
        // We have given an array we have to find the index of occurrence of target;
    }
    static ArrayList<Integer> search(int[] arr, int target, int index){
        //This is the recursive function// 
        ArrayList<Integer> list = new ArrayList<>();
        if(index==arr.length){
            return list;
        }

        //This will contain answers for that function call only.
        if(arr[index]==target){
            list.add(index);
        }
        //Recursive Function Call.
        ArrayList<Integer> answerFromBelow = search(arr, target, index+1);

        list.addAll(answerFromBelow);
        return list;
    }
}