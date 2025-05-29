package Recursion;

import java.util.ArrayList;
import java.util.List;

public class TaregetSumDice {
    public static void main(String[] args){
        int target = 10;
        int[] dice = {1, 2, 3, 4, 5, 6}; // This line has no use in code . This is given just for Refermce
        List<String> answer = Target("",target);
        for(String a:answer){
            System.out.println(a);
        }
    }
    static List<String> Target(String processed,int unprocessed){
        if(unprocessed==0){
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        List<String> answer = new ArrayList<>();
        for(int i=1;i<=unprocessed && i<=6;i++){
            List<String> a = Target(processed+i,unprocessed-i);
            answer.addAll(a);
        }
        return answer;
    }
}
