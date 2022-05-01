package questions.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string containing digits from 2-9 inclusive, 
return all possible letter combinations that the number 
could represent. Return the answer in any order.
A mapping of digit to letters (just like on the telephone buttons) 
is given below. Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]

Constraints:
0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */
public class _17_Letter_Combinations_of_Phone_Number {

	public static void main(String[] args) {

		String digits = "24";

		List<String> list = letterCombinations(digits);

		System.out.println(list.toString());
	}

	private static final Map<Character, List<String>> map = new HashMap<>();

	static {
		map.put('2', Arrays.asList("a", "b", "c"));
		map.put('3', Arrays.asList("d", "e", "f"));
		map.put('4', Arrays.asList("g", "h", "i"));
		map.put('5', Arrays.asList("j", "k", "l"));
		map.put('6', Arrays.asList("m", "n", "o"));
		map.put('7', Arrays.asList("p", "q", "r", "s"));
		map.put('8', Arrays.asList("t", "u", "v"));
		map.put('9', Arrays.asList("w", "x", "y", "z"));
	}

	public static List<String> letterCombinations(String digits) {

		if(digits.length() == 0) return Collections.emptyList();

		List<String> result = new ArrayList<>();

		result.addAll(map.get(digits.charAt(0))); // add first set

		for (int i = 1; i < digits.length(); i++) {

			List<String> tmpList = new ArrayList<>();          // 
			List<String> newChars = map.get(digits.charAt(i)); // pull existing combinations

			for (int j = 0; j < result.size(); j++) {
				for (int k = 0; k < newChars.size(); k++) {
					tmpList.add(result.get(j) + newChars.get(k));
				}
			}
			result = tmpList;
		}
		return result;
	}


}

















