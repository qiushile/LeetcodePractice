package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Solution1519Test {

    private Solution1519 solution1519UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1519UnderTest = new Solution1519();
    }

    @Test
    public void testCountSubTrees01() {
        // Setup
        final int[][] edges = new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};

        // Run the test
        final int[] result = solution1519UnderTest.countSubTrees(7, edges, "abaedcd");

        // Verify the results
        assertArrayEquals(new int[]{2,1,1,1,1,1,1}, result);
    }

    @Test
    public void testCountSubTrees02() {
        // Setup
        final int[][] edges = new int[][]{{0,1},{1,2},{0,3}};

        // Run the test
        final int[] result = solution1519UnderTest.countSubTrees(4, edges, "bbbb");

        // Verify the results
        assertArrayEquals(new int[]{4,2,1,1}, result);
    }

    @Test
    public void testCountSubTrees03() {
        // Setup
        final int[][] edges = new int[][]{{0,1},{1,2},{1,3},{0,4}};

        // Run the test
        final int[] result = solution1519UnderTest.countSubTrees(5, edges, "aabab");

        // Verify the results
        assertArrayEquals(new int[]{3,2,1,1,1}, result);
    }

    /**
     *              0               c
     *            1   2           b   a
     *          3               b
     *        4               a
     *      5               a
     */
    @Test
    public void testCountSubTrees16() {
        // Setup
        final int[][] edges = new int[][]{{0,1},{0,2},{1,3},{3,4},{4,5}};

        // Run the test
        final int[] result = solution1519UnderTest.countSubTrees(6, edges, "cbabaa");

        // Verify the results
        assertArrayEquals(new int[]{1,2,1,1,2,1}, result);
    }
}
