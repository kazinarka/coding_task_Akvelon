package ua.com.fedotov.app;

import java.util.*;

public class BalanceVerificator {

    public static int isCorrectBrackets(String src) {
        //Checking for emptiness
        if (src.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty.");
        }
        //HashMap with brackets
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        //Checking for non-bracket values
        for (char c : src.toCharArray()) {
            if (!brackets.containsValue(c) && !brackets.containsKey(c)) {
                throw new IllegalArgumentException("Input cannot consist non-bracket values.");
            }
        }
        //ArrayDeque for open brackets
        Deque<Character> openBrackets = new ArrayDeque<>();
        //ArrayList for indexes of open brackets
        List<Integer> indexes = new ArrayList<>();

        System.out.println("Input: " + src);

        //Looking throw all chars in a string
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            //If it is opening bracket, push and add it to collections
            if (brackets.containsValue(c)) {
                openBrackets.push(c);
                indexes.add(i + 1);
            } else { //If it is closing bracket
                //And we have not any to match
                if (openBrackets.isEmpty()) {
                    System.out.print("NOT BALANCED ");
                    return i + 1;
                } else if (openBrackets.peek() != brackets.get(c)) { //And it is not match with last open bracket
                    System.out.print("NOT BALANCED ");
                    return indexes.get(indexes.size() - 1);
                }
                //It matches, delete bracket and index
                openBrackets.pop();
                indexes.remove(indexes.size() - 1);
            }
        }
        //Checking for non-matched brackets
        if (!openBrackets.isEmpty()) {
            System.out.print("NOT BALANCED ");
            return src.length();
        }
        System.out.print("BALANCED ");
        return -1;
    }
}
