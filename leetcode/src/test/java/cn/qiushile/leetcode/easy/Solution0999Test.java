package cn.qiushile.leetcode.easy;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2024/12/7
 */
public class Solution0999Test {

    Solution0999 solution = new Solution0999();

    @Test
    public void numRookCaptures() {
        char[][] board = new char[][]{
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
        };
        assertEquals(3, solution.numRookCaptures(board));
    }
}
