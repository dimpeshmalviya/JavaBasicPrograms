/*
  Program: Longest Common Prefix in String Array
  Problem: Given an array of strings, find the longest common prefix among them.
  Input Example:
    Enter the number of strings: 3
    Enter string 1: "flower"
    Enter string 2: "flow"
    Enter string 3: "flight"
  Output Example:
    Longest Common Prefix: "fl"

  Time Complexity: O(N*M), where N = number of strings, M = length of shortest string
  Space Complexity: O(1) extra
*/

import java.util.Scanner;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            arr[i] = sc.nextLine();
        }
        String result = longestCommonPrefix(arr);
        System.out.println("Longest Common Prefix: \"" + result + "\"");
        sc.close();
    }
}
