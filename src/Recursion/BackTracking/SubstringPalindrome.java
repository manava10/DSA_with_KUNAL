package Recursion.BackTracking;

import java.util.ArrayList;
import java.util.List;

class SubstringPalindrome{
    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        String a = "abcde";
        generateSubstrings(0,a,ls);
    }
     static void generateSubstrings(int index, String s, List<String> temp) {
        if (index == s.length()) {
            System.out.println(temp);  // final partition
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String substr = s.substring(index, i + 1);  // generate substring
            temp.add(substr);
            generateSubstrings(i + 1, s, temp);         // explore further
            temp.remove(temp.size() - 1);               // backtrack
        }
    }
}