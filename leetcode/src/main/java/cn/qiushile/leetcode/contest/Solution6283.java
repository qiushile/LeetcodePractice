package cn.qiushile.leetcode.contest;

/**
 * 6283. Maximum Count of Positive Integer and Negative Integer
 * User Accepted:10325
 * User Tried:10474
 * Total Accepted:10591
 * Total Submissions:12672
 * Difficulty:Easy
 * Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.
 * In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.
 * Note that 0 is neither positive nor negative.
 * Example 1:
 * Input: nums = [-2,-1,-1,1,2,3]
 * Output: 3
 * Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.
 * Example 2:
 * Input: nums = [-3,-2,-1,0,0,1,2]
 * Output: 3
 * Explanation: There are 2 positive integers and 3 negative integers. The maximum count among them is 3.
 * Example 3:
 * Input: nums = [5,20,66,1314]
 * Output: 4
 * Explanation: There are 4 positive integers and 0 negative integers. The maximum count among them is 4.
 * Constraints:
 * 1 <= nums.length <= 2000
 * -2000 <= nums[i] <= 2000
 * nums is sorted in a non-decreasing order.
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/8
 */
public class Solution6283 {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        if (nums[0] > 0 || nums[n - 1] < 0) {
            return n;
        }
        int ans = 0;
        int start = 0;
        int end = n - 1;
        int middle = 0;
        // find negative next to non-negative
        while (start <= end) {
            middle = (end + start) >>> 1;
            if (nums[middle] < 0) {
                start = middle + 1;
            } else if (nums[middle] >= 0) {
                end = middle - 1;
            }
        }
        ans = start;
        end = n - 1;
        // find positive next to non-positive
        while (start <= end) {
            middle = (end + start) >>> 1;
            if (nums[middle] <= 0) {
                start = middle + 1;
            } else if (nums[middle] > 0) {
                end = middle - 1;
            }
        }
        if (ans < n - start) {
            ans = n - start;
        }

        return ans;
    }
}
