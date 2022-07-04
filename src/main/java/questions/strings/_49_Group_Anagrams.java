package questions.strings;

import java.util.*;

/*
Given an array of strings strs, group the anagrams together.
You can return the answer in any order.
An Anagram is a word or phrase formed
by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

Constraints:
1 <= strs.length <= 10^4
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 */
public class _49_Group_Anagrams {

    public static void main(String[] args) {

        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> anagramsLists = groupAnagrams(strs);

        System.out.println("Input:  " + Arrays.toString(strs));
        System.out.println("Result: " + anagramsLists);
    }


    /*
    Each string will be sorted Lexicographically when this sorted string will be a
    hashmap representation of the list of the anagrams.
     */
    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>(); // (key: sorted str, val: list of anagrams)

        for (String s : strs) {

            char[] tempArray = s.toCharArray();
            Arrays.sort(tempArray);
            String sortedStr = new String(tempArray);

            if (map.containsKey(sortedStr)) { // if sorted key exists, add to the list of anagrams within the value
                map.get(sortedStr).add(s);
            }
            else {
                List<String> tempList = new LinkedList<>(); // create new list in the map
                tempList.add(s);
                map.put(sortedStr, tempList);
            }
        }

        return new ArrayList<>(map.values());
        /*
        List<List<String>> anagramsLists = new LinkedList<>(); // the long syntax
        for (Map.Entry<String, List<String>> entry : map.entrySet()) { // collect all the list from the hashmap
            anagramsLists.add(entry.getValue());
        }
        return anagramsLists;
         */
    }

}
