package cn.qiushile.leetcode.hard;

import java.util.LinkedList;

/**
 * 980. Unique Paths III
 * Hard
 * 3.6K
 * 150
 * Companies
 * You are given an m x n integer array grid where grid[i][j] could be:
 * 1 representing the starting square. There is exactly one starting square.
 * 2 representing the ending square. There is exactly one ending square.
 * 0 representing empty squares we can walk over.
 * -1 representing obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 * Example 1:
 * Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * Example 2:
 * Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * Output: 4
 * Explanation: We have the following four paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * Example 3:
 * Input: grid = [[0,1],[2,0]]
 * Output: 0
 * Explanation: There is no path that walks over every empty square exactly once.
 * Note that the starting and ending square can be anywhere in the grid.
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 20
 * 1 <= m * n <= 20
 * -1 <= grid[i][j] <= 2
 * There is exactly one starting cell and one ending cell.
 * <p>
 * Runtime 11 ms Beats 8.78% Memory 41.6 MB Beats 42.27%
 *
 * @author qiushile <qiushile@sina.com>
 * @date 2022/12/31
 */
public class Solution0980 {

    private static Integer ans = 0;

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int start = -1;
        int end = -1;
        int num = m * n;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == -1) {
                    num--;
                } else if (grid[i][j] == 1) {
                    start = n * i + j;
                } else if (grid[i][j] == 2) {
                    end = n * i + j;
                }
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        ans = 0;
        dfs(queue, grid, num, end);
        return ans;
    }

    private void dfs(LinkedList<Integer> queue, int[][] grid, int num, int end) {
        int point = queue.getLast();
        if (point == end) {
            if (queue.size() == num) {
                ans++;
                return;
            }
        }
        int n = grid[0].length;
        int pi = point / n;
        int pj = point % n;
        if (pj > 0) {
            int next = pi * n + pj - 1;
            if (grid[pi][pj - 1] != -1 && !queue.contains(next)) {
                queue.add(next);
                dfs(queue, grid, num, end);
                queue.removeLast();
            }
        }
        if (pj < n - 1) {
            int next = pi * n + pj + 1;
            if (grid[pi][pj + 1] != -1 && !queue.contains(next)) {
                queue.add(next);
                dfs(queue, grid, num, end);
                queue.removeLast();
            }
        }
        if (pi > 0) {
            int next = (pi - 1) * n + pj;
            if (grid[pi - 1][pj] != -1 && !queue.contains(next)) {
                queue.add(next);
                dfs(queue, grid, num, end);
                queue.removeLast();
            }
        }
        if (pi < grid.length - 1) {
            int next = (pi + 1) * n + pj;
            if (grid[pi + 1][pj] != -1 && !queue.contains(next)) {
                queue.add(next);
                dfs(queue, grid, num, end);
                queue.removeLast();
            }
        }
    }
}
