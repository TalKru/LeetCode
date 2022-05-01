package questions.other;

import java.util.ArrayList;
import java.util.List;

/*
A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
A self-dividing number is not allowed to contain the digit zero.

Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right].



Example 1:

Input: left = 1, right = 22
Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]
Example 2:

Input: left = 47, right = 85
Output: [48,55,66,77]


Constraints:

1 <= left <= right <= 104
 */
public class _728_Self_Dividing_Numbers {

    public static void main(String[] args) {

        int left = 47;
        int right = 85;
        System.out.println("Input: " + left + ", " + right);

        List<Integer> res = selfDividingNumbers(left, right);

        System.out.println(res.toString());
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> list = new ArrayList<>();

        for (int i = left, n = 0; i <= right; i++) {

            for (n = i; n > 0; n /= 10) {

                if (n % 10 == 0 || i % (n % 10) != 0) {
                    break;
                }
            }
            if (n == 0) {
                list.add(i);
            }
        }
        return list;
    }
}
