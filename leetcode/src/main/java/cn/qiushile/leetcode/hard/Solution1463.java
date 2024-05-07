package cn.qiushile.leetcode.hard;

import java.util.Arrays;

/**
 * 1463. Cherry Pickup II
 * Solved
 * Hard
 * Topics
 * Companies
 * Hint
 * You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] represents the number of cherries that you can collect from the (i, j) cell.
 * You have two robots that can collect cherries for you:
 * Robot #1 is located at the top-left corner (0, 0), and
 * Robot #2 is located at the top-right corner (0, cols - 1).
 * Return the maximum number of cherries collection using both robots by following the rules below:
 * From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
 * When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
 * When both robots stay in the same cell, only one takes the cherries.
 * Both robots cannot move outside of the grid at any moment.
 * Both robots should reach the bottom row in grid.
 * Example 1:
 * Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
 * Output: 24
 * Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
 * Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
 * Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
 * Total of cherries: 12 + 12 = 24.
 * Example 2:
 * Input: grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
 * Output: 28
 * Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
 * Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.
 * Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.
 * Total of cherries: 17 + 11 = 28.
 * Constraints:
 * rows == grid.length
 * cols == grid[i].length
 * 2 <= rows, cols <= 70
 * 0 <= grid[i][j] <= 100
 *
 * Runtime 11 ms Beats 99.22% of users with Java Memory 43.87 MB Beats 98.91% of users with Java
 * @author qiushile <qiushile@sina.com>
 * @date 2024/5/7
 */
public class Solution1463 {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(a[i], -1);
            Arrays.fill(b[i], -1);
        }
        a[0][n - 1] = grid[0][0] + grid[0][n - 1];
        // for (int i = 1; i < (n - 1) / 2 - 1; i++) {
        //     for (int j = i + 1; j < n - i - 1; j++) {
        //         grid[i][j] = 0;
        //     }
        // }
        for (int i = 1; i < m; i++) {
            for (int x = 0; x < n - 1; x++) {
                for (int y = x + 1; y < n; y++) {
                    int v = -1;
                    for (int left = Math.max(0, x - 1); left <= Math.min(x + 1, n - 2); left++) {
                        for (int right = Math.max(left + 1, y - 1); right <= Math.min(y + 1, n - 1); right++) {
                            v = Math.max(v, a[left][right]);
                        }
                    }
                    b[x][y] = v >= 0? v + grid[i][x] + grid[i][y]: -1;
                }
            }
            int[][] t = a;
            a = b;
            b = t;
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = Math.max(ans, a[i][j]);
            }
        }
        return ans;
    }
}
