package cn.qiushile.leetcode.easy;

import java.util.Arrays;

/**
 * 2389. Longest Subsequence With Limited Sum
 * You are given an integer array nums of length n, and an integer array queries of length m.
 * Return an array answer of length m where answer[i] is the maximum size of a subsequence that you can take from nums such that the sum of its elements is less than or equal to queries[i].
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 * Example 1:
 * Input: nums = [4,5,2,1], queries = [3,10,21]
 * Output: [2,3,4]
 * Explanation: We answer the queries as follows:
 * - The subsequence [2,1] has a sum less than or equal to 3. It can be proven that 2 is the maximum size of such a subsequence, so answer[0] = 2.
 * - The subsequence [4,5,1] has a sum less than or equal to 10. It can be proven that 3 is the maximum size of such a subsequence, so answer[1] = 3.
 * - The subsequence [4,5,2,1] has a sum less than or equal to 21. It can be proven that 4 is the maximum size of such a subsequence, so answer[2] = 4.
 * Example 2:
 * Input: nums = [2,3,4,5], queries = [1]
 * Output: [0]
 * Explanation: The empty subsequence is the only subsequence that has a sum less than or equal to 1, so answer[0] = 0.
 * Constraints:
 * n == nums.length
 * m == queries.length
 * 1 <= n, m <= 1000
 * 1 <= nums[i], queries[i] <= 106
 *
 * Runtime 5 ms Beats 89.6% Memory 43.3 MB Beats 27.90%
 * @author qiushile <qiushile@sina.com>
 * @date 2022/12/25
 */
public class Solution2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }

        int[] sorted = new int[m];
        for (int i = 0; i < m; i++) {
            sorted[i] = i;
        }
        quickSort(queries, 0, m - 1, sorted);

        int[] ans = new int[m];
        int numsIndex = 0;
        int queriesIndex = 0;
        while (queriesIndex < m) {
            while (numsIndex < n && queries[queriesIndex] >= nums[numsIndex]) {
                numsIndex++;
            }
            ans[sorted[queriesIndex]] = numsIndex;
            queriesIndex++;
        }
        return ans;
    }

    /**
     * This method is copied from https://www.cnblogs.com/zhaoke271828/p/14731184.html
     * @param keys
     * @param begin
     * @param end
     * @param indices
     */
    private static void quickSort(int[] keys, int begin, int end, int[] indices) {
        if (begin >= 0 && begin < keys.length && end >= 0 && end < keys.length && begin < end) {
            int i = begin, j = end;
            int vot = keys[i];
            int temp = indices[i];
            while (i != j) {
                while (i < j && keys[j] >= vot) {
                    j--;
                }
                if(i < j) {
                    keys[i] = keys[j];
                    indices[i] = indices[j];
                    i++;
                }
                while(i < j && keys[i] <= vot) {
                    i++;
                }
                if(i < j) {
                    keys[j] = keys[i];
                    indices[j] = indices[i];
                    j--;
                }
            }
            keys[i] = vot;
            indices[i] = temp;
            quickSort(keys, begin, j-1, indices);
            quickSort(keys, i+1, end, indices);
        }
    }
}
