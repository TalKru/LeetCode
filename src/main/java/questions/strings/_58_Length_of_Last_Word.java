package questions.strings;

/*
  Given a string s consisting of some words separated by some number of spaces, 
  return the length of the last word in the string.
  A word is a maximal substring consisting of non-space characters only.
  
  Input: s = "   fly me   to   the moon  "
  Output: 4
  Explanation: The last word is "moon" with length 4.
  
  1 <= s.length <= 104
  s consists of only English letters and spaces ' '.
  There will be at least one word in s.
 */

public class _58_Length_of_Last_Word {

	public static void main(String[] args) {

		String str = "   fly me   to   the moon  ";
		
		System.out.println(str);
		System.out.println(lengthOfLastWord(str));
	} 

	
	
	public static int lengthOfLastWord(String s) {
		
		int lastWordEndIndex = -1;
		int len = 0;
		
		for(int i = s.length()-1; i >= 0; i--) {
			if(s.charAt(i) != ' ') {
				lastWordEndIndex = i;
				break;
			}
		}
		for(int i = lastWordEndIndex; i >= 0; i--) {
			if(s.charAt(i) == ' ') { break; }
			len++;
		}
		return len;
	}

} // class













