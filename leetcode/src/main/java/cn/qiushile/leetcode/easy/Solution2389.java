package cn.qiushile.leetcode.easy;

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
 * @author qiushile <qiushile@sina.com>
 * @date 2022/12/25
 */
public class Solution2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int maxNum = 0;
        int n = nums.length;
        int m = queries.length;
        for (int i = 0; i < m; i++) {
            if (queries[i] > maxNum) {
                maxNum = queries[i];
            }
        }
        int[] ans = new int[maxNum + 1];
        int[][] calc = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            calc[i][i] = nums[i];
            if (nums[i] <= maxNum && ans[nums[i]] < 1) {
                ans[nums[i]] = 1;
            }
        }
        int sum;
        for (int i = 0; i < n; i++) {
            sum = calc[i][i];
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                if (sum > maxNum) {
                    break;
                }
                calc[i][j] = sum;
                if (ans[sum] < j - i + 1) {
                    ans[sum] = j - i + 1;
                }
            }
        }
        for (int i = 1; i < ans.length; i++) {
            if (ans[i] < ans[i - 1]) {
                ans[i] = ans[i - 1];
            }
        }
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            result[i] = ans[queries[i]];
        }
        return result;
    }
}
