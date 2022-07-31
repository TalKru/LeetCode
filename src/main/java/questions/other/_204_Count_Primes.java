package questions.other;

/*
Given an integer n,
return the number of prime numbers that are strictly less than n.

Example 1:
Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

Example 2:
Input: n = 0
Output: 0

Example 3:
Input: n = 1
Output: 0

Constraints:
0 <= n <= 5 * 10^6
 */
public class _204_Count_Primes {

    public static void main(String[] args) {

        int n = 0;
        int res = countPrimes(n);

        System.out.println("Input: " + n);
        System.out.println("Count_Primes: " + res);
    }

    public static int countPrimes(int n) {

        if (n <= 1) {
            return 0;
        }
        boolean[] notPrime = new boolean[n];

        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;

                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }

}
