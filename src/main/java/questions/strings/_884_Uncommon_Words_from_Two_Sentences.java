package questions.strings;

import java.util.*;

/*
A sentence is a string of single-space separated
words where each word consists only of lowercase letters.
A word is uncommon if it appears exactly once in one of the sentences,
and does not appear in the other sentence.
Given two sentences s1 and s2, return a list of all the uncommon words.
You may return the answer in any order.

Example 1:
Input: s1 = "this apple is sweet", s2 = "this apple is sour"
Output: ["sweet","sour"]

Example 2:
Input: s1 = "apple apple", s2 = "banana"
Output: ["banana"]

Constraints:
1 <= s1.length, s2.length <= 200
s1 and s2 consist of lowercase English letters and spaces.
s1 and s2 do not have leading or trailing spaces.
All the words in s1 and s2 are separated by a single space.
 */
public class _884_Uncommon_Words_from_Two_Sentences {

    public static void main(String[] args) {

        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        String s3 = "a b b b c";
        String s4 = "a y y x";
        String[] res = uncommonFromSentences(s1, s2, s3, s4);

        //System.out.println("String 1: " + s1);
        //System.out.println("String 2: " + s2);
        System.out.println(Arrays.toString(res));
    }

    // uniqueWords
    public static String[] uncommonFromSentences(String... phrases) {

        List<String> wordList = new LinkedList<>();

        for (String s : phrases){

            wordList.addAll(List.of(s.split("\\s+"))); // gather all words into single array
        }
        //String[] allWords = (s1 + " " + s2).split("\\s+"); // only 2 strings input
        return uniqueWords(wordList);
    }

    public static String[] uniqueWords(List<String> allWords) {

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < allWords.size(); i++) {

            map.put(allWords.get(i), map.getOrDefault(allWords.get(i), 0) + 1);
        }
        List<String> uncommonWords = new LinkedList<>();

        for (var word : map.entrySet()) {

            if (word.getValue() == 1) {
                uncommonWords.add(word.getKey());
            }
        }
        return uncommonWords.toArray(new String[0]);
    }

}
