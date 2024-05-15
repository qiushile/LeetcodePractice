package cn.qiushile.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 2812. Find the Safest Path in a Grid
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given a 0-indexed 2D matrix grid of size n x n, where (r, c) represents:
 * A cell containing a thief if grid[r][c] = 1
 * An empty cell if grid[r][c] = 0
 * You are initially positioned at cell (0, 0). In one move, you can move to any adjacent cell in the grid, including cells containing thieves.
 * The safeness factor of a path on the grid is defined as the minimum manhattan distance from any cell in the path to any thief in the grid.
 * Return the maximum safeness factor of all paths leading to cell (n - 1, n - 1).
 * An adjacent cell of cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) and (r - 1, c) if it exists.
 * The Manhattan distance between two cells (a, b) and (x, y) is equal to |a - x| + |b - y|, where |val| denotes the absolute value of val.
 * Example 1:
 * Input: grid = [[1,0,0],[0,0,0],[0,0,1]]
 * Output: 0
 * Explanation: All paths from (0, 0) to (n - 1, n - 1) go through the thieves in cells (0, 0) and (n - 1, n - 1).
 * Example 2:
 * Input: grid = [[0,0,1],[0,0,0],[0,0,0]]
 * Output: 2
 * Explanation: The path depicted in the picture above has a safeness factor of 2 since:
 * - The closest cell of the path to the thief at cell (0, 2) is cell (0, 0). The distance between them is | 0 - 0 | + | 0 - 2 | = 2.
 * It can be shown that there are no other paths with a higher safeness factor.
 * Example 3:
 * Input: grid = [[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]
 * Output: 2
 * Explanation: The path depicted in the picture above has a safeness factor of 2 since:
 * - The closest cell of the path to the thief at cell (0, 3) is cell (1, 2). The distance between them is | 0 - 1 | + | 3 - 2 | = 2.
 * - The closest cell of the path to the thief at cell (3, 0) is cell (3, 2). The distance between them is | 3 - 3 | + | 0 - 2 | = 2.
 * It can be shown that there are no other paths with a higher safeness factor.
 * Constraints:
 * 1 <= grid.length == n <= 400
 * grid[i].length == n
 * grid[i][j] is either 0 or 1.
 * There is at least one thief in the grid.
 *
 * Runtime 336 ms Beats 14.76% of users with Java Memory 69.72 MB Beats 39.34% of users with Java
 * @author qiushile <qiushile@sina.com>
 * @date 2024/5/15
 */
public class Solution2812 {

    private int[] dd = new int[]{0, 1, 0, -1, 0};
    private int n = 0;

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        n = grid.size();
        if (grid.get(0).get(0).equals(1) || grid.get(n - 1).get(n - 1).equals(1)) {
            return 0;
        }
        int[][] ds = new int[n][n];
        for (int[] d : ds) {
            Arrays.fill(d, -1);
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j).equals(1)) {
                    ds[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        int len = q.size();
        int max = 1;
        while (!q.isEmpty()) {
            int[] c = q.poll();
            int x = c[0], y = c[1];
            for (int i = 0; i < 4; i++) {
                int a = x + dd[i], b = y + dd[i + 1];
                if (a >= 0 && a < n && b >= 0 && b < n && ds[a][b] == -1) {
                    ds[a][b] = max;
                    q.offer(new int[]{a, b});
                }
            }
            if (--len == 0) {
                len = q.size();
                max++;
            }
        }
        max--;
        int min = 0;
        max = Math.min(max, Math.min(ds[0][0], ds[n - 1][n - 1]));
        max = Math.min(max, Math.min(Math.max(ds[0][1], ds[1][0]), Math.max(ds[n - 1][n - 2], ds[n - 2][n - 1])));
        while (min < max) {
            int mid = max - (max - min) / 2;
            if (pass(ds, mid)) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }
        return min;
    }

    private boolean pass(int[][] ds, int min) {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> vs = new HashSet<>();
        q.offer(new int[]{0, 0});
        vs.add(0);
        while (!q.isEmpty()) {
            int[] c = q.poll();
            int x = c[0], y = c[1];
            if (x == n - 1 && y == n - 1) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int a = x + dd[i], b = y + dd[i + 1];
                if (a >= 0 && a < n && b >= 0 && b < n && ds[a][b] >= min && !vs.contains(a * n + b)) {
                    vs.add(a * n + b);
                    q.offer(new int[]{a, b});
                }
            }
        }

        return false;
    }
}
