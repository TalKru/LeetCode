package other;
/*
Given a signed 32-bit integer x, return x with its digits reversed. 
If reversing x causes the value to go outside the 
signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to 
store 64-bit integers (signed or unsigned).

Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21
 
Constraints:
-231 <= x <= 231 - 1
*/
public class _7_Reverse_Integer {

	public static void main(String[] args) {
		
	}
	
	
	public static int reverse(int x) {
        
	      int prevRev = 0;
	      int rev = 0;
	        
	        while(x != 0){
	            rev = rev * 10 + x % 10;
	            
	            if((rev - x % 10) / 10 != prevRev){
	                return 0;
	            }
	            prevRev = rev;
	            x = x/10;
	        }
	        return rev;
	    }
}
