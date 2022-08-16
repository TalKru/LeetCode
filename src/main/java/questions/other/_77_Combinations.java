package questions.other;

import java.util.*;

/*
Given two integers n and k,
return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

Example 1:
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

Example 2:
Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.

Constraints:
1 <= n <= 20
1 <= k <= n
 */
public class _77_Combinations {

    public static void main(String[] args) {

        int n = 4;
        int k = 2;

        List<List<Integer>> res = combine(n, k);

        System.out.println("Combinations: " + res);
    }


    public static List<List<Integer>> combine(int n, int k) {

        if (n == 0 || k == 0 || k > n) {
            return Collections.emptyList();
        }
        List<List<Integer>> combinationsList = new ArrayList<>();

        for (int i = 1; i <= n + 1 - k; i++) {
            combinationsList.add(Arrays.asList(i));
        }
        for (int i = 2; i <= k; i++) {

            List<List<Integer>> tempList = new ArrayList<>();

            for (List<Integer> list : combinationsList) {
                for (int m = list.get(list.size()-1)+1; m <= n - (k-i); m++) {

                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(m);
                    tempList.add(newList);
                }
            }
            combinationsList = tempList;
        }
        return combinationsList;
    }

}
