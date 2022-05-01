package questions.strings;

import java.util.Arrays;

/*
Given two questions.strings s and t, return true if t is an anagram of s,
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
		
		System.out.println("s1: " + s1);
		System.out.println("s2: " + s2);
		System.out.println("Is s1 is an anagram od s2: " + res);
	}


	// 2*O(nlog(n)) + 3 * O(n) = O(nlog(n))
	public static boolean isAnagram(String s, String t) {
		
		if(s.length() != t.length()) return false;
		
		char[] charArr1 = s.toCharArray();
		char[] charArr2 = t.toCharArray();
		
		Arrays.sort(charArr1);
		Arrays.sort(charArr2);
		
		return Arrays.equals(charArr1, charArr2);
	}
}























