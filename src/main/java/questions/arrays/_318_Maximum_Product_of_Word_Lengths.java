package questions.arrays;

import java.util.*;

/*
Given a string array words,
return the maximum value of length(word[i]) * length(word[j])
where the two words do not share common letters.
If no such two words exist, return 0.

Example 1:
Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".

Example 2:
Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".

Example 3:
Input: words = ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.

Constraints:
2 <= words.length <= 1000
1 <= words[i].length <= 1000
words[i] consists only of lowercase English letters.
 */
public class _318_Maximum_Product_of_Word_Lengths {

    public static void main(String[] args) {

        //String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"}; // Expected 16
        //String[] words = {"a","ab","abc","d","cd","bcd","abcd"}; // Expected 4
        //String[] words = {"a","aa","aaa","aaaa"}; // Expected 0
        String[] words = {"eae", "ea", "aaf", "bda", "fcf", "dc", "ac", "ce", "cefde", "dabae"}; // Expected 15

        System.out.println("Input: " + Arrays.toString(words));
        System.out.println("Maximum Product of Word Lengths: " + maxProduct(words));
    }

    // =============================================================================//
    // Using HashSet
    public static int maxProduct(String[] words) {

        List<Set<Character>> list = new ArrayList(words.length);
        int max = 0;

        for (String word : words) {

            Set<Character> set = new HashSet();
            list.add(set);

            for (int i = 0; i < word.length(); i++) {
                set.add(word.charAt(i));
            }
        }
        for (int i = 0; i < words.length; i++) {

            Set<Character> setI = list.get(i);

            for (int j = i + 1; j < words.length; j++) {

                boolean hasCommon = false;
                Set<Character> setJ = list.get(j);

                for (Character c : setI) {
                    if (setJ.contains(c)) {
                        hasCommon = true;
                        break;
                    }
                }
                if (!hasCommon)
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }
    // =============================================================================//

    // Brute force
    public static int maxProduct2(String[] words) {

        int max = 0; //Arrays.sort(words, (s1, s2) -> Integer.compare(s2.length(), s1.length())); // sort by length DESC

        for (int i = 0; i < words.length; i++) { // choose word and check overlap for all prev words, i = 1
            for (int k = (i + 1); k < words.length; k++) {

                if (!isOverlap(words[i], words[k])) {  // if there is NO overlap

                    max = Math.max(max, words[i].length() * words[k].length());  //return (words[i].length() * words[k].length());
                }
            }
        }
        return max;  //return 0;
    }

    private static boolean isOverlap(String s1, String s2) {

        if (s1.isEmpty() || s2.isEmpty()) {
            return false;
        }
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {

            if (set.contains(s2.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    // =============================================================================//

    // Bit Manipulation
    public static int maxProduct3(String[] words) {

        int max = 0;
        int[] bitmask = new int[words.length];

        for (int i = 0; i < words.length; i++) {

            for (int j = 0; j < words[i].length(); j++) {  // Calc bitmask

                int index = words[i].charAt(j) - 'a'; // index will be - for a -> 0, b -> 1, c -> 2 and so on

                bitmask[i] |= (1 << index);  // left shift 1 by index and OR it with the current bitmask
            }
            for (int j = 0; j < i; j++) {   // Compare bitmask of current string with previous strings bitmask
                /* If there is a 1 at the same index of current string {i} and {j},
                then bitmask of i and j string will result in a number greater than 0,
                else it will result in 0 */
                if ((bitmask[i] & bitmask[j]) == 0)
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }
    // =============================================================================//
}
