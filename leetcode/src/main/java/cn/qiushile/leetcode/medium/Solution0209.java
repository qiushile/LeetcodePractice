package cn.qiushile.leetcode.medium;

/**
 * 209. Minimum Size Subarray Sum
 * Medium
 * 8.5K
 * 234
 * Companies
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 *  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * Constraints:
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 *
 * Runtime 2 ms Beats 67.8% Memory 58.3 MB Beats 19.37%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/3
 */
public class Solution0209 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= target) {
                right = i;
                break;
            }
        }
        if (sum < target) {
            return 0;
        }
        sum -= nums[right];
        int min = right - left + 1;
        for (;right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                sum -= nums[left];
                left++;
            }
            if (min > right - left + 2) {
                min = right - left + 2;
            }
        }

        return min;
    }
}
