package cn.qiushile.leetcode.medium;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 1482. Minimum Number of Days to Make m Bouquets
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given an integer array bloomDay, an integer m and an integer k.
 * You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
 * The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
 * Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
 * Example 1:
 * Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
 * Output: 3
 * Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
 * We need 3 bouquets each should contain 1 flower.
 * After day 1: [x, _, _, _, _]   // we can only make one bouquet.
 * After day 2: [x, _, _, _, x]   // we can only make two bouquets.
 * After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
 * Example 2:
 * Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
 * Output: -1
 * Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
 * Example 3:
 * Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
 * Output: 12
 * Explanation: We need 2 bouquets each should have 3 flowers.
 * Here is the garden after the 7 and 12 days:
 * After day 7: [x, x, x, x, _, x, x]
 * We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
 * After day 12: [x, x, x, x, x, x, x]
 * It is obvious that we can make two bouquets in different ways.
 * Constraints:
 * bloomDay.length == n
 * 1 <= n <= 105
 * 1 <= bloomDay[i] <= 109
 * 1 <= m <= 106
 * 1 <= k <= n
 *
 * Runtime 740 ms Beats 5.09% Analyze Complexity Memory 61.48 MB Beats 5.64%
 * @author qiushile <qiushile@sina.com>
 * @date 2024/6/19
 */
public class Solution1482 {

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < m * k) {
            return -1;
        }
        TreeSet<Integer> before = new TreeSet<>();
        TreeSet<Integer> after = new TreeSet<>();
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (a, b) -> bloomDay[a] - bloomDay[b]);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            Integer p = ids[i];
            Integer l = p, r = p;
            Integer leftBefore = before.floor(p);
            if (leftBefore != null && after.ceiling(leftBefore).equals(p - 1)) {
                cnt -= (p - leftBefore) / k;
                l = leftBefore;
                after.remove(p - 1);
            }
            Integer rightBefore = before.ceiling(p);
            if (rightBefore != null && rightBefore.equals(p + 1)) {
                Integer rightAfter = after.ceiling(rightBefore);
                cnt -= (rightAfter - p) / k;
                r = rightAfter;
                before.remove(rightBefore);
            }
            before.add(l);
            after.add(r);
            cnt += (r - l + 1) / k;
            if (cnt >= m) {
                return bloomDay[p];
            }
        }
        return -1;
    }
}
