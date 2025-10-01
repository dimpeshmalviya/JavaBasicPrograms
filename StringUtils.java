// filename: StringUtils.java
// Compile: javac StringUtils.java
// Run: java StringUtils "racecar"


import java.util.*;

public class StringUtils {
    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("\\s+", "").toLowerCase();
        return cleaned.equals(reverse(cleaned));
    }

    public static Map<Character, Integer> charFrequency(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        return freq;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java StringUtils \"your string\"");
            return;
        }
        String input = args[0];
        System.out.println("Input: " + input);
        System.out.println("Reversed: " + reverse(input));
        System.out.println("Is palindrome: " + isPalindrome(input));
        System.out.println("Char frequencies: " + charFrequency(input));
    }
}
