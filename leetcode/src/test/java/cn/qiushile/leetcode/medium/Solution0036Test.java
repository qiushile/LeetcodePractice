package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Solution0036Test {

    private Solution0036 solution0036UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0036UnderTest = new Solution0036();
    }

    @Test
    public void testIsValidSudoku471() {
        // Setup
        final char[][] board = new char[][]{{'.','8','7','6','5','4','3','2','1'},{'2','.','.','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'},{'4','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},{'6','.','.','.','.','.','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}};

        // Run the test
        final boolean result = solution0036UnderTest.isValidSudoku(board);

        // Verify the results
        assertTrue(result);
    }
}
