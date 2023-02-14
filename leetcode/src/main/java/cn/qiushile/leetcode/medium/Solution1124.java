package cn.qiushile.leetcode.medium;

/**
 * 1124. Longest Well-Performing Interval
 * Medium
 * 1.2K
 * 100
 * Companies
 * We are given hours, a list of the number of hours worked per day for a given employee.
 * A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.
 * A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.
 * Return the length of the longest well-performing interval.
 * Example 1:
 * Input: hours = [9,9,6,0,6,6,9]
 * Output: 3
 * Explanation: The longest well-performing interval is [9,9,6].
 * Example 2:
 * Input: hours = [6,6,6]
 * Output: 0
 * Constraints:
 * 1 <= hours.length <= 104
 * 0 <= hours[i] <= 16
 * Runtime 6 ms Beats 100% Memory 42.2 MB Beats 98.51%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/2/14
 */
public class Solution1124 {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int[] sums = new int[n];
        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            hours[i] = hours[i] > 8? 1: -1;
            sum += hours[i];
            sums[i] = sum;
            if (sum > 0) {
                max = i + 1;
            } else {
                int j = i - max - 1;
                while (j >= 0) {
                    int diff = sums[i] - sums[j];
                    if (diff > 0) {
                        max = Math.max(max, i - j);
                        if (j == 0) {
                            break;
                        }
                        j = Math.max(0, j - Math.max(1, diff - 1));
                    } else {
                        j = j - 1 + diff;
                    }
                }
            }
        }
        return max;
    }
}
