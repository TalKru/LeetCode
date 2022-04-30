package other;
/*
	Given a non-negative integer x, 
	compute and return the square root of x.
	Since the return type is an integer, 
	the decimal digits are truncated, 
	and only the integer part of the result is returned.
	
	Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
	
	Example 1:
	Input: x = 4
	Output: 2
	
	Example 2:
	Input: x = 8
	Output: 2
	Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
	
	Constraints:
	0 <= x <= 231 - 1
 */
public class _69_Sqrt_x {

	public static void main(String[] args) {
		
		//int num = 30276; // root 174
		int num = 8;
		int res = mySqrt(num);
		System.out.println("INT square root of: " + num +  ", is: " + res);
	}

	
	
	public static int mySqrt(int x) {
		
		if(x == 0) { return 0; }
		
		long start = 0;
        long end = x;
        
        while (start + 1 < end) {
        	
            long mid = start + (end - start) / 2;
            
            if (mid * mid == x) {
                return (int)mid;
            } 
            else if (mid * mid < x) {
                start = mid;
            } 
            else {
                end = mid;
            }
        }
        
        if (end * end == x) {
            return (int)end;
        }
        return (int)start;
	}
}

















