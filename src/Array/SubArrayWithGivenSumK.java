package Array;

import java.util.HashMap;

class SubArrayWithGivenSumK{
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,1,1};
        //We have to find the longes subarray haveing sum as K.
        int MaxLength = 0;
        int target = 3;
        int localSum = 0;
        //We have to do this using the prefix sum+hashmap.
        HashMap<Integer,Integer>  map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            localSum = localSum+arr[i];
            if(localSum==target){
                MaxLength = Math.max(MaxLength,i+1);
            }
            if(map.containsKey(localSum-target)){
                MaxLength = Math.max(MaxLength,i-map.get(localSum-target));
            }
            map.putIfAbsent(localSum,i); //We have to push the prefix sum in every case anyway,
        }
        System.out.println(MaxLength);
    }
}