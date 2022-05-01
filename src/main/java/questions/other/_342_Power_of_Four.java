package questions.other;
/*
Given an integer n, return true if it is a power of four. 
Otherwise, return false.
An integer n is a power of four, 
if there exists an integer x such that n == 4^x.

Example 1:
Input: n = 16
Output: true

Example 2:
Input: n = 5
Output: false

Example 3:
Input: n = 1
Output: true

Constraints:
-2^31 <= n <= 2^31 - 1
 */
public class _342_Power_of_Four {

	public static void main(String[] args) {

		//		int n = 16;
		//		boolean res = isPowerOfFour(n);
		//		System.out.println(res);

		System.out.println(2147483647 + " -> " + isPowerOfThree(2147483647));

		/*
		for (int i = 0; i < 1000000; i++) {
			if(isPowerOfFour(i)) {
				System.out.println(i + " -> " + isPowerOfFour(i));
			}
		}
		 */

	}

	public static boolean isPowerOfFour(int n) {

		if(n % 2 != 0 && n != 1) return false;

		int i = 0;
		long sample = 0;

		while(sample < n) {

			sample = (int)Math.pow(4, i++);

			if(sample >= Integer.MAX_VALUE) {
				return false;
			}
			
			if(sample == n) {
				return true;
			}
		}
		return false;
	}

	public static boolean isPowerOfThree(int n) {

		if(n % 2 == 0 && n != 1) return false;

		int i = 0;
		long sample = 0;

		while(sample < n) {

			sample = (int)Math.pow(3, i++);
			
			if(sample >= Integer.MAX_VALUE) {
				return false;
			}
			
			if(sample == n) {
				return true;
			}
		}
		return false;
	}
}

















