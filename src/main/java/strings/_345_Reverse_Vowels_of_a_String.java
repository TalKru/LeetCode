package strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Given a string s, reverse only all the vowels 
in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', 
and they can appear in both cases.

Example 1:
Input: s = "hello"
Output: "holle"

Example 2:
Input: s = "leetcode"
Output: "leotcede"

Constraints:
1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
 */
public class _345_Reverse_Vowels_of_a_String {

	public static void main(String[] args) {

		String s = "hello";
		System.out.println(s);
		String reverseVowel = reverseVowels(s);
		System.out.println(reverseVowel);

	}


	public static String reverseVowels(String s) {

		char[] list=s.toCharArray();
		Set<Character> set = new HashSet<>();
		set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u');
		set.add('A'); set.add('E'); set.add('I'); set.add('O'); set.add('U');

		int i = 0;
		int j = list.length-1;
		while(i<j) {

			if (!set.contains(list[i])) {
				i++;
				continue;
			}
			if (!set.contains(list[j])) {
				j--;
				continue;
			}
			char temp=list[i];
			list[i]=list[j];
			list[j]=temp;
			i++;
			j--;
		}
		return String.valueOf(list);
	}



	// first try, over complicated and slow
	//	public static String reverseVowels(String s) {
	//		
	//		Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
	//		
	//		String tokens = "";
	//		
	//		for (int i = s.length()-1; i >= 0 ; i--) { // create revere order str of pure vowels
	//			if(set.contains(s.charAt(i))) {
	//				tokens += s.charAt(i);
	//			}
	//		}
	//		String resultStr = "";
	//		int progIndex = 0;
	//		
	//		for (int i = 0; i < s.length(); i++) { // reverse pass on original str
	//			
	//			//if(isToken(s.charAt(i))) {
	//			if(set.contains(s.charAt(i))) {
	//				resultStr += tokens.charAt(progIndex++);
	//			}
	//			else {
	//				resultStr += s.charAt(i);
	//			}
	//		}
	//		return resultStr;
	//	}

} // class











