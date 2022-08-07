package questions.strings;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given an array of string words.
Return all strings in words which is substring of another word in any order.

String words[i] is substring of words[j],
if can be obtained removing some characters
to left and/or right side of words[j].

Example 1:
Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.
Example 2:
Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".
Example 3:
Input: words = ["blue","green","bu"]
Output: []

Constraints:
1 <= words.length <= 100
1 <= words[i].length <= 30
words[i] contains only lowercase English letters.
It's guaranteed that words[i] will be unique.
 */
public class _1408_String_Matching_in_an_Array {

    public static void main(String[] args) {

        String[] words = {"mass","as","hero","superhero"};
        List<String> res = stringMatching(words);

        System.out.println("Input: " + Arrays.toString(words));
        System.out.println("Result: " + res);
    }



    public static List<String> stringMatching(String[] words) {

        List<String> subMatchingList = new LinkedList<>();

        for (int i = 0; i < words.length; i++) {     // choose word i
            for (int j = 0; j < words.length; j++) { // check if sub-str of j

                if ( words[i].length() >= words[j].length() || i == j) {
                    continue;
                }
                if (words[j].contains(words[i])) {
                    subMatchingList.add(words[i]);
                    break;
                }
            }
        }
        return  subMatchingList;
    }
}

