package cn.qiushile.leetcode.contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 6293. Count the Number of Good Subarrays
 * User Accepted:375
 * User Tried:648
 * Total Accepted:375
 * Total Submissions:852
 * Difficulty:Medium
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.
 * A subarray arr is good if it there are at least k pairs of indices (i, j) such that i < j and arr[i] == arr[j].
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * Example 1:
 * Input: nums = [1,1,1,1,1], k = 10
 * Output: 1
 * Explanation: The only good subarray is the array nums itself.
 * Example 2:
 * Input: nums = [3,1,4,3,2,2,4], k = 2
 * Output: 4
 * Explanation: There are 4 different good subarrays:
 * - [3,1,4,3,2,2] that has 2 pairs.
 * - [3,1,4,3,2,2,4] that has 3 pairs.
 * - [1,4,3,2,2,4] that has 2 pairs.
 * - [4,3,2,2,4] that has 2 pairs.
 * Constraints:
 * 1 <= nums.length <= 105
 * 1 <= nums[i], k <= 109
 * NO CLUE
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/15
 */
public class Solution6293 {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long ans = 0L;
        Arrays.sort(nums);

        Map<Integer, Integer> count = new HashMap<>();
        int i = 1;
        int start = 0;
        while (i < n) {
            while (i < n && nums[i] == nums[i - 1]) {
                i++;
            }
            count.put(nums[i - 1], i - start);
            start = i;
            i++;
        }

        Queue<Integer> q =new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));


        return ans;
    }
}
