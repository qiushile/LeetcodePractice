package cn.qiushile.leetcode.medium;

/**
 * 689. Maximum Sum of 3 Non-Overlapping Subarrays
 * Solved
 * Hard
 * Topics
 * Companies
 * Given an integer array nums and an integer k, find three non-overlapping subarrays of length k with maximum sum and return them.
 * Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.
 * Example 1:
 * Input: nums = [1,2,1,2,6,7,5,1], k = 2
 * Output: [0,3,5]
 * Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
 * We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
 * Example 2:
 * Input: nums = [1,2,1,2,1,2,1,2,1], k = 2
 * Output: [0,2,4]
 * Constraints:
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] < 216
 * 1 <= k <= floor(nums.length / 3)
 * Runtime 5 ms Beats 48.72% Memory 45.24 MB Beats 37.18%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/11/19
 */
public class Solution0689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n - k + 1];
        int i = 0;
        for (; i < k; i++) {
            sums[0] += nums[i];
        }
        int[] ml = new int[n - k + 1];
        ml[0] = 0;
        for (i = 1; i <= n - k; i++) {
            sums[i] = sums[i - 1] + nums[i + k - 1] - nums[i - 1];
            ml[i] = sums[ml[i - 1]] >= sums[i]? ml[i - 1]: i;
        }
        int[] mr = new int[n - k + 1];
        mr[n - k] = n - k;
        for (i = n - k - 1; i >= 0; i--) {
            mr[i] = sums[mr[i + 1]] > sums[i]? mr[i + 1]: i;
        }
        int[] ans = new int[3];
        int sum = 0;
        for (i = k; i <= n - k - k; i++) {
            int s = sums[ml[i - k]] + sums[i] + sums[mr[i + k]];
            if (s > sum) {
                ans[0] = ml[i - k];
                ans[1] = i;
                ans[2] = mr[i + k];
                sum = s;
            }
        }
        return ans;
    }
}
