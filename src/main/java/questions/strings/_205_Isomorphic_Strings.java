package questions.strings;

import java.util.HashMap;
import java.util.HashSet;

/*
Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character 
while preserving the order of characters. No two characters may map to the same character, 
but a character may map to itself.

Example 1:
Input: s = "egg", t = "add"
Output: true

Example 2:
Input: s = "foo", t = "bar"
Output: false

Example 3:
Input: s = "paper", t = "title"
Output: true

Constraints:
1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
 */
public class _205_Isomorphic_Strings {

	public static void main(String[] args) {

		String s = "badc";
		String t = "baba";
		//		String s = "paper";
		//		String t = "title";

		boolean res = isIsomorphic(s, t);

		System.out.println("String 1: " + s);
		System.out.println("String 2: " + t);
		System.out.println("Strings are isomorphic(?): " + res);
	}


	// Time complexity O(n), n is strings size
	public static boolean isIsomorphic(String s, String t) {

		if(s.length() != t.length()) return false;

		HashMap<Character, Character> map = new HashMap<>();
		HashSet<Character> vals = new HashSet<>();

		for (int i = 0; i < s.length(); i++) {

			char ch1 = s.charAt(i);
			char ch2 = t.charAt(i);

			//			System.out.println("ch1: " + ch1);
			//			System.out.println("ch2: " + ch2);
			//			System.out.println("--------");

			if(!map.containsKey(ch1)) {     // does not contain ch1, add (ch1,ch2)

				if(vals.contains(ch2)) { return false; }      // attempt to assign new key to existing value 

				map.put(ch1, ch2);
				vals.add(ch2);

			}
			else {                          // does contain ch1
				if(map.get(ch1) != ch2) {
					return false;
				}
			}
		}
		return true;
	}

	/*
	LeetCode expert amazing solution:
	The idea is that we need to map a char to another one, for example, "egg" and "add", 
	we need to construct the mapping 'e' -> 'a' and 'g' -> 'd'. 
	Instead of directly mapping 'e' to 'a', another way is to mark them with same value, for example, 
	'e' -> 1, 'a'-> 1, and 'g' -> 2, 'd' -> 2, this works same.
	So we use two arrays here m1 and m2, initialized space is 256
	(Since the whole ASCII size is 256, 128 also works here). 
	Traverse the character of both s and t on the same position, 
	if their mapping values in arr1 and arr2 are different, means they are not mapping correctly, 
	return false; else we construct the mapping, since arr1 and arr2 are both initialized as 0, 
	we want to use a new value when i == 0, so i + 1 works here.
	 */
	public static boolean isIsomorphic2(String s, String t) {

		int[] arr1 = new int[256];
		int[] arr2 = new int[256];

		for (int i = 0; i < s.length(); i++) {

			char c1 = s.charAt(i);
			char c2 = t.charAt(i);

			if (arr1[c1] != arr2[c2]) {
				return false;
			}
			arr1[c1] = i + 10; // array inits to 0, so when i is 0,
			arr2[c2] = i + 10; // it may result unwanted mapping to 0
		}
		return true;
	}
}













