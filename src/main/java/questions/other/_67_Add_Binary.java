package questions.other;

/*
    Given two binary strings a and b, return their sum as a binary string.
	
	Example:
	Input: a = "11", b = "1"
	Output: "100"
	
	Example 2:
	Input: a = "1010", b = "1011"
	Output: "10101"
	 
	Constraints:
	1 <= a.length, b.length <= 104
	a and b consist only of '0' or '1' characters.
	Each string does not contain leading zeros except for the zero itself.
 */
public class _67_Add_Binary {

	public static void main(String[] args) {
		
		String s1 = "1110";
		String s2 = "1010";
		String add = addBinary(s1, s2);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(add);
	}

	static String addBinary(String a, String b) {
		
		if(b.equals("0")) { return a; }
		if(a.equals("0")) { return b; }
		
		StringBuilder result = new StringBuilder();

		int s = 0; // Initialize digit sum        
		int i = a.length() - 1;
		int j = b.length() - 1;

		while (i >= 0 || j >= 0 || s == 1) {
			// Comput sum of last
			// digits and carry
			s += ((i >= 0)? a.charAt(i) - '0': 0);
			s += ((j >= 0)? b.charAt(j) - '0': 0);
			// If current digit sum is
			// 1 or 3, add 1 to result
			result.append((char)(s % 2 + '0'));

			s /= 2; // Compute carry
			i--; // Move to next digits
			j--; 
		}
		// Remove leading zeros, if any
		int start = result.length()-1;

		while(start >=0 && result.charAt(start) == '0') {
			start--;
		}
		if(start != result.length()-1) {
			result.delete(start+1,result.length());
		}
		return result.reverse().toString();
	}
}
