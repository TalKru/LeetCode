package questions.strings;

/*
Given an input string s and a pattern p,
implement regular expression matching with support for
'.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:
Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

Constraints:
1 <= s.length <= 20
1 <= p.length <= 30
s contains only lowercase English letters.
p contains only lowercase English letters, '.', and '*'.
It is guaranteed for each appearance of the character '*',
there will be a previous valid character to match.
 */
        /*

        System.out.println(isMatch("babbaabbaaabbaabbbaaa", "*****aab"));
        System.out.println(isMatch("abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab", "*aabb***aa**a******aa*"));
        System.out.println(isMatch("abbaaaabbbbbababbbbbbbbaaabaabbabaabbaaabbbbabbbbab", "a*aaba***b**a*a********b"));
        System.out.println(isMatch("aaabababaaabaababbbaaaabbbbbbabbbbabbbabbaabbababab", "*ab***ba**b*b*aaab*b"));
        System.out.println(isMatch("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba", "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
        System.out.println(isMatch("abbaabbbbababaababababbabbbaaaabbbbaaabbbabaabbbbbabbbbabbabbaaabaaaabbbbbbaaabbabbbbababbbaaabbabbabb", "***b**a*a*b***b*a*b*bbb**baa*bba**b**bb***b*a*aab*a**"));
        System.out.println(isMatch("ababababbabbabababbbbabbaabaaaaaaababbbbbaabbaaabbbaa", "*****ba*"));
        System.out.println(isMatch("baaaabaaaabbbbaaabbba", "*a*******"));
        System.out.println(isMatch("abbbbaabaababaababab", "*********"));
        System.out.println(isMatch("aaabbaaabbaababbabbababbbaaaabaababbaabbbbaabbbbbbbab", "****a***"));
        System.out.println(isMatch("bbbbabbbbbbbababaaaabaababaaaabababbbbbaaabbaaaaaabaa", "bb*a***"));
        System.out.println(isMatch("bbaababaaaaabaabbabaaababababbbabbaabaaaaaabbaaaabab", "bb***a*a*"));
        */

public class _44_Wildcard_Matching {

    public static void main(String[] args) {

        String s = "abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab";
        String p = "*aabb***aa**a******aa*";

        System.out.println("String: " + s);
        System.out.println("Pattern: " + p);
        System.out.println(isMatch(s, p));
    }

    // Recursive
    public static boolean isMatch(String s, String p) {

        if (p.isEmpty() && s.isEmpty()) {
            return true;
        }
        if (p.isEmpty() && !s.isEmpty()) {
            return false;
        }
        if (p.charAt(0) != '*' && s.isEmpty()) {
            return false;
        }
        else if (p.charAt(0) >= 97 && p.charAt(0) <= 122) {

            if (p.charAt(0) == s.charAt(0)) {
                return isMatch(s.substring(1), p.substring(1));
            }
        }
        if (p.charAt(0) == '?') {
            return isMatch(s.substring(1), p.substring(1));
        }
        else if (p.charAt(0) == '*') {
            boolean removeChar = !s.isEmpty() && isMatch(s.substring(1), p);
            boolean removeAsterisk = isMatch(s, p.substring(1));

            return removeAsterisk || removeChar;
        }
        return false;
    }


    // Iterative
    public static boolean isMatch2(String str, String pattern) {

        int s = 0;
        int p = 0;
        int match = 0;
        int starIndex = -1;

        while (s < str.length()) {

            if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
                s++;
                p++;
            }
            else if (p < pattern.length() && pattern.charAt(p) == '*') {  // found *, move forward pattern pointer
                starIndex = p;
                match = s;
                p++;
            }
            else if (starIndex != -1) { // last pattern pointer was *, advancing string pointer
                p = starIndex + 1;
                match++;
                s = match;
            }
            else { //current pattern pointer is not *, last patter pointer was not *
                return false; //characters do not match
            }
        }
        while (p < pattern.length() && pattern.charAt(p) == '*') { // check the remaining chars in pattern
            p++;
        }
        return (p == pattern.length()) ? true : false;
    }

}
