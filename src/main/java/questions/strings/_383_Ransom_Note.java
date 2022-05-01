package questions.strings;
/*
Given two strings ransomNote and magazine,
return true if ransomNote can be constructed from magazine 
and false otherwise.
Each letter in magazine can only be used once in ransomNote.

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true

Constraints:
1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
 */
public class _383_Ransom_Note {

	public static void main(String[] args) {

		String ransomNote = "aa";
		String magazine = "aab";

		boolean res = canConstruct(ransomNote, magazine);

		System.out.println("ransomNote: " + ransomNote);
		System.out.println("magazine: " + magazine);
		System.out.println("can construct? " + res);
	}

	public static boolean canConstruct(String ransomNote, String magazine) {

		if(ransomNote.length() > magazine.length()) return false;

		int[] charCount = new int[256];

		for (int i = 0; i < magazine.length(); i++) { // add all available characters from magazine
			
			charCount[magazine.charAt(i)]++;
		}
		for (int i = 0; i < ransomNote.length(); i++) { // remove used characters for ransom note
			
			charCount[ransomNote.charAt(i)]--;

			if(charCount[ransomNote.charAt(i)] < 0) { // see if any character was used more than available amount
				return false;
			}
		}
		return true;
	}
}














