package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Solution0542Test {

    private Solution0542 solution0542UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0542UnderTest = new Solution0542();
    }

    @Test
    public void testUpdateMatrix01() {
        // Setup
        final int[][] mat = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        final int[][] expectedResult = new int[][]{{0,0,0},{0,1,0},{0,0,0}};

        // Run the test
        final int[][] result = solution0542UnderTest.updateMatrix(mat);

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testUpdateMatrix02() {
        // Setup
        final int[][] mat = new int[][]{{0,0,0},{0,1,0},{1,1,1}};
        final int[][] expectedResult = new int[][]{{0,0,0},{0,1,0},{1,2,1}};

        // Run the test
        final int[][] result = solution0542UnderTest.updateMatrix(mat);

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }
}
