package questions.arrays;

import java.util.Arrays;

/*
There are n gas stations along a circular route,
where the amount of gas at the ith station is gas[i].
You have a car with an unlimited gas tank and it costs cost[i]
of gas to travel from the ith station to its next (i + 1)th station.
You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost,
return the starting gas station's index if you can travel
around the circuit once in the clockwise direction, otherwise return -1.
If there exists a solution, it is guaranteed to be unique

Example 1:
Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.

Example 2:
Input: gas = [2,3,4], cost = [3,4,3]
Output: -1
Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.

Constraints:
n == gas.length == cost.length
1 <= n <= 105
0 <= gas[i], cost[i] <= 10^4
 */
public class _134_Gas_Station {

    public static void main(String[] args) {

//        int[] gas  = {1,2,3,4,5};
//        int[] cost = {3,4,5,1,2};
//        int[] gas  = {5,8,2,8};
//        int[] cost = {6,5,6,6};
        int[] gas = {3, 1, 1};
        int[] cost = {1, 2, 2};

        System.out.println("Gas:  " + Arrays.toString(gas));
        System.out.println("Cost: " + Arrays.toString(cost));

        int res = canCompleteCircuit(gas, cost);
        System.out.println("canCompleteCircuit: " + res);
    }


    /*
        gas         [1][2][3]
        price       [2][0][1]
        gas - price [-1][2][2]
        double same arr to check cycle [-1][2][2][-1][2][2]
    */
    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        int[] path = new int[2 * n];

        for (int i = 0; i < n; i++) {
            path[i] = gas[i] - cost[i];
            path[i + n] = gas[i] - cost[i];
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int currStartIndex = 0;
        int maxIndex = -1;

        for (int i = 0; i < 2 * n; i++) {

            if (sum < 0) {
                sum = 0;
                currStartIndex = i;
            }
            sum += path[i];

            if (sum > max) {
                max = sum;
                maxIndex = currStartIndex;
            }
        }
        if (maxIndex == -1) { // if all vals were negative int the path arr
            return -1;
        }
        int testSum = 0;
        for (int i = maxIndex; i < n; i++) {       // [][][][][][x][x][x]
            testSum += path[i];
        }
        for (int i = 0; i < maxIndex; i++) {       // [x][x][x][x][x][][][]
            testSum += path[i];
        }
        if (testSum >= 0) {
            return maxIndex;
        } else {
            return -1;
        }
    }

    // ============================================================================= //
    // different approach - faster but more complicated
    public static int canCompleteCircuit2(int[] gas, int[] cost) {

        int n = gas.length;
        int currSum = 0;
        int fullPathSum = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {

            fullPathSum  += (gas[i] - cost[i]);
            currSum += (gas[i] - cost[i]);

            if (currSum < 0) {
                currSum = 0;
                start = i + 1;
            }
        }
        return (fullPathSum < 0) ? (-1) : start;
    }
    // ============================================================================= //
}
