package Recursion;

import java.util.*;
public class SubsetRep{
    public static void main(String[] args){
        int[] arr = {3,3,3,3};
        List<List<Integer>> ans = subset(arr);
        for(List<Integer> a:ans){
            System.out.println(a);
        }
    }
    public static  List<List<Integer>> subset(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        ans.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for(int i=0;i<arr.length;i++){
            start = 0;
            if(i>0 && arr[i]==arr[i-1]){
                start = end+1;
            }
            end = ans.size()-1;
            int size = ans.size();
            for(int j=start;j<size;j++){
                List<Integer> internal = new ArrayList<>(ans.get(j));
                internal.add(arr[i]);
                ans.add(internal);
            }
        }
        return ans;
    }
}