package questions.strings;

import java.util.*;

/*
Given a string array words,
return an array of all characters that show up in all strings
within the words (including duplicates).
You may return the answer in any order.

Example 1:
Input: words = ["bella","label","roller"]
Output: ["e","l","l"]

Example 2:
Input: words = ["cool","lock","cook"]
Output: ["c","o"]

Constraints:
1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.
 */
public class _1002_Find_Common_Characters {

    public static void main(String[] args) {

        String[] words = {"bella","label","roller"};
        List<String> commonCharacters = commonChars(words);

        System.out.println(commonCharacters);
    }

    public static List<String> commonChars(String[] words) {

        if (words.length == 1) {
            //return List.of(words[0]);
            return Arrays.asList(words[0]);
        }
        String tempWord = listToSrting(commonChars(words[0], words[1]));

        for (int i = 2; i < words.length; i++) { // [i = 2], 0,1 handled outside

            tempWord = listToSrting(commonChars(words[i], tempWord));
        }
        List<String> list = new ArrayList<>();

        for (int i = 0; i < tempWord.length(); i++) {
            list.add(String.valueOf(tempWord.charAt(i)));
        }
        return list;
    }

    public static List<Character> commonChars(String s1, String s2) { // overloading

        List<Character> chars = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {

            char c = s1.charAt(i);

            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {

            char c = s2.charAt(i);

            if (map.containsKey(c) && map.get(c) > 0) {

                chars.add(c);

                map.put(c, map.get(c) - 1);
            }
        }
        return chars;
    }

    private static String listToSrting(List<Character> charList) {

        String str = "";

        for (Character c : charList) {

            str += c;
        }
        return str;
    }

}
