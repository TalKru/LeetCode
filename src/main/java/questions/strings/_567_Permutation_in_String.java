package questions.strings;

/*
Given two questions.strings s1 and s2,
return true if s2 contains a permutation of s1, 
or false otherwise.
In questions.other words,
return true if one of s1's permutations is the substring of s2.

Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true

Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false

Constraints:
1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
 */
public class _567_Permutation_in_String {

	public static void main(String[] args) {

		//		String s1 = "ax";
		//		String s2 = "eidbaooo";
		String s1 = "fgf";
		String s2 = "ggff31b2cax";

		System.out.println("String 1:" + s1);
		System.out.println("String 2:" + s2);
		System.out.println("is sub String? " + checkInclusion(s1, s2));
	}
	//-----------------------------------------------------------------------//
	public static boolean checkInclusion(String s1, String s2) {

		if(s2.length() < s1.length()) {
			return false;
		}
		
		int[] charCountArr1 = charCountArr(s1);
		
		
		int interval = s1.length();

		for (int i = 0; i < s2.length() - interval + 1; i++) {
			
			int[] charCountArr2 = charCountArr(s2.substring(i, i + interval));
			
			boolean isIdentical = sameArray(charCountArr1, charCountArr2);
			
			if(isIdentical) {
				return true;
			}
		}
		return false;
	}
	
	private static int[] charCountArr(String s) {
		
		int[] countArr = new int[128];
		
		for (int i = 0; i < s.length(); i++) {
			
			char c = s.charAt(i);
			countArr[c]++;
		}
		return countArr;
	}
	
	private static boolean sameArray(int[] arr1, int arr2[]) {
		
		for (int i = 0; i < arr1.length; i++) {
			
			if(arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	//-----------------------------------------------------------------------//
	// fast
	public boolean checkInclusion2(String p, String s) { 
		
        int[] countArr = new int[128];
        
        for (char c : p.toCharArray()) {
            countArr[c]++;
        }
        
        for (int r = 0, l = 0; r < s.length(); ++r) {
        	
            char c = s.charAt(r);
            countArr[c]--;
            
            while (countArr[c] < 0) {     // If number of characters `c` is more than our expectation
                countArr[s.charAt(l)]++;  // Slide left until cnt[c] == 0
                l++;
            }
            if (r - l + 1 == p.length()) { // If we already filled enough `p.length()` chars
                return true;
            }
        }
        return false;
    }
	//-----------------------------------------------------------------------//
	
	/*
	public static boolean checkInclusion(String s1, String s2) {

		if(s2.length() < s1.length()) {
			return false;
		}
		int interval = s1.length();

		for (int i = 0; i < s2.length() - interval + 1; i++) {

			boolean isPermute = isPermutation(s1, s2.substring(i, i + interval));

			if(isPermute) {
				return true;
			}
		}
		return false;
	}


	// 
	private static boolean isPermutation(String s1, String s2) {

		if(s1.length() != s2.length()) {
			return false;
		}
		int n = s1.length();
		int[] countArr1 = new int[256];
		int[] countArr2 = new int[256];

		for (int i = 0; i < n; i++) {

			char c = s1.charAt(i);
			countArr1[c]++;
		}
		for (int i = 0; i < n; i++) {

			char c = s2.charAt(i);
			countArr2[c]++;
		}
		for (int i = 0; i < countArr1.length; i++) {

			if(countArr1[i] != countArr2[i]) {
				return false;
			}
		}
		return true;
	}
	*/
	//-----------------------------------------------------------------------//
}















