package Recursion;
import java.util.*;
public class Subset{
    public static void main(String[] args){
        int[] arr = {1,2,3};
        List<List<Integer>> ans = subset(arr);
        for(List<Integer> list:ans){
            System.out.println(list);
        }


    }
    static List<List<Integer>> subset(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int i=0;i<arr.length;i++){
            int size = outer.size();
            if(i>0 && arr[i-1]==arr[i]){
                for(int j = (size)/2;j<(size);j++){
                    List<Integer> internal = new ArrayList<>(outer.get(j));
                    internal.add(arr[i]);
                    outer.add(internal);
                }
            }else{
                for(int j=0;j<size;j++){
                    List<Integer> internal = new ArrayList<>(outer.get(j));
                    internal.add(arr[i]);
                    outer.add(internal);
                }
            }
        }

        return outer;
    }
}