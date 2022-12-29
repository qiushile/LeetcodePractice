package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Solution1834Test {

    private Solution1834 solution1834UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1834UnderTest = new Solution1834();
    }

    @Test
    public void testGetOrder01() {
        // Setup
        final int[][] tasks = new int[][]{{1,2},{2,4},{3,2},{4,1}};

        // Run the test
        final int[] result = solution1834UnderTest.getOrder(tasks);

        // Verify the results
        assertArrayEquals(new int[]{0,2,3,1}, result);
    }

    @Test
    public void testGetOrder02() {
        // Setup
        final int[][] tasks = new int[][]{{7,10},{7,12},{7,5},{7,4},{7,2}};

        // Run the test
        final int[] result = solution1834UnderTest.getOrder(tasks);

        // Verify the results
        assertArrayEquals(new int[]{4,3,2,0,1}, result);
    }
}
