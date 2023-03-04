package cn.qiushile.leetcode.medium;

/**
 * 79. Word Search
 * Medium 12.8K 521
 * Companies
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * Example 1:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 * Constraints:
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 * Runtime 120 ms Beats 96.99% Memory 40.5 MB Beats 56.11%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/3/4
 */
public class Solution0079 {

    private char[] target = null;
    private int n = -1;
    private int m = -1;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        target = word.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (snake(board, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean snake(char[][] board, int i, int j, int pos) {
        char curr = target[pos];
        if (board[i][j] == curr) {
            if (pos == target.length - 1) {
                return true;
            }
            board[i][j] = '.';
            if (i > 0 && board[i - 1][j] != '.') {
                if (snake(board, i - 1, j, pos + 1)) {
                    return true;
                }
            }
            if (i < n - 1 && board[i + 1][j] != '.') {
                if (snake(board, i + 1, j, pos + 1)) {
                    return true;
                }
            }
            if (j > 0 && board[i][j - 1] != '.') {
                if (snake(board, i, j - 1, pos + 1)) {
                    return true;
                }
            }
            if (j < m - 1 && board[i][j + 1] != '.') {
                if (snake(board, i, j + 1, pos + 1)) {
                    return true;
                }
            }
            board[i][j] = curr;
        }
        return false;
    }
}
