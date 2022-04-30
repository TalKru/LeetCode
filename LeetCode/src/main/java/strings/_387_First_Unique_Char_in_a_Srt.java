package strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
Given a string s, find the first non-repeating character 
in it and return its index. If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1

Constraints:
1 <= s.length <= 105
s consists of only lowercase English letters.
 */
public class _387_First_Unique_Char_in_a_Srt {

	public static void main(String[] args) {

		//String  s = "leetcode";
		String  s = "hellohellohellohellohelloWorld";
		//String  s = "a1cggga5bkk5cb1gkkk1111";

		System.out.println("Input String: " + s);

		int res = firstUniqChar(s);

		if(res == -1) {
			System.out.println("String has no unique chars.");
		}
		else {
			System.out.println("Index of the first Unique Char: " + res);
		}
	} // main

	// Time complexity: O(2n) = O(n)
	public static int firstUniqChar(String s) {

		int[] countCharArr = new int[256];

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);
			countCharArr[c]++; 
		}
		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);

			if(countCharArr[c] == 1) {
				return i;
			}
		}
		return -1;
	}

	// Time complexity: O(n)
	//	public static int firstUniqChar(String s) {
	//		
	//		int[] countCharArr = new int[256];
	//		
	//		Queue<CharCell> charList = new LinkedList<>();
	//
	//		for (int i = 0; i < s.length(); i++) {
	//			
	//			char c = s.charAt(i);
	//			countCharArr[c]++;
	//			
	//			CharCell strCell = new CharCell(i, c);
	//			
	//			charList.add(strCell);
	//		}
	//		while(!charList.isEmpty()) {
	//			
	//			CharCell strCell = charList.poll();
	//			
	//			char c = strCell.getChar();
	//			
	//			if(countCharArr[c] == 1) {
	//				return strCell.getIndex();
	//			}
	//		}
	//		return -1;
	//	}


	// no special object solution 
	//	public static int firstUniqChar(String s) {
	//		
	//		int[] countCharArr = new int[256];
	//		Queue<Character> charList = new LinkedList<>();
	//		HashMap<Character, Integer> map = new HashMap<>();
	//
	//		for (int i = 0; i < s.length(); i++) {
	//			
	//			char c = s.charAt(i);
	//			
	//			countCharArr[c]++;
	//			
	//			charList.add(c);
	//			map.put(c, i);
	//		}
	//		while(!charList.isEmpty()) {
	//			
	//			char c = charList.poll();
	//			
	//			if(countCharArr[c] == 1) {
	//				return map.get(c);
	//			}
	//		}
	//		return -1;
	//	}
}



















