package strings;
/*
We define the usage of capitals in a word 
to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

Example 1:
Input: word = "USA"
Output: true

Example 2:
Input: word = "FlaG"
Output: false
 
Constraints:
1 <= word.length <= 100
word consists of lowercase and uppercase English letters.
 */
public class _520_Detect_Capital {

	public static void main(String[] args) {

		String srt =  "mL";
		
		System.out.println(detectCapitalUse(srt));
	}
	
	
	
	// O(n) - fast
	public static boolean detectCapitalUse(String word) {
		
		boolean AllCap = true;
		boolean Alllow = true;
		boolean onlyfirstCap = (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z');
		boolean middleCap = false;
		
		for (int i = 1; i < word.length(); i++) {
			
			if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
				AllCap = false;
			}
			else if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
				Alllow = false;
				middleCap = true;
			}
		}
		if((AllCap && onlyfirstCap) || Alllow) {
			return true;
		}
		return !middleCap && onlyfirstCap;
	}
	
	
	
	//Regex - slow
	public static boolean detectCapitalUse2(String word) {
	    return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
	}
	public static boolean detectCapitalUse3(String word) {
	    return word.matches("[A-Z]*|.[a-z]*");
	}
	
	
}










