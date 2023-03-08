package cn.qiushile.leetcode.medium;

import java.util.Arrays;

/**
 * 875. Koko Eating Bananas
 * Medium
 * 6.2K
 * 299
 * Companies
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 * Example 1:
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * Example 2:
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * Example 3:
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 * Constraints:
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 * Runtime 26 ms Beats 61.83% Memory 43 MB Beats 88.72%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/3/8
 */
public class Solution0875 {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;
        int left = 1;
        int right = piles[n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int i = n - 1; i >= 0; i--) {
                count += piles[i] / mid;
                if (piles[i] % mid > 0) {
                    count++;
                }
                if (count > h) {
                    break;
                }
            }
            if (count > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
