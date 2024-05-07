package cn.qiushile.leetcode.hard;

import java.util.Arrays;

/**
 * 741. Cherry Pickup
 * Solved
 * Hard
 * Topics
 * Companies
 * You are given an n x n grid representing a field of cherries, each cell is one of three possible integers.
 * 0 means the cell is empty, so you can pass through,
 * 1 means the cell contains a cherry that you can pick up and pass through, or
 * -1 means the cell contains a thorn that blocks your way.
 * Return the maximum number of cherries you can collect by following the rules below:
 * Starting at the position (0, 0) and reaching (n - 1, n - 1) by moving right or down through valid path cells (cells with value 0 or 1).
 * After reaching (n - 1, n - 1), returning to (0, 0) by moving left or up through valid path cells.
 * When passing through a path cell containing a cherry, you pick it up, and the cell becomes an empty cell 0.
 * If there is no valid path between (0, 0) and (n - 1, n - 1), then no cherries can be collected.
 * Example 1:
 * Input: grid = [[0,1,-1],[1,0,-1],[1,1,1]]
 * Output: 5
 * Explanation: The player started at (0, 0) and went down, down, right right to reach (2, 2).
 * 4 cherries were picked up during this single trip, and the matrix becomes [[0,1,-1],[0,0,-1],[0,0,0]].
 * Then, the player went left, up, up, left to return home, picking up one more cherry.
 * The total number of cherries picked up is 5, and this is the maximum possible.
 * Example 2:
 * Input: grid = [[1,1,-1],[1,-1,1],[-1,1,1]]
 * Output: 0
 * Constraints:
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 50
 * grid[i][j] is -1, 0, or 1.
 * grid[0][0] != -1
 * grid[n - 1][n - 1] != -1
 *
 * Runtime 9 ms Beats 97.82% of users with Java Memory 44.15 MB Beats 96.72% of users with Java
 * @author qiushile <qiushile@sina.com>
 * @date 2024/5/7
 */
public class Solution0741 {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MIN_VALUE);
        }
        dp[0][0] = grid[0][0];
        for (int k = 1, left = 0, right = 1; k < n * 2 - 1; k++) {
            for (int y1 = right, x1 = k - y1; y1 >= left; x1++, y1--) {
                for (int y2 = right, x2 = k - y2; y2 >= y1; x2++, y2--) {
                    if (grid[x1][y1] == -1 || grid[x2][y2] == -1) {
                        dp[y1][y2] = Integer.MIN_VALUE;
                        continue;
                    }
                    int v = dp[y1][y2];
                    if (y1 > 0) {
                        v = Math.max(v, Math.max(dp[y1 - 1][y2], dp[y1 - 1][y2 - 1]));
                    }
                    if (y2 > y1) {
                        v = Math.max(v, dp[y1][y2 - 1]);
                    }
                    dp[y1][y2] = v + grid[x1][y1] + (y2 != y1? grid[x2][y2]: 0);
                }
            }
            if (k < n - 1) {
                right++;
            } else {
                left++;
            }
        }
        return Math.max(dp[n - 1][n - 1], 0);
    }
}
