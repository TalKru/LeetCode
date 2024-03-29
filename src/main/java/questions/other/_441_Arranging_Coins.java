package questions.other;
/*
You have n coins and you want to build a staircase with these coins. 
The staircase consists of k rows where the ith row has exactly i coins. 
The last row of the staircase may be incomplete.
Given the integer n, return the number of 
complete rows of the staircase you will build.


Example 1:
Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.

Example 2:
Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.

Constraints:
1 <= n <= 2^31 - 1
 */
public class _441_Arranging_Coins {

	public static void main(String[] args) {

		int n = 8;
		int result = arrangeCoins(n);
		System.out.println(result);
	}

	
	
	/**
	 * Math: Using Sum of Integers Formula
	 *
	 * This problem can be reduced down to:
	 *      (K * (K+1))/2 <= N
	 *      K^2 + K <= 2*N
	 *      (K + 1/2)^2 <= 2*N + 1/4
	 *      K <= sqrt(2*N + 1/4) - 1/2
	 *
	 * Since we want the row that has full levels, we just need to return the floor of above result.
	 * Thus, K = floor(sqrt(2*N + 1/4) - 1/2)
	 *
	 * Time Complexity: O(1)
	 *
	 * Space Complexity: O(1)
	 */
	public static int arrangeCoins(int n) {
		return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
	}


	
	/**
	 * Optimized binary search
	 *
	 * Time Complexity: O(log(N/2)). In case of Int.MAX, time complexity can maximum
	 * be O(30) = O(1)
	 *
	 * Space Complexity: O(1)
	 *
	 * N = Input number
	 */
	public static int arrangeCoins2(int n) {
		
		if (n <= 1) {
			return n;
		}
		if (n <= 3) {
			return n == 3 ? 2 : 1;
		}
		// Binary Search space will start from 2 to n/2.
		long start = 2;
		long end = n / 2;
		
		while (start <= end) {
			long mid = start + (end - start) / 2;
			long coinsFilled = mid * (mid + 1) / 2;
			
			if (coinsFilled == n) {
				return (int) mid;
			}
			if (coinsFilled < n) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		// Since at this point start > end, start will start pointing to a value greater
		// than the desired result. We will return end as it will point to the correct
		// int value.
		return (int) end;
	}


	// O(n)
	public static int arrangeCoins3(int n) {

		int coins = n;
		int currLevel = 0;

		while(coins - currLevel > 0) {
			currLevel++;
			coins -= currLevel;
		}
		return currLevel;
	}
}






