package questions.strings;

/*
Given two non-negative integers num1 and num2 represented as strings,
return the product of num1 and num2, also represented as a string.
Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"

Constraints:
1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
public class _43_Multiply_Strings {

    public static void main(String[] args) {

        String s1 = "";
        String s2 = "";
        String resStr = multiply(s1, s2);

        System.out.println(resStr);
    }

    public static String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] ans = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {

                int valIndex = i + j + 1;
                int remainderIndex = i + j;
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                product += ans[valIndex];

                ans[valIndex] = product % 10;

                ans[remainderIndex] += product / 10;
            }
        }
        boolean precedingZeros = true;
        StringBuilder result = new StringBuilder("");

        for (int i = 0; i < ans.length; i++) {

            int value = ans[i];

            if (value != 0) {
                precedingZeros = false;
            }
            if (!precedingZeros) {
                result.append(value);
            }
        }
        return result.toString();
    }

}
