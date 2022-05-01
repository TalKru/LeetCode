package questions.strings;
/*
Given two questions.strings s and goal, return true if and only
if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character 
of s to the rightmost position.
For example, if s = "abcde", 
then it will be "bcdea" after one shift.
 
Example 1:
Input: s = "abcde", goal = "cdeab"
Output: true

Example 2:
Input: s = "abcde", goal = "abced"
Output: false
 
Constraints:
1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters.
*/
public class _796_Rotate_String {

	public static void main(String[] args) {

		String s = "abcde";
		String goal = "cdeab";
		
		System.out.println(rotateString(s, goal));
	}
	
	
	public static boolean rotateString(String s, String goal) {
		
		if(s.length() != goal.length()) {
        	return false;
        }
		String tmp = new String(s);
		
		for (int i = 0; i < s.length() - 1; i++) {
			
			tmp = tmp.charAt(tmp.length() - 1) + tmp.substring(0, tmp.length() - 1);
			
			if(tmp.equals(goal)) {
				return true;
			}
		}
		return false;
	}
	
	
	// no built-in methods
	public static boolean rotateString2(String A, String B) {
		
		if(A.length() != B.length()) {
        	return false;
        }
        if(A.length() == 0) {
        	return true;
        }
        char start = A.charAt(0);
        
        for(int i = 0; i < B.length(); i++) { 
				
            int j = i;
            
            while(j < B.length() && B.charAt(j) != start) {
            	j++;
            }
            if(j >= B.length()) {
            	return false;
            }
            for(int n = 0; n < B.length(); n++) {
            	
                if(A.charAt(n) != B.charAt((n + j) % B.length())) {
                	break;
                }
                if(n == B.length() - 1) {
                	return true;
                }
            }
           i = j;
        }
        return false;
    }
	
	
	public boolean rotateString3(String s, String goal) {
		
        if(s.length() != goal.length()) {
        	return false;
        }
        String s2 = s + s;
        
        return (s2.contains(goal));
    }
}
