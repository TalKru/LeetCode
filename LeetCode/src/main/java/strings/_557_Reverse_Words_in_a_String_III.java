package strings;
/*
Given a string s, reverse the order of characters in each word
 within a sentence while still 
 preserving whitespace and initial word order.

Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:
Input: s = "God Ding"
Output: "doG gniD"

Constraints:
1 <= s.length <= 5 * 10^4
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.
 */
public class _557_Reverse_Words_in_a_String_III {

	public static void main(String[] args) {

		String s1 = "Let's take LeetCode contest";

		System.out.println("input string: " + s1);
		System.out.println("     reverse: " + reverseWords(s1));
	}

	// O(n)
	public static String reverseWords(String s) {

		char[] charArr = s.toCharArray();
		int start = 0;
		int end = 0;
		
		for(; end < charArr.length; end++){
			
			if(charArr[end] == ' '){
				reverse(charArr, start, end-1);
				start = end+1;
			}
		}
		reverse(charArr, start, end-1);
		return new String(charArr);
	}

	private static void reverse(char[] charArr, int start, int end){
		
		while(start < end){
			char temp = charArr[end];
			charArr[end] = charArr[start];
			charArr[start] = temp;
			start++;
			end--;
		}
	}


	
	// slow
	public static String reverseWords2(String s) {

		String reverse = new StringBuffer(s).reverse().toString();

		String[] strArr = reverse.split("\\s+");

		reverse = "";

		for(int i = strArr.length - 1;  i >= 1 ; i--) {

			reverse += strArr[i] + " ";
		}
		reverse += strArr[0]; // last word without " ";

		return reverse;
	}
}
