package cn.qiushile.leetcode.medium;

/**
 * 840. Magic Squares In Grid
 * Solved
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
 * Given a row x col grid of integers, how many 3 x 3 magic square subgrids are there?
 * Note: while a magic square can only contain numbers from 1 to 9, grid may contain numbers up to 15.
 * Example 1:
 * Input: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]
 * Output: 1
 * Explanation:
 * The following subgrid is a 3 x 3 magic square:
 * while this one is not:
 * In total, there is only one magic square inside the given grid.
 * Example 2:
 * Input: grid = [[8]]
 * Output: 0
 * Constraints:
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 10
 * 0 <= grid[i][j] <= 15
 *
 * Runtime 0 ms Beats 100.00% Memory 43.45 MB Beats 22.16%
 * @author qiushile <qiushile@sina.com>
 * @date 2025/12/30
 */
public class Solution0840 {
    private int[] ma = new int[]{0, 6, 9, 8, 3, 0, 7, 2, 1, 4}, mb = new int[]{0, 8, 7, 4, 9, 0, 1, 6, 3, 2};
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length, m = grid[0].length, ans = 0;
        // boolean[] vs = new boolean[10];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] != 5 || grid[i - 1][j - 1] < 1 || grid[i - 1][j - 1] > 9 || grid[i - 1][j - 1] % 2 == 1) {
                    continue;
                }
                int[] mc = new int[]{grid[i - 1][j - 1], grid[i - 1][j], grid[i - 1][j + 1], grid[i][j + 1],
                    grid[i + 1][j + 1], grid[i + 1][j], grid[i + 1][j - 1], grid[i][j - 1]};
                int[] md = ma[mc[0]] == mc[1]? ma: mb[mc[0]] == mc[1]? mb: new int[0];
                if (md.length == 0) {
                    continue;
                }
                boolean matched = true;
                for (int k = 1; k < 7; k++) {
                    if (mc[k] < 1 || mc[k] > 9 || md[mc[k]] != mc[k + 1]) {
                        matched = false;
                    }
                }
                if (matched) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
