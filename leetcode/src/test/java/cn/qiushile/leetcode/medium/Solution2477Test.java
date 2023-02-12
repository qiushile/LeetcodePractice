package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution2477Test {

    private Solution2477 solution2477UnderTest;

    @Before
    public void setUp() throws Exception {
        solution2477UnderTest = new Solution2477();
    }

    @Test
    public void testMinimumFuelCost01() {
        // Setup
        final int[][] roads = new int[][]{{0,1},{0,2},{0,3}};

        // Run the test
        final long result = solution2477UnderTest.minimumFuelCost(roads, 5);

        // Verify the results
        assertEquals(3L, result);
    }

    @Test
    public void testMinimumFuelCost02() {
        // Setup
        final int[][] roads = new int[][]{{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}};

        // Run the test
        final long result = solution2477UnderTest.minimumFuelCost(roads, 2);

        // Verify the results
        assertEquals(7L, result);
    }

    @Test
    public void testMinimumFuelCost03() {
        // Setup
        final int[][] roads = new int[][]{};

        // Run the test
        final long result = solution2477UnderTest.minimumFuelCost(roads, 1);

        // Verify the results
        assertEquals(0L, result);
    }
}
