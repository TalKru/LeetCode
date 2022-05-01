package other;
/*
The Hamming distance between two integers is the number 
of positions at which the corresponding bits are different.
Given two integers x and y, return the Hamming distance between them.

Example 1:
Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.

Example 2:
Input: x = 3, y = 1
Output: 1

Constraints:
0 <= x, y <= 2^31 - 1
 */
public class _461_Hamming_Distance {

	public static void main(String[] args) {

		int x = 56724;
		int y = 434;
		int result = hammingDistance(x, y);
		
		System.out.println("Hamming distance: " + result);
	}
	
	// fast (bit manipulation)
	public static int hammingDistance(int x, int y) {
		return Integer.bitCount(x ^ y);
	}
	
	// slow
	public static int hammingDistance2(int x, int y) {
		
		String s1 = Integer.toBinaryString(x);
		String s2 = Integer.toBinaryString(y);
		
		int maxLen = Math.max(s1.length(), s2.length());
		
		String format = "%" + Integer.toString(maxLen) + "s";
		
		s1 = String.format(format, s1).replaceAll(" ", "0"); 
		s2 = String.format(format, s2).replaceAll(" ", "0"); 
		
		int difCount = 0;
		
		for (int i = 0; i < maxLen; i++) {
			if(s1.charAt(i) != s2.charAt(i)) difCount++;
		}
		return difCount;
	}
}










