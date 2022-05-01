package questions.strings;
/*
Given a string s, check if it can be constructed by taking a 
substring of it and appending multiple copies of the substring together.

Example 1:
Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.

Example 2:
Input: s = "aba"
Output: false

Example 3:
Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.

Constraints:
1 <= s.length <= 10^4
s consists of lowercase English letters.
 */
public class _459_Repeated_Substring_Pattern {

	public static void main(String[] args) {

		System.out.println(repeatedSubstringPattern("ccxccxccx"));        // 3*(ccx)
		System.out.println(repeatedSubstringPattern("ccxccxccxccx"));     // 4*(ccx)
		System.out.println(repeatedSubstringPattern("ccxccxccxccxccx"));  // 5*(ccx) 
		System.out.println(repeatedSubstringPattern("ccxccxccxccxccxa")); // false
	}

	/*
	If your string S contains a repeating substring, then this means you can 
	"shift and wrap around" your string some number of times and have it match the original string.
	Example: abcabc
	Shift once: cabcab
	Shift twice: bcabca
	Shift three times: abcabc
	Now the string matches the original string, so you know there is a repeated substring.

	To avoid doing this weird wraparound and using modulo, you can just 
	create a new string SS that is the original string concatenated with itself, 
	and check if this new string contains the original string (shifted some number of times). 
	However, you don't want it to match with the first half (S) 
	and the second half (S), so you remove the first and last characters.
	 */
	public static boolean repeatedSubstringPattern(String s) { // "abab"

		String str = s + s;                       // "abab|abab"

		str = str.substring(1, str.length() - 1); // "bab|aba"

		return str.contains(s);                   // "b(ab|ab)a"
	}

	/*
	1.The length of the repeating substring must be a divisor of the length of the input string
	2.Search for all possible divisor of str.length, starting for length/2
	3.If i is a divisor of length, repeat the substring from 0 to i the number of times i is contained in s.length
	4.If the repeated substring is equals to the input str return true
	 */
	public static boolean repeatedSubstringPattern2(String str) {
		
		int len = str.length();
		
		for(int i = len/2; i >= 1; i--) {
			
			if(len % i == 0) {
				int m = len / i;
				String subS = str.substring(0,i);
				StringBuilder sb = new StringBuilder();
				
				for(int j = 0; j < m; j++) {
					sb.append(subS);
				}
				if(sb.toString().equals(str)) return true;
			}
		}
		return false;
	}
	
	
	
	// fastest
	public static boolean repeatedSubstringPattern3(String s) {
		
        int l = s.length();
        
        for(int i = l / 2; i >= 1; i--) {
            //only have to check if s can be divided evenly
            if(l % i == 0) {
                // n = how many times the substring would repeat
                int n = l / i;
                String subS = s.substring(0, i);
                
                if(isTheSubstring(subS, n, s)) {return true;}
            }
        }
        return false;
    }
	
	private static boolean isTheSubstring(String subS, int repeat, String s) {
		
        int len = subS.length();
        
        for(int i = 1; i < repeat; i++) {
            if(!subS.equals(s.substring(i * len, i * len + len)))
                return false;
        }
        return true;
    }
}















