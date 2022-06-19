package questions.arrays;

import java.util.ArrayList;
import java.util.List;

/*
Given an array nums of distinct integers,
return all the possible permutations.
You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]

Constraints:
1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 */
public class _46_Permutations {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> resultList = permute(nums);

        System.out.println(resultList.toString());
    }


    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        backtrack(list, new ArrayList<>(), nums);

        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {

        if (tempList.size() == nums.length) {

            list.add(new ArrayList<>(tempList));
        }
        else {

            for (int i = 0; i < nums.length; i++) {

                if (tempList.contains(nums[i])) { // element already exists
                    continue;
                }
                tempList.add(nums[i]);

                backtrack(list, tempList, nums);

                tempList.remove(tempList.size() - 1);
            }
        }
    }


}
