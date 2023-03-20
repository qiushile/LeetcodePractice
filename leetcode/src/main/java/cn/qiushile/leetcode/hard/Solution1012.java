package cn.qiushile.leetcode.hard;

import java.util.Arrays;

/**
 * 1012. Numbers With Repeated Digits
 * Hard
 * 591
 * 71
 * Companies
 * Given an integer n, return the number of positive integers in the range [1, n] that have at least one repeated digit.
 * Example 1:
 * Input: n = 20
 * Output: 1
 * Explanation: The only positive number (<= 20) with at least 1 repeated digit is 11.
 * Example 2:
 * Input: n = 100
 * Output: 10
 * Explanation: The positive numbers (<= 100) with atleast 1 repeated digit are 11, 22, 33, 44, 55, 66, 77, 88, 99, and 100.
 * Example 3:
 * Input: n = 1000
 * Output: 262
 * Constraints:
 * 1 <= n <= 109
 * Runtime 1 ms Beats 86.27% Memory 39.5 MB Beats 68.63%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/3/20
 */
public class Solution1012 {
    public int numDupDigitsAtMostN(int n) {
        n++;
        boolean[] exist = new boolean[10];
        Arrays.fill(exist, false);
        String num = String.valueOf(n);
        // assume the n match the requirement
        int ans = 0;
        int len = num.length();
        for (int i = 0; i < len - 1; i++) {
            ans += 9 * calc(9, i);
        }
        for (int i = 0; i < len; i++) {
            int curr = num.charAt(i) - '0';
            int add = calc(9 - i, len - i - 1);
            for (int j = (i == 0? 1: 0); j < curr; j++) {
                if (!exist[j]) {
                    ans += add;
                }
            }
            if (exist[curr]) {
                break;
            }
            exist[curr] = true;
        }
        return n - 1 - ans ;
    }

    private int calc(int start, int times) {
        int ans = 1;
        for (; times > 0; times--, start--) {
            ans *= start;
        }
        return ans;
    }
}
