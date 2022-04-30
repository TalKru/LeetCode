package strings;

import java.util.HashSet;

/*
You are given two strings s and t.
String t is generated by random shuffling string s 
and then add one more letter at a random position.
Return the letter that was added to t.

Example 1:
Input: s = "abcd", t = "abcde"
Output: "e"
Explanation: 'e' is the letter that was added.

Example 2:
Input: s = "", t = "y"
Output: "y"

Constraints:
0 <= s.length <= 1000
t.length == s.length + 1
s and t consist of lowercase English letters.
 */
public class _389_Find_the_Difference {

	public static void main(String[] args) {

//		String s = "abc";
//		String t = "cbxa";
		String s = "a";
		String t = "aa";
		
		char dif = findTheDifference(s, t);
		System.out.println(dif);
	}


	public static char findTheDifference(String s, String t) {

		if(s == "") return t.charAt(0);
		
		int[] repCount = new int[256];
		
		char c = t.charAt(t.length()-1);
		
		repCount[c]++;
		
		for (int i = 0; i < s.length(); i++) {
			
			char sChar = s.charAt(i);
			char tChar = t.charAt(i);
			
			repCount[tChar]++;
			repCount[sChar]--;
		}
		for (int i = 0; i < repCount.length; i++) {
			if(repCount[i] == 1) {
				return (char)i;
			}
		}
		return 'x';
	}
}









