package other;
/*
Given an integer x, return true if x is palindrome integer.
An integer is a palindrome when it reads the same backward as forward. 
For example, 121 is palindrome while 123 is not.

Example 1:
Input: x = 121
Output: true

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. 
Therefore it is not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Example 4:
Input: x = -101
Output: false

Constraints:
-231 <= x <= 231 - 1
 */
public class _9_Palindrome_Number {

	public static void main(String[] args) {

		int x = 888111881;

		boolean res = isPalindrome(x);
		System.out.println("Value x=(" + x + ") is palindrome? -> " + res);
	}

	
	
//	public static boolean isPalindrome(int x) {
//
//		if(x < 0) {
//			return false;
//		}
//
//		String numStr = String.valueOf(x);
//
//		for (int i = 0; i < numStr.length()/2 ; i++) {
//
//			if( numStr.charAt(i) != numStr.charAt(numStr.length()-i-1) ) {
//				return false;
//			}
//		}
//		return true; 
//	}

	
	
	public static boolean isPalindrome(int x) {

		if(x < 0)  { return false; }
		if(x <= 9) { return false; }
		
		int temp = x;
		int rev = 0;

		while(temp != 0) {
			
			rev = rev * 10 + (temp % 10);  // temp's last digit is (temp % 10)
			temp /= 10;
		}
		if(rev == x) { return true; }
		else { return false; }
	}

}
























