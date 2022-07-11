package questions.strings;

import java.util.Arrays;

/*
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters.
The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words.
The returned string should only have a single space separating the words.
Do not include any extra spaces.

Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"

Example 2:
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

Constraints:
1 <= s.length <= 10^4
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
 */
public class _151_Reverse_Words_in_a_String {

    public static void main(String[] args) {

        //String s = "the sky is blue";
        String s = "    hello    world    ";
        String reverse = reverseWords(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + reverse);
    }

    /*
    https://www.techiedelight.com/split-string-on-any-whitespace-character-java/
     */
    public static String reverseWords(String s) {

        String[] words = s.trim().split("\\s+");

        String rvrsStr = "";

        for (int i = words.length - 1; i >= 0 ; i--) {

            rvrsStr += words[i];

            if (i > 0) {
                rvrsStr += " ";
            }
        }
        return rvrsStr;
    }
}
