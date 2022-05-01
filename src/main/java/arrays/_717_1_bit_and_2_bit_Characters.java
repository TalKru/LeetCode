package arrays;

import java.util.Arrays;

/*
We have two special characters:

The first character can be represented by one bit 0.
The second character can be represented by two bits (10 or 11).
Given a binary array bits that ends with 0, return true if the last character must be a one-bit character.

Example 1:
Input: bits = [1,0,0]
Output: true
Explanation: The only way to decode it is two-bit character and one-bit character.
So the last character is one-bit character.

Example 2:
Input: bits = [1,1,1,0]
Output: false
Explanation: The only way to decode it is two-bit character and two-bit character.
So the last character is not one-bit character.


Constraints:

1 <= bits.length <= 1000
bits[i] is either 0 or 1.
 */
public class _717_1_bit_and_2_bit_Characters {

    public static void main(String[] args) {

        int[] input = {1,1,0,0};
        System.out.println(Arrays.toString(input));
        System.out.println(isOneBitCharacter(input));
    }

    public static boolean isOneBitCharacter(int[] bits) {

        int counter = 0; // count 1 bits

        for (int i = bits.length - 2; i >= 0 && bits[i] != 0 ; i--) {
            counter++;
        }

        return (counter % 2 > 0) ? false : true;
    }
}
