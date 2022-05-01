package questions.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
Suppose Andy and Doris want to choose a restaurant for dinner, 
and they both have a list of favorite restaurants represented by questions.strings.

You need to help them find out their common interest with 
the least list index sum. If there is a choice tie between answers, 
output all of them with no order requirement. 
You could assume there always exists an answer.

Example 1:
Input:
 list1 = ["Shogun","Tapioca Express","Burger King","KFC"], 
list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".

Example 2:
Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], 
list2 = ["KFC","Shogun","Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the 
least index sum is "Shogun" with index sum 1 (0+1).

Constraints:

1 <= list1.length, list2.length <= 1000
1 <= list1[i].length, list2[i].length <= 30
list1[i] and list2[i] consist of spaces ' ' and English letters.
All the stings of list1 are unique.
All the stings of list2 are unique.
 */
public class _599_Minimum_Index_Sum_of_Two_Lists {

	public static void main(String[] args) {

		String[] s1 = {"Shogun","Tapioca Express","Burger King","KFC"};
		String[] s2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
		
		System.out.println( Arrays.toString(s1) );
		System.out.println( Arrays.toString(s2) );
		
		System.out.println("1. find Restaurant: " + Arrays.toString(findRestaurant(s1, s2)) );
		System.out.println("2. find Restaurant: " + Arrays.toString(findRestaurant2(s1, s2)) );
	}
	//====================================================================================//

	// fast
	public static String[] findRestaurant(String[] list1, String[] list2) {

		Map<String, Integer> map = new HashMap<>();
		List<String> res = new LinkedList<>();
		int minSum = Integer.MAX_VALUE;

		for (int i = 0; i < list1.length; i++) {

			map.put(list1[i], i);
		}
		for (int i = 0; i < list2.length; i++) {

			Integer j = map.get(list2[i]);

			if (j != null && i + j <= minSum) {

				if (i + j < minSum) { 
					res.clear(); 
					minSum = i + j; 
				}
				res.add(list2[i]);
			}
		}
		return res.toArray(new String[res.size()]);
	}
	//====================================================================================//

	// slow
	public static String[] findRestaurant2(String[] list1, String[] list2) {

		HashMap<String, Integer> map = new HashMap<>();
		int minIndexSum = Integer.MAX_VALUE;

		for (int i = 0; i < list1.length; i++) {
			for (int j = 0; j < list2.length; j++) {

				if( list1[i].equals(list2[j]) ) {
					
					map.put(list1[i], i + j );

					minIndexSum = Math.min(minIndexSum, i + j);
				}
			}
		}
		int bestResCount = 0;

		for (HashMap.Entry<String, Integer> entry : map.entrySet()) {

			if( entry.getValue() == minIndexSum ) {
				bestResCount++;
			}
		}
		String[] res = new String[bestResCount];

		int i = 0;
		for (HashMap.Entry<String, Integer> entry : map.entrySet()) {

			if( entry.getValue() == minIndexSum ) {
				res[i++] = entry.getKey();
			}
		}
		return res;
	}
	//====================================================================================//

}
