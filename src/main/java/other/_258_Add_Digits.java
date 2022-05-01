package other;
/*
Given an integer num, repeatedly add all its digits 
until the result has only one digit, and return it.

Example 1:
Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.

Example 2:
Input: num = 0
Output: 0

Constraints:
0 <= num <= 2^31 - 1
 */
public class _258_Add_Digits {

	public static void main(String[] args) {

		int num = 124;

		System.out.println(addDigits(num));
	}

	
	
	public static int addDigits(int num) {

		if(num < 10) { return num; }

		int sum = 0;

		while(num > 9) {
			while(num > 0) {
				sum += (num % 10);
				num /= 10;
			}
			num = sum;
		}
		return num;
	}

	/*
	Any number where it's digits add to 9 is always divisible by 9. (18, 27, 36, 45, 54, 63, 72, 81, 90, etc.) 
	Therefore the 'digital root' for any number divisible by 9 is always 9. 
	You can see this even in larger numbers like 99 because 9 + 9 = 18, 
	and then 1 + 8 = 9 still, so the root always becomes 9 for any numbers divisible by 9.

	Additionally, 0 always has a digital root of 0 obviously.

	The only other cases you need to worry about to find 
	the digital root are when it isn't 0 or 9.

	So for any number that isn't 0 and isn't divisible by 9, 
	the root will always n % 9 for a given number n. 
	(AKA the difference between given number n and the nearest number that is divisible by 9, 
	since numbers divisible by 9 always have a digital root of 9).
	For examples: 100 % 9 = 1 (one greater than 99, which is divisible by 9).
	101 % 9 = 2
	102 % 9 = 3 and so on.
	 */
	public static int addDigits2(int num) {

		if (num == 0){
			return 0;
		}
		if (num % 9 == 0){
			return 9;
		}
		else {
			return num % 9;
		}
	}
}
































