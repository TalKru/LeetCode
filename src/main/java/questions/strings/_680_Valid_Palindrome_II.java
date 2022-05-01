package questions.strings;

/*
Given a string s, return true if the s can be palindrome
after deleting at most one character from it.

Example 1:
Input: s = "aba"
Output: true

Example 2:
Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Example 3:
Input: s = "abc"
Output: false

Constraints:
1 <= s.length <= 10^5
s consists of lowercase English letters.
 */
public class _680_Valid_Palindrome_II {

    public static void main(String[] args) {

        String s = "aaabTxObaaa";
        System.out.println("Input: " + s);
        System.out.println("Is valid palindrome with at most 1 char removal? " + validPalindrome(s));

        String s2 = "bTXb";
        System.out.println("Input: " + s2);
        System.out.println("Is valid palindrome with at most 1 char removal? " + validPalindrome(s2));
    }

    public static boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {

            if (s.charAt(start) != s.charAt(end)) {
                //indexPalindrome(s, start + 1, end);
                //indexPalindrome(s, start, end - 1);
                return indexPalindrome(s, start + 1, end) || indexPalindrome(s, start, end - 1);
            }
            start++;
            end--;
        }
        return true;
    }

    private static boolean indexPalindrome(String s, int start, int end) {
        while (start <= end) {

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
