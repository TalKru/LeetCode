package questions.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
Given a string paragraph and a string array of the banned words banned,
return the most frequent word that is not banned.
It is guaranteed there is at least one word that is not banned,
and that the answer is unique.
The words in paragraph are case-insensitive
and the answer should be returned in lowercase.

Example 1:
Input: paragraph = "Bob hit a ball, the hit BALL
flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the
most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.

Example 2:
Input: paragraph = "a.", banned = []
Output: "a"

Constraints:
1 <= paragraph.length <= 1000
paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
0 <= banned.length <= 100
1 <= banned[i].length <= 10
banned[i] consists of only lowercase English letters.
 */
public class _819_Most_Common_Word {

    public static void main(String[] args) {

        String paragraph  = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned  = {"hit", "bob"};

        System.out.println("Input paragraph: " + paragraph);
        System.out.println("Input banned words: " + Arrays.toString(banned));
        System.out.println("Most Common Word: " + mostCommonWord(paragraph, banned));
    }

    // #1 attempt: too complex, I can do probably much better
    public static String mostCommonWord(String paragraph, String[] banned) {

        paragraph = paragraph.toLowerCase(); // O(n)

        // The \\W+ will match all non-alphabetic characters occurring
        // one or more times. So there is no need to replace.
        String[] words = paragraph.split("\\W+");

        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for (String bannedWord : banned){
            set.add(bannedWord);
        }

        int maxCounter = 0;
        String mstComnStr = "";

        for (int i = 0; i < words.length; i++) {

            if(set.contains(words[i])){
                continue;
            }
            int count = 1 + map.getOrDefault(words[i], 0);
            map.put(words[i], count);

            if(count > maxCounter){
                maxCounter = count;
                mstComnStr = words[i];
            }
        }
        return mstComnStr;
    }
}
