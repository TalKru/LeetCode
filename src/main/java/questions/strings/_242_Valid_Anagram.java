package questions.strings;

import java.util.Arrays;
import java.util.HashMap;

/*
Given two strings s and t, return true if t is an anagram of s,
and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters 
of a different word or phrase, 
typically using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
1 <= s.length, t.length <= 5 * 10^4
s and t consist of lowercase English letters.
 */
public class _242_Valid_Anagram {

	public static void main(String[] args) {
		
		String s1 = "anagram";
		String s2 = "nagaram";
		boolean res = isAnagram(s1, s2);
		
		System.out.println("string 1: " + s1);
		System.out.println("string 2: " + s2);
		System.out.println("Is string 1 is an anagram of string 2: " + res);
	}


	public static boolean isAnagram(String s, String t) {

		if(s.length() != t.length()) {
			return false;
		}
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) { // build mapping of the (Characters , count)

			char c = s.charAt(i);

			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (int i = 0; i < t.length(); i++) {

			char c = t.charAt(i);
			Integer count = map.get(c);

			if (count == null || count == 0) {
				return false;
			}
			map.put(c, count - 1);
		}
		return true;
	}

	//  3 * O(n) + 2 * O(nlog(n)) = O(nlog(n))
	public static boolean isAnagram2(String s, String t) {
		
		if(s.length() != t.length()) {
			return false;
		}
		char[] charArr1 = s.toCharArray();
		char[] charArr2 = t.toCharArray();
		
		Arrays.sort(charArr1);
		Arrays.sort(charArr2);
		
		return Arrays.equals(charArr1, charArr2);
	}

}























