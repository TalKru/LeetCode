package strings;

import java.util.Arrays;

/*
Write a function that reverses a string. 
The input string is given as an array of characters s.
You must do this by modifying the input 
array in-place with O(1) extra memory.

Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

Constraints:
1 <= s.length <= 105
s[i] is a printable ascii character.
 */
public class _344_Reverse_String {

	public static void main(String[] args) {

		char[] charStr = {'h','e','l','l','o','!'};
		
		System.out.println(Arrays.toString(charStr));
		reverseString(charStr);
		System.out.println(Arrays.toString(charStr));
	}

	
	
	// O(n), in-place
	public static void reverseString(char[] s) {
		
		int pointer = 0; // points to the next index to swap characters
		
		for (int i = s.length-1; i >= (s.length/2); i--) {
			char temp = s[pointer];
			s[pointer++] = s[i];
			s[i] = temp;
		}
	}
}


























