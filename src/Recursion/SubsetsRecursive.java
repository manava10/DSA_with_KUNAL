package Recursion;
import java.util.*;
public class SubsetsRecursive {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);

        // Print the result
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }

    // Recursive function to generate subsets
    public static void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current)); // Add copy of current subset
            return;
        }

        // Include the current element
        current.add(nums[index]);
        generateSubsets(index + 1, nums, current, result);

        // Exclude the current element (backtrack)
        current.remove(current.size() - 1);
        generateSubsets(index + 1, nums, current, result);
    }
}