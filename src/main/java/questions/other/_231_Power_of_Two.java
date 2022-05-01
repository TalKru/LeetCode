package questions.other;
/*
Given an integer n, return true if it is a power of two. 
Otherwise, return false.
An integer n is a power of two, 
if there exists an integer x such that n == 2x.

Example 1:
Input: n = 1
Output: true
Explanation: 2^0 = 1

Example 2:
Input: n = 16
Output: true
Explanation: 2^4 = 16

Example 3:
Input: n = 3
Output: false
 */
public class _231_Power_of_Two {

	public static void main(String[] args) {

		System.out.println(isPowerOfTwo(3));

	}


	public static boolean isPowerOfTwo(int n) {

		if (n <= 0) return false;

		while (n%2 == 0) {
			n /= 2;
		}
		return n == 1;
	}
}









