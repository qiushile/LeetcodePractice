package cn.qiushile.leetcode.hard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Solution0834Test {

    private Solution0834 solution0834UnderTest;

    @Before
    public void setUp() {
        solution0834UnderTest = new Solution0834();
    }

    @Test
    public void testSumOfDistancesInTree1() {
        // Setup
        final int[][] edges = new int[][]{{0,1},{0,2},{2,3},{2,4},{2,5}};

        // Run the test
        final int[] result = solution0834UnderTest.sumOfDistancesInTree(6, edges);

        // Verify the results
        assertArrayEquals(new int[]{8,12,6,10,10,10}, result);
    }

    @Test
    public void testSumOfDistancesInTree2() {
        // Setup
        final int[][] edges = new int[][]{{}};

        // Run the test
        final int[] result = solution0834UnderTest.sumOfDistancesInTree(1, edges);

        // Verify the results
        assertArrayEquals(new int[]{0}, result);
    }

    @Test
    public void testSumOfDistancesInTree3() {
        // Setup
        final int[][] edges = new int[][]{{1,0}};

        // Run the test
        final int[] result = solution0834UnderTest.sumOfDistancesInTree(2, edges);

        // Verify the results
        assertArrayEquals(new int[]{1,1}, result);
    }
}
