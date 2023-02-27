package cn.qiushile.leetcode.medium;

/**
 * 1144. Decrease Elements To Make Array Zigzag
 * Medium
 * 374
 * 157
 * Companies
 * Given an array nums of integers, a move consists of choosing any element and decreasing it by 1.
 * An array A is a zigzag array if either:
 * Every even-indexed element is greater than adjacent elements, ie. A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * OR, every odd-indexed element is greater than adjacent elements, ie. A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * Return the minimum number of moves to transform the given array nums into a zigzag array.
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: 2
 * Explanation: We can decrease 2 to 0 or 3 to 1.
 * Example 2:
 * Input: nums = [9,6,1,6,2]
 * Output: 4
 * Constraints:
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 * Runtime 0 ms Beats 100% Memory 40.3 MB Beats
 * @author qiushile <qiushile@sina.com>
 * @date 2023/2/27
 */
public class Solution1144 {
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return nums[0] == nums[1]? 1: 0;
        }
        int even = nums[0] >= nums[1]? nums[0] - nums[1] + 1: 0;
        int min = Math.min(nums[0], nums[2]);
        int odd = min > nums[1]? 0: nums[1] - min + 1;
        for (int i = 2; i < n - 2; i += 2) {
            min = Math.min(nums[i - 1], nums[i + 1]);
            if (nums[i] >= min) {
                even += nums[i] - min + 1;
            }
            min = Math.min(nums[i], nums[i + 2]);
            if (nums[i + 1] >= min) {
                odd += nums[i + 1] - min + 1;
            }
        }
        if (n % 2 == 1) {
            if (nums[n - 1] >= nums[n - 2]) {
                even += nums[n - 1] - nums[n - 2] + 1;
            }
        } else {
            min = Math.min(nums[n - 1], nums[n - 3]);
            if (min <= nums[n - 2]) {
                even += nums[n - 2] - min + 1;
            }
            if (nums[n - 1] >= nums[n - 2]) {
                odd += nums[n - 1] - nums[n - 2] + 1;
            }
        }
        return Math.min(even, odd);
    }
}
