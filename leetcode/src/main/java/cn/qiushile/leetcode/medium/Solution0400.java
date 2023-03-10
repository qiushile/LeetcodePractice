package cn.qiushile.leetcode.medium;

/**
 * 400. Nth Digit
 * Medium
 * 849
 * 1.8K
 * Companies
 * Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].
 * Example 1:
 * Input: n = 3
 * Output: 3
 * Example 2:
 * Input: n = 11
 * Output: 0
 * Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 * Constraints:
 * 1 <= n <= 231 - 1
 * Runtime 0 ms Beats 100% Memory 39.4 MB Beats 25%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/3/10
 */
public class Solution0400 {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        long ten = 1;
        long i = 1;
        long diff = 9;
        long sum = 9;
        while(n > sum) {
            ten *= 10;
            i++;
            diff = ten * 9 * i;
            sum += diff;
        }
        sum -= diff;
        n -= sum;
        int num = (int) (ten + (n - 1) / i);
        int index = (int) ((n - 1) % i);
        return Integer.parseInt(String.valueOf(num).substring(index, index + 1));
    }
}
