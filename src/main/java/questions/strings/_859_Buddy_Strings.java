package questions.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
Given two strings s and goal, return true if you can swap two letters in s so the
result is equal to goal, otherwise, return false.
Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j
and swapping the characters at s[i] and s[j].
For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

Example 1:
Input: s = "ab", goal = "ba"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.

Example 2:
Input: s = "ab", goal = "ab"
Output: false
Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
Example 3:

Input: s = "aa", goal = "aa"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.

Constraints:
1 <= s.length, goal.length <= 2 * 10^4
s and goal consist of lowercase letters.
 */
public class _859_Buddy_Strings {

    public static void main(String[] args) {

        String s = "abcde";
        String goal = "adcbe";

        System.out.println("String 1: " + s);
        System.out.println("String 2: " + goal);
        System.out.println(buddyStrings(s, goal));
    }

    public static boolean buddyStrings(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {

            HashSet<Character> set = new HashSet<Character>();

            for (char c : s1.toCharArray()) {
                set.add(c);
            }
            return (set.size() < s1.length()) ? true : false;
        }
        List<Integer> dif = new ArrayList<>();

        for (int i = 0; i < s1.length(); ++i) {

            if (s1.charAt(i) != s2.charAt(i)) {
                dif.add(i);
            }
        }
        if (dif.size() != 2) {
            return false;
        }
        if (s1.charAt(dif.get(0)) != s2.charAt(dif.get(1))) {
            return false;
        }
        if (s1.charAt(dif.get(1)) != s2.charAt(dif.get(0))) {
            return false;
        }
        return true;
    }
}
