package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Offer0047Test {

    private Offer0047 offer0047UnderTest;

    @Before
    public void setUp() throws Exception {
        offer0047UnderTest = new Offer0047();
    }

    @Test
    public void testMaxValue() {
        // Setup
        final int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};

        // Run the test
        final int result = offer0047UnderTest.maxValue(grid);

        // Verify the results
        assertEquals(12, result);
    }
}
