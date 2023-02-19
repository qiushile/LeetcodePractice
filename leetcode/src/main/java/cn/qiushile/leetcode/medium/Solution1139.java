package cn.qiushile.leetcode.medium;

/**
 * 1139. Largest 1-Bordered Square
 * Medium
 * 616
 * 94
 * Companies
 * Given a 2D grid of 0s and 1s, return the number of elements in the largest square subgrid that has all 1s on its border, or 0 if such a subgrid doesn't exist in the grid.
 * Example 1:
 * Input: grid = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 9
 * Example 2:
 * Input: grid = [[1,1,0,0]]
 * Output: 1
 * Constraints:
 * 1 <= grid.length <= 100
 * 1 <= grid[0].length <= 100
 * grid[i][j] is 0 or 1
 *
 * @author qiushile <qiushile@sina.com>
 * @date 2023/2/17
 */
public class Solution1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (ans < 1) {
                        ans = 1;
                    }
                    boolean exist = true;
                    int d = ans;
                    int di = i + d;
                    int dj = j + d;
                    for (int k = 1; exist && k <= d; k++) {
                        if (i + k >= n || j + k >= m || grid[i + k][j] != 1 || grid[i][j + k] != 1) {
                            exist = false;
                        }
                    }
                    while (exist) {
                        if (di >= n || dj >=m || grid[di][j] != 1 || grid[i][dj] != 1) {
                            exist = false;
                        }
                        if (!exist) {
                            break;
                        }
                        for (int k = 0; exist && k <= d; k++) {
                            if (grid[di][j + k] != 1 || grid[i + k][dj] != 1) {
                                exist = false;
                            }
                        }
                        d++;
                        di++;
                        dj++;
                        if (exist) {
                            ans = d;
                        } else {
                            exist = true;
                        }
                    }

                }
            }
        }
        return ans * ans;
    }
}
