package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:
'a' maps to ".-",
'b' maps to "-...",
'c' maps to "-.-.", and so on.
For convenience, the full table for the 26 letters of the English alphabet is given below:

[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.

For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.
Return the number of different transformations among all words we have.

Example 1:
Input: words = ["gin","zen","gig","msg"]
Output: 2
Explanation: The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."
There are 2 different transformations: "--...-." and "--...--.".

Example 2:
Input: words = ["a"]
Output: 1

Constraints:
1 <= words.length <= 100
1 <= words[i].length <= 12
words[i] consists of lowercase English letters.
 */
public class _804_Unique_Morse_Code_Words {

    public static void main(String[] args) {

        //String[] words = {"gin","zen","gig","msg"};
        String[] words = {"gin","zen","gig","msg"};
        System.out.println("input: " + Arrays.toString(words));
        int res = uniqueMorseRepresentations(words);
        System.out.println("Unique Morse Representations: " + res);
    }

    public static int uniqueMorseRepresentations(String[] words) {

        if(words.length <= 1){
            return words.length;
        }
        HashMap<Character, String> map = new HashMap<>()
        {{
            put('a', ".-");
            put('b', "-...");
            put('c', "-.-.");
            put('d', "-..");
            put('e', ".");
            put('f', "..-.");
            put('g', "--.");
            put('h', "....");
            put('i', "..");
            put('j', ".---");
            put('k', "-.-");
            put('l', ".-..");
            put('m', "--");
            put('n', "-.");
            put('o', "---");
            put('p', ".--.");
            put('q', "--.-");
            put('r', ".-.");
            put('s', "...");
            put('t', "-");
            put('u', "..-");
            put('v', "...-");
            put('w', ".--");
            put('x', "-..-");
            put('y', "-.--");
            put('z', "--..");
        }};
        HashSet<String> hs = new HashSet<>();

        for (int i = 0; i < words.length; i++) {

            String newSignal = "";

            for (int j = 0; j <words[i].length(); j++) {

                char c = words[i].charAt(j);
                newSignal += map.get(c);
            }
            hs.add(newSignal);
        }
        return hs.size();
    }



    // less space
    public static int uniqueMorseRepresentations2(String[] words) {

        String[] d = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> s = new HashSet<>();

        for (String w : words) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < w.length(); ++i){
                sb.append(d[w.charAt(i) - 'a']);
            }
            s.add(sb.toString());
        }
        return s.size();
    }
}
