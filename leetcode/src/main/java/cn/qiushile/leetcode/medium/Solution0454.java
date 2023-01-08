package cn.qiushile.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 4Sum II
 * Medium
 * 4.3K
 * 125
 * Companies
 * Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * Example 1:
 * Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * Output: 2
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * Example 2:
 * Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * Output: 1
 * Constraints:
 * n == nums1.length
 * n == nums2.length
 * n == nums3.length
 * n == nums4.length
 * 1 <= n <= 200
 * -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
 * Accepted
 * 282.5K
 * Submissions
 * 493.1K
 * Acceptance Rate
 * 57.3%
 * Runtime 218 ms Beats 51.32% Memory 42.5 MB Beats 72.86%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/8
 */
public class Solution0454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int sum;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                sum = nums1[i] + nums2[j];
                if (map1.containsKey(sum)) {
                    map1.put(sum, map1.get(sum) + 1);
                } else {
                    map1.put(sum, 1);
                }
            }
        }
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                sum = nums3[i] + nums4[j];
                if (map2.containsKey(sum)) {
                    map2.put(sum, map2.get(sum) + 1);
                } else {
                    map2.put(sum, 1);
                }
            }
        }
        sum = 0;
        Map<Integer, Integer> shortMap = map1.size() < map2.size() ? map1: map2;
        Map<Integer, Integer> longMap = map1.size() < map2.size() ? map2: map1;
        for (Map.Entry<Integer, Integer> entry : shortMap.entrySet()) {
            if (longMap.containsKey(-entry.getKey())) {
                sum += longMap.get(-entry.getKey()) * entry.getValue();
            }
        }
        return sum;
    }
}
