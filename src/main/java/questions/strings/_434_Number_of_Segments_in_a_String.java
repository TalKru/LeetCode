package questions.strings;
/*
Given a string s, return the number of segments in the string.
A segment is defined to be a contiguous sequence of non-space characters.

Example 1:
Input: s = "Hello, my name is John"
Output: 5
Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]

Example 2:
Input: s = "Hello"
Output: 1

Constraints:
0 <= s.length <= 300
s consists of lowercase and uppercase English letters, digits, or one of the following characters "!@#$%^&*()_+-=',.:".
The only space character in s is ' '.
 */
public class _434_Number_of_Segments_in_a_String {

	public static void main(String[] args) {

		String s = "   Hello,     my    name is John  ";
		System.out.println(countSegments(s));
	}

	public static int countSegments(String s) {
		
		int wordCount = 0;
		boolean sameWord = false;
		
		for (int i = 0; i < s.length(); i++) {
			
			char ch = s.charAt(i);
			
			if(ch != ' ') {
				if(!sameWord) {
					wordCount++;
					sameWord = true;
				}
			}
			else { // if word ended or we encounter spaces
				sameWord = false;
			}
		}
		return wordCount;
	}
}
