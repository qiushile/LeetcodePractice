package cn.qiushile.leetcode.medium;

/**
 * 974. Subarray Sums Divisible by K
 * Medium
 * 4.6K
 * 178
 * Companies
 * Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
 * A subarray is a contiguous part of an array.
 * Example 1:
 * Input: nums = [4,5,0,-2,-3,1], k = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by k = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * Example 2:
 * Input: nums = [5], k = 9
 * Output: 0
 * Constraints:
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * 2 <= k <= 104
 * Runtime 4 ms Beats 92.83% Memory 45.8 MB Beats 94.64%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/19
 */
public class Solution0974 {
    public int subarraysDivByK(int[] nums, int k) {
        int[] mods = new int[k];
        mods[0] = 1;
        int md = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            md = (md + nums[i] % k + k) % k;
            ans += mods[md];
            mods[md]++;
        }
        return ans;
    }
}
