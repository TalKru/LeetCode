package questions.strings;

import java.util.HashSet;

/*
 Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

0 <= s.length <= 5 * 104

s consists of English letters, digits, symbols and spaces.

 */
public class _3_Longest_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {

		//String s = "abcabcbb"; // ans=3  "abc"
		//String s = "dvdf";
		//String s = "abcdec";
		//String s = "abcdecxyz";
		String s = "111111111119876543210100000000";
		System.out.println("Input String: [" + s + "]");


		long startTime = System.currentTimeMillis();

		//int res = lengthOfLongestSubstring(s); // return only length function
		String res = lengthOfLongestSubstring(s); 

		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("Runtime: " + estimatedTime + "(ms)");

		System.out.println("Longest Substring Without Repeating Characters length: " + res);
	} 


	public static String lengthOfLongestSubstring(String s) {

		if(s.length() == 0 || s.length() == 1) { return s; }

		HashSet<Character> hashSet = new HashSet<>();
		int a = 0; // start
		int b = 0; // end
		int bestLen = 0;

		int startIndex = 0;

		while(b < s.length()) {

			char ch = s.charAt(b); // pull current inspected char for easy use

			if(hashSet.contains(ch)) { // check is char alreadu exists

				char removeChar = s.charAt(a); // pull the char which needs to be removed

				hashSet.remove(removeChar);    // remove first char  [a][][][]...[b]...[]
				a++;                           // move end point one step right ->
			}
			else { // if no - add to set
				b++; // note: for next itteration only, as current b alrady used to extract the char earlier
				hashSet.add(ch);

				int prevBestLen = bestLen;
				bestLen = Math.max(bestLen, hashSet.size());

				if(bestLen > prevBestLen) { // if a longer sub string was found, 
					startIndex = a;         // save the start index
				}
			}
		}
		return s.substring(startIndex, startIndex + bestLen);
	}

	/* fastest - return only the length */

	//	public static int lengthOfLongestSubstring(String s) {
	//
	//		boolean[] map = new boolean[256];
	//		int a = 0;
	//		int b = 0;
	//		int result = 0;
	//
	//		while (b < s.length()) {
	//
	//			char ch = s.charAt(b);
	//
	//			if (map[ch] == true) {
	//				while (s.charAt(a) != ch) {
	//					map[s.charAt(a)] = false;
	//					a++;
	//				}
	//				map[s.charAt(a)] = false;
	//				a++;
	//			}
	//
	//			// calculate window size
	//			map[ch]= true;
	//			result = Math.max(result, b - a + 1);
	//			b++;
	//		}
	//		return result;
	//	}


	/* return only the length */

	//	public static int lengthOfLongestSubstring(String s) {
	//
	//		if(s.length() == 0 || s.length() == 1) { return s.length(); }
	//
	//		HashSet<Character> hashSet = new HashSet<>();
	//		int a = 0; // start
	//		int b = 0; // end
	//		int bestLen = 0;
	//
	//		while(b < s.length()) {
	//
	//			char ch = s.charAt(b); // pull current inspected char for easy use
	//
	//			if(hashSet.contains(ch)) { // check is char alreadu exists
	//
	//				char removeChar = s.charAt(a); // pull the char which needs to be removed
	//
	//				hashSet.remove(removeChar);    // remove first char  [a][][][]...[b]...[]
	//				a++;                           // move end point one step right ->
	//			}
	//			else { // if no - add to set
	//				hashSet.add(ch);
	//				b++; // note: for next itteration only, as current b alrady used to extract the char earlier
	//
	//				bestLen = Math.max(bestLen, hashSet.size());
	//			}
	//		}
	//		return bestLen;
	//	}

	
	/*less efficient solution but still better than brute force */

	//	public static int lengthOfLongestSubstring(String s) {
	//		
	//		if(s.length() == 0 || s.length() == 1) { return s.length(); }
	//		
	//		int currLen = 0;
	//		int bestLen = 0;
	//		
	//		HashMap<Character, Integer> charIndexMap = new HashMap<>(); // (char of current word, index)
	//		
	//		for (int i = 0; i < s.length(); i++) {
	//			
	//			char ch = s.charAt(i); // current char
	//			
	//			if(charIndexMap.containsKey(ch)) { // if char repeats
	//				
	//				currLen = 0;
	//				
	//				i = charIndexMap.get(ch) + 1; // start over from duplicated char index +1
	//				
	//				ch = s.charAt(i); // fuck this line!!! took me a hour to understand I fogot it
	//				
	//				charIndexMap.clear(); // reset map
	//			}
	//			
	//			charIndexMap.put(ch, i);
	//
	//			currLen++;
	//			
	//			if(currLen > bestLen) {
	//				bestLen = currLen;
	//			}
	//		}
	//		return bestLen;
	//	}

} // class
























