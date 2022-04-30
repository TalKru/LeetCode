package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection 
between a letter in pattern and a non-empty word in s.

Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true

Example 2:
Input: pattern = "abba", s = "dog cat cat fish"
Output: false

Example 3:
Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false

Constraints:
1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
 */
public class _29_Word_Pattern {

	public static void main(String[] args) {
		
//		String pattern = "abba";
//		String s       = "dog cat cat dog";
		
		String pattern = "aaba";
		String s       = "dog fox cat dog";
		
		boolean res = wordPattern(pattern, s);
		System.out.println(res);
	}


	public static boolean wordPattern(String pattern, String s) {
		
		String[] words = s.split(" ");
		
		if(pattern.length() != words.length) { return false; }
		
		HashMap<String, Character> map = new HashMap<>();
		HashSet<Character> set = new HashSet<>();
		
		for (int i = 0; i < words.length; i++) {
			//==================================================//
			if(map.containsKey(words[i])) {
				
				if(map.get(words[i]) != pattern.charAt(i)) {
					return false;
				}
			}
			//==================================================//
			else { // new word found
				// if the char for this word exists
				// it's breaking the pattern
				if(set.contains(pattern.charAt(i))) {
					return false;
				}
				else {
					map.put(words[i], pattern.charAt(i));
					set.add(pattern.charAt(i));
				}
			}
			//==================================================//
		}
		return true;
	}
}




















