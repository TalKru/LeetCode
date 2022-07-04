package questions.arrays;

import java.util.Arrays;

/*
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

Example 1:
Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

Example 2:
Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.

Constraints:
n == ratings.length
1 <= n <= 2 * 10^4
0 <= ratings[i] <= 2 * 10^4
 */
public class _135_Candy {

    public static void main(String[] args) {

        int[] ratings = {1, 0, 2};
        int candies = candy(ratings);

        System.out.println("Given candies = " + candies);
    }

    public static int candy(int[] ratings) {

        int[] candyArr = new int[ratings.length];

        Arrays.fill(candyArr, 1);// Give each child 1 candy

        for (int i = 1; i < candyArr.length; i++) { // Scan from left to right, to make sure right higher rated child gets 1 more candy than left lower rated child

            if (ratings[i] > ratings[i - 1]) {
                candyArr[i] = (candyArr[i - 1] + 1);
            }
        }
        for (int i = candyArr.length - 2; i >= 0; i--) { // Scan from right to left, to make sure left higher rated child gets 1 more candy than right lower rated child

            if (ratings[i] > ratings[i + 1]) {
                candyArr[i] = Math.max(candyArr[i], (candyArr[i + 1] + 1));
            }
        }
        int sum = 0;
        for (int c : candyArr) {
            sum += c;
        }
        return sum;
    }

}
