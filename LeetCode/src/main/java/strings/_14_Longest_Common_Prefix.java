package strings;
/*
	Write a function to find the longest common prefix string amongst an array of strings.
	If there is no common prefix, return an empty string "".

	Example 1:
	Input: strs = ["flower","flow","flight"]
	Output: "fl"

	Example 2:
	Input: strs = ["dog","racecar","car"]
	Output: ""
	Explanation: There is no common prefix among the input strings.

	Constraints:
	1 <= strs.length <= 200
	0 <= strs[i].length <= 200
	strs[i] consists of only lower-case English letters.
 */
public class _14_Longest_Common_Prefix {

	public static void main(String[] args) {

		//String[] strs = {"flower","flow","flight"};
		//String[] strs = {""};
		//String[] strs = {"",""};
		//String[] strs = {"ab", "a"};
		String[] strs = {"flo1wer","flo2wer","flo7wer","flo9wer"};

		String ans = longestCommonPrefix(strs);

		System.out.println(ans);
	}
	
	
	public static String longestCommonPrefix(String[] strs) {

		// if any of the Strings is empty String the only prefix is ""
		for (int i = 0; i < strs.length; i++) {
			if(strs[i].equals("")) {
				return "";
			}
		}
		if(strs.length == 1) {
			return strs[0];
		}
		// find the shortest word to avoid exeeding search
		int shortWordLen = strs[0].length();

		for (int i = 1; i < strs.length; i++) {
			if(strs[i].length() < shortWordLen) {
				shortWordLen = strs[i].length();
			}
		}
		String ans = "";

		// which char we are sampling
		int charPosition = 0;

		char tempChar = strs[0].charAt(charPosition);

		while(charPosition < shortWordLen) {
			// skip the [0] word which is used for sampling the rest
			for(int i = 1; i < strs.length; ++i) {

				if(tempChar != strs[i].charAt(charPosition)) {
					return ans;
				}
			}
			ans = ans + tempChar;
			++charPosition;

			if(charPosition < shortWordLen) {
				tempChar = strs[0].charAt(charPosition);
			}
		}
		return ans;
	}
} // class





	

