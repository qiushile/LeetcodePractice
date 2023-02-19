package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution1792Test {

    private Solution1792 solution1792UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1792UnderTest = new Solution1792();
    }

    @Test
    public void testMaxAverageRatio01() {
        // Setup
        final int[][] classes = new int[][]{{1,2},{3,5},{2,2}};

        // Run the test
        final double result = solution1792UnderTest.maxAverageRatio(classes, 2);

        // Verify the results
        assertEquals(0.7833, result, 0.00001);
    }

    @Test
    public void testMaxAverageRatio02() {
        // Setup
        final int[][] classes = new int[][]{{2,4},{3,9},{4,5},{2,10}};

        // Run the test
        final double result = solution1792UnderTest.maxAverageRatio(classes, 4);

        // Verify the results
        assertEquals(0.53485, result, 0.00001);
    }
}
