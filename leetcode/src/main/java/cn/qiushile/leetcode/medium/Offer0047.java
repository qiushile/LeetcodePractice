package cn.qiushile.leetcode.medium;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * 示例 1:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * 提示：
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 * 执行用时： 2 ms , 在所有 Java 提交中击败了 97.95% 的用户 内存消耗： 44.1 MB , 在所有 Java 提交中击败了 37.33% 的用户
 * @author qiushile <qiushile@sina.com>
 * @date 2023/3/2
 */
public class Offer0047 {
    public int maxValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int len = Math.min(n, m);
        int diff = Math.max(n, m) - len;
        int[] ans = new int[len];
        ans[0] = grid[0][0];
        int i, j, k;
        for (k = 1; k < len; k++) {
            for (i = 0, j = k - i; i < len && j >= 0; i++, j--) {
                if (i == 0) {
                    ans[j] = ans[j - 1] + grid[i][j];
                } else if (j == 0) {
                    ans[j] = ans[j] + grid[i][j];
                } else {
                    ans[j] = Math.max(ans[j], ans[j - 1]) + grid[i][j];
                }
            }
        }
        if (m > n) {
            for (k = 0; k < diff; k++) {
                for (i = n - 1, j = k + 1; i > 0; i--, j++) {
                    ans[n - i - 1] = Math.max(ans[n - i - 1], ans[n - i]) + grid[i][j];
                }
                ans[n - 1] += grid[i][j];
            }
        } else if (m < n) {
            for (k = 0; k < diff; k++) {
                for (i = k + 1, j = m - 1; j > 0; i++, j--) {
                    ans[j] = Math.max(ans[j], ans[j - 1]) + grid[i][j];
                }
                ans[0] += grid[i][j];
            }
        }
        for (k = 1; k < len; k ++) {
            for (j = m - len + k, i = n - 1; j < m && i > 0; i--, j++) {
                ans[n - i - 1] = Math.max(ans[n - i - 1], ans[n - i]) + grid[i][j];
            }
        }
        return ans[0];
    }
}
