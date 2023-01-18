package cn.qiushile.leetcode.medium;

/**
 * 918. Maximum Sum Circular Subarray
 * Medium
 * 4.8K
 * 214
 * Companies
 * Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
 * A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
 * A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
 * Example 1:
 * Input: nums = [1,-2,3,-2]
 * Output: 3
 * Explanation: Subarray [3] has maximum sum 3.
 * Example 2:
 * Input: nums = [5,-3,5]
 * Output: 10
 * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
 * Example 3:
 * Input: nums = [-3,-2,-3]
 * Output: -2
 * Explanation: Subarray [-2] has maximum sum -2.
 * Constraints:
 * n == nums.length
 * 1 <= n <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Runtime 7 ms Beats 44.30% Memory 47.5 MB Beats 73.37%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/18
 */
public class Solution0918 {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int allSum = nums[0];
        int positiveAns = nums[0];
        int positiveSum = -30001;
        int positiveStart = -1;
        int negativeAns = nums[0];
        int negativeSum = 30001;
        int negativeStart = -1;
        if (nums[0] > 0) {
            positiveSum = nums[0];
            positiveStart = 0;
        }
        if (nums[0] < 0) {
            negativeSum = nums[0];
            negativeStart = 0;
        }
        for (int i = 1; i < n; i++) {
            allSum += nums[i];

            if (nums[i] >= 0 && nums[i - 1] < 0) {
                if (positiveSum >= 0) {
                    positiveSum = positiveSum + nums[i];
                } else {
                    positiveSum = nums[i];
                    positiveStart = i;
                }
            } else if (positiveStart != -1) {
                positiveSum = positiveSum + nums[i];
            }
            positiveAns = Math.max(positiveAns, nums[i]);
            positiveAns = Math.max(positiveAns, positiveSum);

            if (nums[i] <= 0 && nums[i - 1] > 0) {
                if (negativeSum < 0) {
                    negativeSum = negativeSum + nums[i];
                } else {
                    negativeSum = nums[i];
                    negativeStart = i;
                }
            } else if (negativeStart != -1) {
                negativeSum = negativeSum + nums[i];
            }
            negativeAns = Math.min(negativeAns, nums[i]);
            negativeAns = Math.min(negativeAns, negativeSum);
        }
        if (negativeStart != 0) {
            return Math.max(positiveAns, allSum - negativeAns);
        } else {
            return positiveAns;
        }
    }
}
