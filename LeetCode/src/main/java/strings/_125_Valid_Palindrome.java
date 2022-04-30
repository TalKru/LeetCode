package strings;
/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters 
and removing all non-alphanumeric characters, 
it reads the same forward and backward. 
Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.


Constraints:
1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */
public class _125_Valid_Palindrome {

	public static void main(String[] args) {

		String s = "A man, a plan, a canal: Panama";
		//String s = "race a car";
		//String s = " ";
		//String s = "  A  ";
		//String s = "0P";
		System.out.println(s);

		boolean res = isPalindrome(s);

		System.out.println("Result: " + res);
	}





	public static boolean isPalindrome(String s) {

		if(s.length() <= 1 ) { return true; }

		String cleanStr = "";

		// remove spaces and everything else
		for (int i = 0; i < s.length(); i++) {

			if(s.charAt(i) >= 97 && s.charAt(i) <= 122   ||   s.charAt(i) >= 48 && s.charAt(i) <= 57) {

				cleanStr += s.charAt(i);                        // copy lower case char OR number
			}
			if(s.charAt(i) >= 65 && s.charAt(i) <= 90) {

				cleanStr += (char)(s.charAt(i) + 32);           // copy upper case char, do lower case
			}
		}

		System.out.println(cleanStr);

		int start = 0;
		int end = cleanStr.length()-1;

		while(start < end) {

			char ch1 = cleanStr.charAt(start);
			char ch2 = cleanStr.charAt(end);

			if(ch1 != ch2) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

}



//class Solution {
//	public boolean isPalindrome(String s) {
//		int i = 0, j = s.length()-1;
//		while(i<=j){
//			while(i<=j && !Character.isLetterOrDigit(s.charAt(i))) i++;
//			while(i<=j && !Character.isLetterOrDigit(s.charAt(j))) j--;
//			if(i<=j && Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--)))
//				return false;
//		}
//		return true;
//	}
//}





