package cn.qiushile.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 279. Perfect Squares
 * Medium
 * 8.9K
 * 389
 * Companies
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 * Example 1:
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 * Constraints:
 * 1 <= n <= 104
 * Accepted
 * 635.8K
 * Submissions
 * 1.2M
 * Acceptance Rate
 * 52.6%
 * Runtime 19 ms Beats 91.27% Memory 42.7 MB Beats 66.59%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/9
 */
public class Solution0279 {

    private static Map<Integer, Integer> counts = new HashMap<>(10000);
    private static int point = 6;

    static {
        for (int i = 1; i < 100; i++) {
            counts.put(i * i, 1);
            counts.put(i * i + 1, 2);
        }
        counts.put(3, 3);
        counts.put(6, 3);
        counts.put(10000, 1);
    }

    public int getCount(int n) {
        if (n > point) {
            for (int i = point + 1; i <= n; i++) {
                if (!counts.containsKey(i)) {
                    int sqrt = (int) Math.sqrt(i);
                    int min = counts.get(i - 1) + 1;
                    for (int j = 2; j <= sqrt; j++) {
                        min = Math.min(min, counts.get(i - j * j) + 1);
                    }
                    counts.put(i, min);
                }
            }
        }
        return counts.get(n);
    }

    public int numSquares(int n) {
        return getCount(n);
    }
}
