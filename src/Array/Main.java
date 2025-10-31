package Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*;

class TestClass{

    /**
     * Completes the function largestMagical to find the largest possible binary
     * value by rearranging adjacent minimal good substrings.
     * * A "good substring" is a non-empty string with an equal number of '1's and '0's,
     * and where every prefix has (count of '1's >= count of '0's).
     * * The strategy is:
     * 1. Decompose the string into the smallest, non-overlapping good substrings (minimal decomposition).
     * 2. Sort these substrings lexicographically in descending order to maximize the final binary number.
     * 3. Concatenate the sorted substrings.
     *
     * Time Complexity: O(N * k * log k), where N is the length of binString and k is the number of
     * good substrings (k <= N/2). This is very fast given N <= 50.
     *
     * @param binString A binary string guaranteed to be a "good string".
     * @return The largest possible binary value as a string.
     */
    public static String largestMagical(String binString) {
        // Step 1: Decompose the string into contiguous minimal good substrings.
        List<String> goodSubstrings = new ArrayList<>();
        int balance = 0; // Tracks the difference: 1s - 0s
        int startIndex = 0;

        for (int i = 0; i < binString.length(); i++) {
            char c = binString.charAt(i);

            // Increment for '1', decrement for '0'
            if (c == '1') {
                balance++;
            } else { // c == '0'
                balance--;
            }

            // A minimal good substring is found when the balance returns to 0 for the first time
            // since the last startIndex.
            if (balance == 0) {
                // Extract the substring (from startIndex up to i, inclusive).
                String goodSub = binString.substring(startIndex, i + 1);
                goodSubstrings.add(goodSub);

                // Update the starting point for the next minimal good substring search.
                startIndex = i + 1;
            }
        }

        // Step 2: Sort the list of substrings in descending lexicographical order.
        Collections.sort(goodSubstrings, Collections.reverseOrder());

        // Step 3: Concatenate the sorted substrings to form the result.
        StringBuilder result = new StringBuilder();
        for (String sub : goodSubstrings) {
            result.append(sub);
        }

        return result.toString();
    }
}