package other;
/*
The Fibonacci numbers, commonly denoted F(n) form a sequence, 
called the Fibonacci sequence, such that each number 
is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).


Example 1:
Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

Example 2:
Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

Example 3:
Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

Constraints:
0 <= n <= 30
 */
public class _509_Fibonacci_Number {

	public static void main(String[] args) {

		int n = 30;

		for (int i = 0; i < n; i++) {
			System.out.print( fib(i) + "\t");
		}

		System.out.println();


		for (int i = 0; i < n; i++) {
			System.out.print( fibDP(i) + "\t");
		}

		System.out.println();

		for (int i = 0; i < n; i++) {
			System.out.print( fibArrDP(i) + "\t");
		}
	}

	//===============================================================//
	// Recursive
	public static int fib(int n) {

		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		return fib(n-1) + fib(n-2);
	}
	//===============================================================//
	// Iterative O(n), dynamic programming
	public static int fibDP(int n) {

		if(n <= 1) {
			return n;
		}
		int a = 0;
		int b = 1;
		int c = 0;

		for (int i = 2 ; i <= n ; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
	//===============================================================//
	// DP using array
		public static int fibArrDP(int n) {
			
	        if(n == 0) {
	        	return 0;
	        }
	        int dp[] = new int[n+1];
	        dp[0] = 0;
	        dp[1] = 1;
	        
	        for(int i = 2; i <= n; i++) {
	        	dp[i] = dp[i-1] + dp[i-2];
	        }
	        return dp[n];
		}
	//===============================================================//

	// O(1) if you don't need to go far :D
	public static int fibLOL(int n) {

		final int[] fibs = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169};

		return fibs[n];
	}
	//===============================================================//

}












