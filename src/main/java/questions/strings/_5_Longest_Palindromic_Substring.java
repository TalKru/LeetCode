package questions.strings;
/*
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.
 */
public class _5_Longest_Palindromic_Substring {

	public static void main(String[] args) {

		String s = "dgvsdgs1234567776543210gdfhdfh";
		System.out.println("String: " + s);
		System.out.println("Longest_Palindromic_Substring: " + longestPalindrome(s));
	}

	public static String longestPalindrome(String s) {

		if (s == null || s.length() < 1) {
			return "";
		}
		int start = 0; 
		int end = 0;

		for (int i = 0; i < s.length(); i++) {

			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);

			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int left, int right) {

		int L = left;
		int R = right;
		
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}

	/*
	https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/

	Dynamic Programming. 
	Approach: The time complexity can be reduced by storing results of sub-problems. The idea is similar to this post.  

	Maintain a boolean table[n][n] that is filled in bottom up manner.
	The value of table[i][j] is true, if the substring is palindrome, otherwise false.
	To calculate table[i][j], check the value of table[i+1][j-1], if the value is true and str[i] is same as str[j], 

	then we make table[i][j] true.
	Otherwise, the value of table[i][j] is made false.
	We have to fill table previously for substring of length = 1 and length =2 because 
	as we are finding , if table[i+1][j-1] is true or false , so in case of 
	(i) length == 1 , lets say i=2 , j=2 and i+1,j-1 doesn't lies between [i , j]
	(ii) length == 2 ,lets say i=2 , j=3 and i+1,j-1 again doesn't lies between [i , j].
	 */
	public static int longestPalSubstr(String str) {
		// get length of input string
		int n = str.length();

		// table[i][j] will be false if
		// substring str[i..j] is not palindrome.
		// Else table[i][j] will be true
		boolean table[][] = new boolean[n][n];

		// All substrings of length 1 are palindromes
		int maxLength = 1;
		for (int i = 0; i < n; ++i)
			table[i][i] = true;

		// check for sub-string of length 2.
		int start = 0;
		for (int i = 0; i < n - 1; ++i) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				table[i][i + 1] = true;
				start = i;
				maxLength = 2;
			}
		}
		// Check for lengths greater than 2.
		// k is length of substring
		for (int k = 3; k <= n; ++k) {

			// Fix the starting index
			for (int i = 0; i < n - k + 1; ++i) {
				// Get the ending index of substring from
				// starting index i and length k
				int j = i + k - 1;

				// checking for sub-string from ith index to
				// jth index iff str.charAt(i+1) to
				// str.charAt(j-1) is a palindrome
				if (table[i + 1][j - 1]
						&& str.charAt(i) == str.charAt(j)) {
					table[i][j] = true;

					if (k > maxLength) {
						start = i;
						maxLength = k;
					}
				}
			}
		}
		System.out.print("Longest palindrome substring is; " + str.substring(start, start + maxLength));
		return maxLength;
	}
}





