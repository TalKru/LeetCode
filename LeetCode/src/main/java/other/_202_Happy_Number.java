package other;

import java.util.HashSet;

/*
Write an algorithm to determine if a number n is happy.
A happy number is a number defined by the following process:

Starting with any positive integer, 
replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:

Input: n = 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

Example 2:
Input: n = 2
Output: false

Constraints:
1 <= n <= 231 - 1
 */
public class _202_Happy_Number {

	public static void main(String[] args) {
		
		int n = 19;
		//int n = 2;
		System.out.println(isHappy(n));
	}


	public static boolean isHappy(int n) {

		HashSet<Integer> hs = new HashSet<>();
		int sum = 0;

		while(n != 1) {
			
			hs.add(n);
			//int temp = n;

			while(n != 0) {
				
				sum += Math.pow((n%10), 2);
				n /= 10;
			}
			if(sum == 1) { 
				return true; 
			}
			if(hs.contains(sum)) {
				return false;
			}
			n = sum;
			sum = 0;
		}
		return false;
	}
}






