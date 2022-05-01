package questions.strings;

/*
Given a string s which consists of lowercase or uppercase letters, 
return the length of the longest palindrome 
that can be built with those letters.
Letters are case sensitive, for example, 
"Aa" is not considered a palindrome here.

Example 1:
Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

Example 2:
Input: s = "a"
Output: 1

Example 3:
Input: s = "bb"
Output: 2

Constraints:
1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
 */
public class _409_Longest_Palindrome {

	public static void main(String[] args) {

		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicate"
				+ "dcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicp"
				+ "ateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlives"
				+ "thatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisBut"
				+ "inalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroun"
				+ "dThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpo"
				+ "orponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwes"
				+ "ayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededi"
				+ "catedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadva"
				+ "ncedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthat"
				+ "fromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethel"
				+ "astpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothaved"
				+ "iedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernme"
				+ "ntofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		
		//String s = "dccaccd";
		int res = longestPalindrome(s);
		System.out.println(res);
	}


	public static int longestPalindrome(String s) {

		int[] charCounter = new int[256];
		int res = 0;

		for (int i = 0; i < s.length(); i++) {
			charCounter[s.charAt(i)]++;
		}
		boolean oddDeceted = false;
		
		for (int i = 0; i < charCounter.length; i++) {
			if(charCounter[i] > 0) {

				if(charCounter[i] % 2 == 0) { // is even
					res += charCounter[i];
				}
				else if((charCounter[i]+1) % 2 == 0) { // is odd
					res += charCounter[i]-1;
					oddDeceted = true;
				}
			}
		}
		return oddDeceted ? res+1 : res;
	}
}







