package questions.other;

import java.util.*;

/*
Given an integer array nums that may contain duplicates,
return all possible subsets (the power set).

The solution set must not contain duplicate subsets.
Return the solution in any order.

Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:
Input: nums = [0]
Output: [[],[0]]

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
 */
public class _90_Subsets_II {

    public static void main(String[] args) {

        int[] arr = {4, 4, 4, 1, 4};
        List<List<Integer>> powerSet = subsetsWithDup(arr);

        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("powerSet: " + powerSet);
    }

    // =================================================================================== //
    private static List<List<Integer>> output;

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums); //handle duplicate, first sort the array (adjacent elements will be similar)

        output = new ArrayList<>();

        backTracking(0, nums, new ArrayList<>());

        return output;
    }

    private static void backTracking(int index, int[] nums, List<Integer> list) {

        output.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {

            if (i != index && nums[i] == nums[i - 1]) {
                continue; // skip the duplicates, except for the first time
            }
            list.add(nums[i]); // include

            backTracking(i + 1, nums, list); // explore

            list.remove(list.size() - 1);// backtrack, remove the element
        }
    }
    // =================================================================================== //
}
