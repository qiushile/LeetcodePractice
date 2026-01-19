package cn.qiushile.leetcode.medium;

/**
 *
 * 1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold
 * Solved
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * Given a m x n matrix mat and an integer threshold, return the maximum side-length of a square with a sum less than or equal to threshold or return 0 if there is no such square.
 * Example 1:
 * Input: mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
 * Output: 2
 * Explanation: The maximum side length of square with sum less than 4 is 2 as shown.
 * Example 2:
 * Input: mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
 * Output: 0
 * Constraints:
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 300
 * 0 <= mat[i][j] <= 104
 * 0 <= threshold <= 105
 *
 * Runtime 8 ms Beats 45.69% Memory 57.65 MB Beats 58.38%
 *
 * @author qiushile <qiushile@sina.com>
 * @date 2026/1/19
 */
public class Solution1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length, mn = Math.min(m, n), ans = 0;
        int[][] ms = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ms[i][j] = ms[i - 1][j] + ms[i][j - 1] - ms[i - 1][j - 1] + mat[i - 1][j - 1];
                for (int k = ans + 1; k <= mn; k++) {
                    int a = i - k, b = j - k;
                    if (a >= 0 && b >= 0 && ms[i][j] - ms[a][j] - ms[i][b] + ms[a][b] <= threshold) {
                        ans++;
                    } else {
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
