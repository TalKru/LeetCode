package questions.other;
/*
Given an integer array nums of unique elements,
return all possible subsets (the power set).
The solution set must not contain duplicate subsets.
Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:
Input: nums = [0]
Output: [[],[0]]

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 */

import java.util.*;

public class _78_Subsets {

    public static void main(String[] args) {

        int[] arr = {1,2,3};
        List<List<Integer>> powerSet = subsets(arr);

        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("powerSet: " + powerSet);
    }
    // =============================================================== //

    public static List<List<Integer>> subsets(int[] nums) {

        long n = (long) Math.pow(2, nums.length);

        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            List<Integer> set = new LinkedList<>();

            for (int j = 0; j < nums.length; j++) {

                if ((i & (1 << j)) != 0) {
                    set.add(nums[j]);
                }
            }
            result.add(set);
        }
        return result;
    }

    // =============================================================== //

    public static Set<Set<Integer>> powerSet(Set<Integer> ints) {

        List<Integer> list = new ArrayList<>(ints); // convert set to a list

        long n = (long) Math.pow(2, list.size()); // `n` stores the total number of subsets

        Set<Set<Integer>> result = new HashSet<>();

        for (int i = 0; i < n; i++) {  // generate each subset one by one

            Set<Integer> set = new HashSet<>();

            for (int j = 0; j < list.size(); j++) { // check every bit of `i`

                if ((i & (1 << j)) != 0) { // if j'th bit of `i` is set, add `S[j]` to the current set
                    set.add(list.get(j));
                }
            }
            result.add(set);
        }
        return result;
    }

    /*
    public static void main(String[] args) {

        Set<Integer> testSet = new HashSet<>();
        testSet.add(1);
        testSet.add(3);
        testSet.add(2);
        testSet.add(4);

        Set<Set<Integer>> result = powerSet(testSet);

        for (Set<Integer> pset: result) {
            System.out.println(pset);
        }
    }
     */
    // =============================================================== //
}

