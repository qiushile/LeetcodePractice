package cn.qiushile.leetcode.contest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 6285. Maximal Score After Applying K Operations
 * User Accepted:6942
 * User Tried:8771
 * Total Accepted:7020
 * Total Submissions:15905
 * Difficulty:Medium
 * You are given a 0-indexed integer array nums and an integer k. You have a starting score of 0.
 * In one operation:
 * choose an index i such that 0 <= i < nums.length,
 * increase your score by nums[i], and
 * replace nums[i] with ceil(nums[i] / 3).
 * Return the maximum possible score you can attain after applying exactly k operations.
 * The ceiling function ceil(val) is the least integer greater than or equal to val.
 * Example 1:
 * Input: nums = [10,10,10,10,10], k = 5
 * Output: 50
 * Explanation: Apply the operation to each array element exactly once. The final score is 10 + 10 + 10 + 10 + 10 = 50.
 * Example 2:
 * Input: nums = [1,10,3,3,3], k = 3
 * Output: 17
 * Explanation: You can do the following operations:
 * Operation 1: Select i = 1, so nums becomes [1,4,3,3,3]. Your score increases by 10.
 * Operation 2: Select i = 1, so nums becomes [1,2,3,3,3]. Your score increases by 4.
 * Operation 3: Select i = 2, so nums becomes [1,1,1,3,3]. Your score increases by 3.
 * The final score is 10 + 4 + 3 = 17.
 * Constraints:
 * 1 <= nums.length, k <= 105
 * 1 <= nums[i] <= 109
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/8
 */
public class Solution6285 {
    public long maxKelements(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.addAll(Arrays.stream(nums).boxed().toList());
        long sum = 0L;
        while (k > 0) {
            Integer v = queue.poll();
            sum += v;
            queue.add(v / 3 + (v % 3 > 0 ? 1 : 0));
            k--;
        }
        return sum;
    }
}
