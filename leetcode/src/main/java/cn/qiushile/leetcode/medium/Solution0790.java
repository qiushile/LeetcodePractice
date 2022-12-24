package cn.qiushile.leetcode.medium;

/**
 * 790. Domino and Tromino Tiling
 * Medium
 * 1.8K
 * 656
 * Companies
 * You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.
 * Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.
 * In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.
 * Example 1:
 * Input: n = 3
 * Output: 5
 * Explanation: The five different ways are show above.
 * Example 2:
 * Input: n = 1
 * Output: 1
 * Constraints:
 * 1 <= n <= 1000
 * Accepted
 * 57.5K
 * Submissions
 * 117.9K
 * Acceptance Rate
 * 48.8%
 * @author qiushile <qiushile@sina.com>
 * @date 2022/12/24
 */
public class Solution0790 {
    private static long[] tiles = new long[1001];
    private static int tilePosition = 4;
    static {
        tiles[1] = 1;
        tiles[2] = 2;
        tiles[3] = 5;
        tiles[4] = 11;
    }
    public int numTilings(int n) {
        if (n > tilePosition) {
            calcTile(n);
        }
        return (int) tiles[n];
    }

    private static void calcTile(int n) {
        for (int i = tilePosition + 1; i <= n; i++) {
            tiles[i] = tiles[i - 1] + tiles[i - 1] + tiles[i - 3];
            if (i > 27) {
                tiles[i] = tiles[i] % 1000000007;
            }
        }
        tilePosition = n;
    }
}
