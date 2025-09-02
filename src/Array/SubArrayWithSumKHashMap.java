package Array;
import java.util.*;
class SubArrayWithSumKHashMap{
    public static void main(String[] args) {
        int[] arr = {1,2,0,3,0};
        int target = 3;
        int count = 0;
        int prefixSum = 0;

        //First of all create a HashMap.
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num:arr){
            prefixSum += num;
            if(map.containsKey(prefixSum-target)){
                count += map.get(prefixSum-target);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        System.out.println(count);
    }
}
//Got it 6.