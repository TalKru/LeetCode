package questions.other;
/*
The Tribonacci sequence Tn is defined as follows:

T0 = 0, T1 = 1, T2 = 1,
and
Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

Example 1:
Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4

Example 2:
Input: n = 25
Output: 1389537

Constraints:
0 <= n <= 37
The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
 */
public class _1137_TRIbonacci_Number {

    public static void main(String[] args) {

        int n = 34;
        System.out.println("Tribonacci value of T(" + n + ") = " + tribonacci(n));
    }

    public static int tribonacci(int n) {

        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int n1 = 0;
        int n2 = 1;
        int n3 = 1;
        int res = 0;

        for (int i = 3; i <= n ; i++) {

            res = n1 + n2 + n3;
            n1 = n2;
            n2 = n3;
            n3 = res;
        }
        return res;
    }

    public static int tribonacci2(int n) {

        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

}
