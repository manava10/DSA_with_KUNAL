package Recursion;
import java.util.*;

public class TargetSum {
    public static void main(String[] args){
        int target = 10;
        List<List<Integer>> result = Target(new ArrayList<>(), target);
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }

    static List<List<Integer>> Target(List<Integer> processed, int unprocessed){
        List<List<Integer>> combinations = new ArrayList<>();

        if (unprocessed == 0) {
            combinations.add(new ArrayList<>(processed));
            return combinations;
        }

        for (int i = 1; i <= unprocessed && i <= 6; i++) {
            processed.add(i);
            combinations.addAll(Target(processed, unprocessed - i));
            processed.remove(processed.size() - 1);
        }

        return combinations;
    }
}
