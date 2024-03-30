package cn.qiushile.leetcode.hard;

/**
 * 992. Subarrays with K Different Integers
 * Solved
 * Hard
 * Topics
 * Companies
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.
 * A good array is an array where the number of different integers in that array is exactly k.
 * For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
 * A subarray is a contiguous part of an array.
 * Example 1:
 * Input: nums = [1,2,1,2,3], k = 2
 * Output: 7
 * Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
 * Example 2:
 * Input: nums = [1,2,1,3,4], k = 3
 * Output: 3
 * Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 * Constraints:
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i], k <= nums.length
 *
 * Runtime 7 ms Beats 83.96% of users with Java Memory 47.34 MB Beats 41.55% of users with Java
 * @author qiushile <qiushile@sina.com>
 * @date 2024/3/30
 */
public class Solution0992 {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return subMost(nums, k) - subMost(nums, k - 1);
    }

    private int subMost(int[] nums, int k) {
        int n = nums.length;
        int j = 0;
        int ans = 0;
        int[] cnt = new int[n + 1];
        for (int i = 0; i < n; i++) {
            while (k >= 0 & j < n) {
                if (cnt[nums[j]] == 0) {
                    if (k == 0) {
                        break;
                    }
                    k--;
                }
                cnt[nums[j++]]++;
            }
            ans += j - i;
            cnt[nums[i]]--;
            if (cnt[nums[i]] == 0) {
                k++;
            }
        }
        return ans;
    }
}
