package questions.strings;

import java.util.LinkedList;
import java.util.List;

/*
You are given a string s consisting of lowercase English letters.
A duplicate removal consists of choosing
two adjacent and equal letters and removing them.
We repeatedly make duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made.
It can be proven that the answer is unique.

Example 1:
Input: s = "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
Example 2:
Input: s = "azxxzy"
Output: "ay"

Constraints:
1 <= s.length <= 10^5
s consists of lowercase English letters.
 */
public class _1047_Remove_All_Adjacent_Duplicates_In_String {

    public static void main(String[] args) {

        String input = "abbbbbaaaacazcbaabcz";
        System.out.println("Input String: " + input);

        String result = removeDuplicates(input);
        System.out.println("Remove_All_Adjacent_Duplicates_In_String: " + result);
    }


    public static String removeDuplicates(String s) {

        if (s.length() < 2) {
            return s;
        }
        //Stack<Character> stack = new Stack<>();
        List<Character> stack = new LinkedList<>();

        //stack.push(s.charAt(0));
        stack.add(0, s.charAt(0)); // push

        for (int i = 1; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (!stack.isEmpty() && stack.get(stack.size() - 1) == ch) {
                //stack.pop();
                stack.remove(stack.size() - 1);
            }
            else {
                //stack.push(ch);
                stack.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();

        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

}

