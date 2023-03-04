package cn.qiushile.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
 * Runtime 1120 ms Beats 5.1% Memory 42.9 MB Beats 8.83%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/3/4
 */
public class Solution0079 {

    private LinkedList<Integer> path = new LinkedList<>();
    private Map<Integer, List<Integer>> map = new HashMap<>();
    private int[] target = null;
    private int n = -1;
    private int m = -1;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.computeIfAbsent((int) (board[i][j] - 'A'), x -> new ArrayList<>()).add(i * m + j);
            }
        }
        target = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            target[i] = (int) (word.charAt(i) - 'A');
            if (!map.containsKey(target[i])) {
                return false;
            }
        }
        return snake(0);
    }

    private boolean snake(int pos) {
        if (pos == target.length) {
            return false;
        }
        int curr = target[pos];
        if (map.containsKey(curr)) {
            Integer last = path.peekLast();
            int ci = last == null? -1: last / m;
            int cj = last == null? -1: last % m;
            for (Integer next : map.get(curr)) {
                if (!path.contains(next)) {
                    int ni = next / m;
                    int nj = next % m;
                    if (last == null || (ci == ni && Math.abs(cj - nj) == 1) || (cj == nj) && Math.abs(ci - ni) == 1) {
                        if (pos == target.length - 1) {
                            return true;
                        }
                        path.offerLast(next);
                        if (snake(pos + 1)) {
                            return true;
                        }
                        path.pollLast();
                    }

                }
            }
        }
        return false;
    }
}
