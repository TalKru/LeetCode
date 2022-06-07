package questions.arrays;

import java.util.HashMap;
import java.util.Map;

/*
In a deck of cards, each card has an integer written on it.
Return true if and only if you can choose X >= 2
such that it is possible to split
the entire deck into 1 or more groups of cards, where:

Each group has exactly X cards.
All the cards in each group have the same integer.

Example 1:
Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].

Example 2:
Input: deck = [1,1,1,2,2,2,3,3]
Output: false
Explanation: No possible partition.

Constraints:
1 <= deck.length <= 10^4
0 <= deck[i] < 10^4
 */
public class _914_X_of_a_Kind_in_a_Deck_of_Cards {

    public static void main(String[] args) {

        //int[] deck = {1, 2, 3, 4, 4, 3, 2, 1};
        int[] deck = {1,1,2,2,2,2};

        System.out.println(hasGroupsSizeX(deck));
    }

    public static boolean hasGroupsSizeX(int[] deck) {

        if (deck.length < 2) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int k : deck) {

            int newOrDefault = map.getOrDefault(k, 0) + 1;

            map.put(k, newOrDefault);
        }
        int minGroupSize = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            minGroupSize = Math.min(minGroupSize, entry.getValue());
        }
        if (minGroupSize < 2) {
            return false;
        }
        // Iterate from minGroupSize down to 2 to see if exists a least common denominator
        for (int i = minGroupSize; i >= 2; i--) {

            boolean lcd = true; // Flag to detect if a number is a lcd

            for (int k : map.keySet()) {
                if (map.get(k) % i != 0) lcd = false;
            }
            if (lcd) {  //  k can divide all items in the map
                return true;
            }
        }
        return false;
    }
    // ============================================================================= //
    public static boolean hasGroupsSizeX2(int[] deck) {

        HashMap<Integer, Integer> count = new HashMap<>();
        int res = 0;

        for (int i : deck) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        for (int i : count.values()) {
            res = gcd(i, res);
        }
        return res > 1;
    }

    private static int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
    // ============================================================================= //
}
