package cn.qiushile.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number
 * Easy
 * 7.7K
 * 959
 * Companies
 * Write an algorithm to determine if a number n is happy.
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * Example 1:
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Example 2:
 * Input: n = 2
 * Output: false
 * Constraints:
 * 1 <= n <= 231 - 1
 * Runtime 3 ms Beats 43.61% Memory 41.9 MB Beats 9.49%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/6
 */
public class Solution0202 {
    public boolean isHappy(int n) {
        Set<Integer> exists = new HashSet<>();
        int sum = n;
        while (sum > 0) {
            if (sum == 1) {
                return true;
            }
            if (exists.contains(sum)) {
                return false;
            } else {
                exists.add(sum);
            }
            char[] nums = Integer.toString(sum).toCharArray();
            sum = 0;
            for (char i : nums) {
                int num = i - '0';
                sum += num * num;
            }
        }
        return false;
    }
}
