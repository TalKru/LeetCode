package arrays;

import java.util.Arrays;
/*
You are given an array prices where prices[i] is the price of a given stock on the i-th day.

You want to maximize your profit by choosing a single day to buy one stock 
and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. 
If you cannot achieve any profit, return 0.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

Constraints:
1 <= prices.length <= 105
0 <= prices[i] <= 104

 */
public class _121_Best_Time_to_Buy_and_Sell_Stock {

	public static void main(String[] args) {

		int[] prices = {7,1,5,3,6,4,0,1,3,2,4};

		System.out.println("Stock prices: " + Arrays.toString(prices));

		int bestProfit = maxProfit(prices);

		System.out.println("Maximum profit which may be yielded: " + bestProfit);
	} // main


	// O(n)
	public static int maxProfit(int[] prices) {

		int maxProfit = 0;
		int profit = 0;
		int lowPriceSoFar = prices[0];
		
		for (int i = 0; i < prices.length; i++) {
			
			lowPriceSoFar = Math.min(lowPriceSoFar, prices[i]);
			
			profit = prices[i] - lowPriceSoFar;

			maxProfit = Math.max(maxProfit, profit);
		}
		return maxProfit;
	}

	/* 
	Best solution, keeps track of the local min value and checks for each day 
	if selling profit is higher that previous ATH 

		 prices:    7,1,5,3,6,4,0,1,3,2,4
		 minSoFar:  7,1,1,1,1,1,0,0,0,0,0
		 maxProfit: 0,0,4,4,5,5,5,5,5,5,5

	Try to think that for each day we compare the sell value as: (today price - last known min price) = mew max profit
	 */
	public static int maxProfit2(int[] prices) {

		int maxProfit = 0;
		int minSoFar = prices[0];

		for (int i = 1; i < prices.length; i++) {

			minSoFar = Math.min(minSoFar, prices[i]);               // min price so far
			maxProfit = Math.max(maxProfit, prices[i] - minSoFar);  // prev max profit vs (current price - buy at min price so far)
		}
		return maxProfit;
	}

	/* Dynamic programming (the way to understand the best solution above), O(2n) */
	public static int maxProfit3(int[] prices) {

		// create local min values intervals
		// input:   7,1,5,3,6,4,0,1,3,2,4
		// output:  7,1,1,1,1,1,0,0,0,0,0
		int[] lowestSoFar = new int[prices.length];

		int localMin = prices[0];

		for (int i = 0; i < prices.length; i++) {

			localMin = Math.min(prices[i], localMin);
			lowestSoFar[i] = localMin;
		}

		int maxProfit = 0;

		for (int i = 0; i < prices.length; i++) {

			maxProfit = Math.max(maxProfit, prices[i] - lowestSoFar[i]);
		}
		return maxProfit;
	}

}








