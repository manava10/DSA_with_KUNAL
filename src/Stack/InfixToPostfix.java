package Stack;

import java.util.*;

class InfixToPostfix {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> prTable = new HashMap<>();
        prTable.put('+', 1);
        prTable.put('-', 1);
        prTable.put('*', 2);
        prTable.put('/', 2);
        prTable.put('^', 3);
        String given = "1+2/3^8*7/9";
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < given.length(); i++) {
            char ch = given.charAt(i);
            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                // Pop all operators from stack with greater or equal precedence
                while (!st.isEmpty() && prTable.getOrDefault(st.peek(), 0) >= prTable.get(ch)) {
                    sb.append(st.pop());
                }
                st.push(ch);
            }
        }
        // Pop remaining operators
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        System.out.println("Postfix: " + sb.toString());
    }
}