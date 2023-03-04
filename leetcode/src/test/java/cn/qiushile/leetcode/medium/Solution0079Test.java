
package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Solution0079Test {

    private Solution0079 solution0079UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0079UnderTest = new Solution0079();
    }

    @Test
    public void testExist01() {
        // Setup
        final char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        // Run the test
        final boolean result = solution0079UnderTest.exist(board, "ABCCED");

        // Verify the results
        assertTrue(result);
    }

    @Test
    public void testExist02() {
        // Setup
        final char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        // Run the test
        final boolean result = solution0079UnderTest.exist(board, "SEE");

        // Verify the results
        assertTrue(result);
    }

    @Test
    public void testExist03() {
        // Setup
        final char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        // Run the test
        final boolean result = solution0079UnderTest.exist(board, "ABCB");

        // Verify the results
        assertFalse(result);
    }

    @Test
    public void testExist65() {
        // Setup
        final char[][] board = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};

        // Run the test
        final boolean result = solution0079UnderTest.exist(board, "AAB");

        // Verify the results
        assertTrue(result);
    }
}
