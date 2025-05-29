//BruteForce SOLUTIONS

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


class Main {
    public static void main(String[] args) {
        String[] arr = {"d","b","c","b","c","a"};
        int k = 2;
        System.out.println(kthDistinct(arr,k));
    }
    static String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> temp = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        for(String word: arr){
            temp.put(word,temp.getOrDefault(word,0)+1);
        }
        for(Map.Entry<String,Integer> entry : temp.entrySet()){
            if(entry.getValue()==1){
                arrayList.add(entry.getKey());
            }
        }
        String[] arrayTemp = arrayList.toArray(new String[0]);
        if(k>arrayTemp.length){
            return "";
        }else{
            return arrayTemp[k-1];
        }
    }
}
