package cn.qiushile.leetcode.hard;

import java.util.Arrays;

/**
 * 1335. Minimum Difficulty of a Job Schedule
 * Hard
 * 2.5K
 * 228
 * Companies
 * You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, you have to finish all the jobs j where 0 <= j < i).
 * You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done on that day.
 * You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].
 * Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
 * Example 1:
 * Input: jobDifficulty = [6,5,4,3,2,1], d = 2
 * Output: 7
 * Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
 * Second day you can finish the last job, total difficulty = 1.
 * The difficulty of the schedule = 6 + 1 = 7
 * Example 2:
 * Input: jobDifficulty = [9,9,9], d = 4
 * Output: -1
 * Explanation: If you finish a job per day you will still have a free day. you cannot find a schedule for the given jobs.
 * Example 3:
 * Input: jobDifficulty = [1,1,1], d = 3
 * Output: 3
 * Explanation: The schedule is one job per day. total difficulty will be 3.
 * Constraints:
 * 1 <= jobDifficulty.length <= 300
 * 0 <= jobDifficulty[i] <= 1000
 * 1 <= d <= 10
 * Runtime 9 ms Beats 83.89% Memory 40.7 MB Beats 43.84%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/5/16
 */
public class Solution1335 {

    public int minDifficulty(int[] jobs, int d) {
        int n = jobs.length;
        if (n < d) {
            return -1;
        } else if (d == n) {
            return Arrays.stream(jobs).sum();
        } else if (d == 1) {
            return Arrays.stream(jobs).max().getAsInt();
        }
        int[][] dp = new int[d + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[1][i] = Math.max(dp[1][i - 1], jobs[i - 1]);
        }
        for (int i = 2; i <= d; i++) {
            for (int j = i; j <= n; j++) {
                int max = jobs[j - 1];
                dp[i][j] = dp[i - 1][j - 1] + max;
                for (int k = j - 1; k >= i; k--) {
                    max = Math.max(max, jobs[k - 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k - 1] + max);
                }
            }
        }
        return dp[d][n];
    }
}
