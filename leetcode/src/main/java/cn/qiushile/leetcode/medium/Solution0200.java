package cn.qiushile.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. Number of Islands
 * Medium
 * 18.4K
 * 409
 * Companies
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 * Accepted
 * 2M
 * Submissions
 * 3.6M
 * Acceptance Rate
 * 56.6%
 * Runtime 7 ms Beats 51.2% Memory 50.1 MB Beats 95.38%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/9
 */
public class Solution0200 {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        int mn = m * n;
        Queue<Integer> surr = new LinkedList<>();
        for (int i = 0; i < mn; i++) {
            int x = i % n;
            int y = i / n;
            char v = grid[y][x];
            if (v == '1') {
                ans++;
                surr.add(i);
                grid[y][x] = '2';
                while (!surr.isEmpty()) {
                    int p = surr.poll();
                    int xp = p % n;
                    int yp = p / n;
                    if (xp > 0 && grid[yp][xp - 1] == '1') {
                        surr.add(p - 1);
                        grid[yp][xp - 1] = '2';
                    }
                    if (xp < n - 1 && grid[yp][xp + 1] == '1') {
                        surr.add(p + 1);
                        grid[yp][xp + 1] = '2';
                    }
                    if (yp > 0 && grid[yp - 1][xp] == '1') {
                        surr.add(p - n);
                        grid[yp - 1][xp] = '2';
                    }
                    if (yp < m - 1 && grid[yp + 1][xp] == '1') {
                        surr.add(p + n);
                        grid[yp + 1][xp] = '2';
                    }
                }

            }
        }
        return ans;
    }
}
