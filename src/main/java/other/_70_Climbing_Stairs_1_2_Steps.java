package other;
/*
	You are climbing a staircase. It takes n steps to reach the top.
	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

	Example 1:

	Input: n = 2
	Output: 2
	Explanation: There are two ways to climb to the top.
	1. 1 step + 1 step
	2. 2 steps
 */

public class _70_Climbing_Stairs_1_2_Steps {

	public static void main(String[] args) {

		int n = 45;
		System.out.println("Stairs: " + n);

		long startTime = System.currentTimeMillis();
		int ans = climbStairs(n);
		System.out.println("ways: " + ans);
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("Runtime: " + estimatedTime + "(ms)");
	}



	public static int climbStairs(int n) {

		if(n <= 3) { return n; }

		int curr = 0;
		int prev1step = 2;
		int prev2step = 1;

		for (int i = 3; i <= n; i++) {

			curr = prev1step + prev2step;
			prev2step = prev1step;
			prev1step = curr;
		}
		return curr;
	}



	//	public static int climbStairs(int n) {
	//		
	//		if(n == 0 || n == 1) { return 1; }
	//		
	//		int[] arr = new int[n+1];
	//		arr[0] = 1;
	//		arr[1] = 1;
	//		
	//		for (int i = 2; i < arr.length; i++) {
	//			arr[i] = arr[i-1] + arr[i-2];
	//		}
	//		return arr[n];
	//	}


	/* Reduction to fibonacci sequence - recursive solution */
	//	public static int climbStairs(int n) {
	//
	//		return fib(n);
	//	}
	//	public static int fib(int n){
	//
	//		if(n <= 1){return 1;}
	//		if(n == 2){return 2;}
	//
	//		return fib(n-1) + fib(n-2);
	//	}

}
