package questions.strings;

import java.util.Stack;

/*
Given two strings s and t,
return true if they are equal when both are typed into empty text editors.
'#' means a backspace character.
Note that after backspacing an empty text, the text will continue empty.

Example 1:
Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".

Example 2:
Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".

Example 3:
Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".

Constraints:
1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.

Follow up: Can you solve it in O(n) time and O(1) space?
 */
public class _844_Backspace_String_Compare {

    public static void main(String[] args) {

        String s1 = "bxj##tw";
        String s2 = "bxo#j##tw";
        System.out.println(backspaceCompare(s1, s2));
        System.out.println(backspaceCompare2(s1, s2));
    }

    public static boolean backspaceCompare(String s1, String s2) {

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        cleanStrIntoStack(s1, stack1);
        cleanStrIntoStack(s2, stack2);

        if (stack1.size() != stack2.size()) {
            return false;
        }
        while (!stack1.isEmpty()) {

            if (stack1.pop() != stack2.pop()) {
                return false;
            }
        }
        return true;
    }

    private static void cleanStrIntoStack(String s, Stack<Character> stack) {

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(ch);
            }
        }
    }

    // O(n+m) Runtime
    // O(1) space
    public static boolean backspaceCompare2(String s1, String s2) {

        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int countS1 = 0;
        int countS2 = 0;

        while (i >= 0 || j >= 0) {

            while (i >= 0 && (countS1 > 0 || s1.charAt(i) == '#')) {

                if (s1.charAt(i) == '#') {
                    countS1++;
                }
                else {
                    countS1--;
                }
                i--;
            }
            char c1 = (i < 0) ? '@' : s1.charAt(i);

            while (j >= 0 && (countS2 > 0 || s2.charAt(j) == '#')) {

                if (s2.charAt(j) == '#') {
                    countS2++;
                }
                else {
                    countS2--;
                }
                j--;
            }
            char c2 = (j < 0) ? '@' : s2.charAt(j);

            if (c1 != c2) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
