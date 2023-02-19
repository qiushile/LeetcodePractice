package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution1139Test {

    private Solution1139 solution1139UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1139UnderTest = new Solution1139();
    }

    @Test
    public void testLargest1BorderedSquare() {
        // Setup
        final int[][] grid = new int[][]{{1,1,1},{1,0,1},{1,1,1}};

        // Run the test
        final int result = solution1139UnderTest.largest1BorderedSquare(grid);

        // Verify the results
        assertEquals(9, result);
    }
}
