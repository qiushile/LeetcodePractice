package cn.qiushile.leetcode.hard;

import java.util.PriorityQueue;

/**
 * 2617. Minimum Number of Visited Cells in a Grid
 * Solved
 * Hard
 * Topics
 * Companies
 * Hint
 * You are given a 0-indexed m x n integer matrix grid. Your initial position is at the top-left cell (0, 0).
 * Starting from the cell (i, j), you can move to one of the following cells:
 * Cells (i, k) with j < k <= grid[i][j] + j (rightward movement), or
 * Cells (k, j) with i < k <= grid[i][j] + i (downward movement).
 * Return the minimum number of cells you need to visit to reach the bottom-right cell (m - 1, n - 1). If there is no valid path, return -1.
 * Example 1:
 * Input: grid = [[3,4,2,1],[4,2,3,1],[2,1,0,0],[2,4,0,0]]
 * Output: 4
 * Explanation: The image above shows one of the paths that visits exactly 4 cells.
 * Example 2:
 * Input: grid = [[3,4,2,1],[4,2,1,1],[2,1,1,0],[3,4,1,0]]
 * Output: 3
 * Explanation: The image above shows one of the paths that visits exactly 3 cells.
 * Example 3:
 * Input: grid = [[2,1,0],[1,0,0]]
 * Output: -1
 * Explanation: It can be proven that no path exists.
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * 0 <= grid[i][j] < m * n
 * grid[m - 1][n - 1] == 0
 *
 * Runtime 83 ms Beats 91.67% of users with Java Memory 78.83 MB Beats 69.44% of users with Java
 * @author qiushile <qiushile@sina.com>
 * @date 2024/3/22
 */
public class Solution2617 {
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 && n == 1) {
            return 1;
        }
        if (grid[0][0] == 0) {
            return -1;
        }
        int max = m * n + 1;
        PriorityQueue<int[]>[] qm = new PriorityQueue[m];
        PriorityQueue<int[]>[] qn = new PriorityQueue[n];
        for (int i = 0; i < m; i++) {
            qm[i] = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        }
        for (int i = 0; i < n; i++) {
            qn[i] = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        }
        int[] init = new int[]{1, grid[0][0]};
        qm[0].offer(init);
        qn[0].offer(init);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int v = grid[i][j];
                int min = max;
                while (!qm[i].isEmpty() && qm[i].peek()[1] < j) {
                    qm[i].poll();
                }
                if (!qm[i].isEmpty()) {
                    min = qm[i].peek()[0];
                }
                while (!qn[j].isEmpty() && qn[j].peek()[1] < i) {
                    qn[j].poll();
                }
                if (!qn[j].isEmpty()) {
                    min = Math.min(min, qn[j].peek()[0]);
                }
                if (min < max) {
                    grid[i][j] = min + 1;
                    if (v > 0) {
                        qm[i].offer(new int[]{grid[i][j], j + v});
                        qn[j].offer(new int[]{grid[i][j], i + v});
                    }
                } else {
                    grid[i][j] = -1;
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
