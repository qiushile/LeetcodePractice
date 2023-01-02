package cn.qiushile.leetcode.easy;

/**
 * 724. Find Pivot Index
 * Easy
 * 5.8K
 * 613
 * Companies
 * Given an array of integers nums, calculate the pivot index of this array.
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
 * Return the leftmost pivot index. If no such index exists, return -1.
 * Example 1:
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 * Explanation:
 * The pivot index is 3.
 * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
 * Right sum = nums[4] + nums[5] = 5 + 6 = 11
 * Example 2:
 * Input: nums = [1,2,3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 * Example 3:
 * Input: nums = [2,1,-1]
 * Output: 0
 * Explanation:
 * The pivot index is 0.
 * Left sum = 0 (no elements to the left of index 0)
 * Right sum = nums[1] + nums[2] = 1 + -1 = 0
 * Constraints:
 * 1 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 *
 * Runtime 1 ms Beats 100% Memory 42.6 MB Beats 97.39%
 *
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/2
 */
public class Solution0724 {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] leftSum = new int[len];
        int[] rightSum = new int[len];
        leftSum[0] = nums[0];
        rightSum[len - 1] = nums[len - 1];
        for (int i = 1; i < len; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i];
            rightSum[len - i - 1] = rightSum[len - i] + nums[len - i - 1];
        }
        if (len <= 1 || rightSum[1] == 0) {
            return 0;
        }
        for (int i = 1; i < len - 1; i++) {
            if (leftSum[i - 1] == rightSum[i + 1]) {
                return i;
            }
        }
        if (leftSum[len - 2] == 0) {
            return len - 1;
        }
        return -1;
    }
}
