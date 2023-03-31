package cn.qiushile.leetcode.hard;

/**
 * 1444. Number of Ways of Cutting a Pizza
 * Hard
 * 1.3K
 * 77
 * Companies
 * Given a rectangular pizza represented as a rows x cols matrix containing the following characters: 'A' (an apple) and '.' (empty cell) and given the integer k. You have to cut the pizza into k pieces using k-1 cuts.
 * For each cut you choose the direction: vertical or horizontal, then you choose a cut position at the cell boundary and cut the pizza into two pieces. If you cut the pizza vertically, give the left part of the pizza to a person. If you cut the pizza horizontally, give the upper part of the pizza to a person. Give the last piece of pizza to the last person.
 * Return the number of ways of cutting the pizza such that each piece contains at least one apple. Since the answer can be a huge number, return this modulo 10^9 + 7.
 * Example 1:
 * Input: pizza = ["A..","AAA","..."], k = 3
 * Output: 3
 * Explanation: The figure above shows the three ways to cut the pizza. Note that pieces must contain at least one apple.
 * Example 2:
 * Input: pizza = ["A..","AA.","..."], k = 3
 * Output: 1
 * Example 3:
 * Input: pizza = ["A..","A..","..."], k = 1
 * Output: 1
 * Constraints:
 * 1 <= rows, cols <= 50
 * rows == pizza.length
 * cols == pizza[i].length
 * 1 <= k <= 10
 * pizza consists of characters 'A' and '.' only.
 * Runtime 17 ms Beats 12.42% Memory 40.1 MB Beats 68.87%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/4/1
 */
public class Solution1444 {
    public int ways(String[] pizza, int k) {
        int mod = 1000000007;
        int n = pizza.length;
        int m = pizza[0].length();
        int[][] s = new int[n][m];
        if (pizza[0].charAt(0) == 'A') {
            s[0][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            s[i][0] = s[i - 1][0] + (pizza[i].charAt(0) == 'A'? 1: 0);
        }
        for (int i = 1; i < m; i++) {
            s[0][i] = s[0][i - 1] + (pizza[0].charAt(i) == 'A'? 1: 0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + (pizza[i].charAt(j) == 'A'? 1: 0);
            }
        }
        if (s[n - 1][m - 1] < k) {
            return 0;
        }
        int[][][] dp = new int[n][m][k + 1];
        dp[0][0][1] = 1;
        for (int x = 2; x <= k; x++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dp[i][j][x - 1] == 0) {
                        continue;
                    }
                    for (int p = i + 1; p < n; p++) {
                        if (exist(s, i, j, p - 1, m - 1) && exist(s, p, j, n - 1, m - 1)) {
                            dp[p][j][x] += dp[i][j][x - 1];
                            dp[p][j][x] %= mod;
                        }
                    }
                    for (int p = j + 1; p < m; p++) {
                        if (exist(s, i, j, n - 1, p - 1) && exist(s, i, p, n - 1, m - 1)) {
                            dp[i][p][x] += dp[i][j][x - 1];
                            dp[i][p][x] %= mod;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += dp[i][j][k];
                ans %= mod;
            }
        }
        return ans;
    }

    private boolean exist(int[][] s, int x1, int y1, int x2, int y2) {
        int num0 = 0, num1 = 0, num2 = 0;
        if (x1 != 0 && y1 != 0) {
            num0 = s[x1 - 1][y1 - 1];
        }
        if (x1 != 0) {
            num1 = s[x1 - 1][y2];
        }
        if (y1 != 0) {
            num2 = s[x2][y1 - 1];
        }
        return s[x2][y2] - num1 - num2 + num0 > 0;
    }
}
