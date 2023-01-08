package cn.qiushile.leetcode.hard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution0149Test {

    private Solution0149 solution0149UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0149UnderTest = new Solution0149();
    }

    @Test
    public void testMaxPoints01() {
        // Setup
        final int[][] points = new int[][]{{1,1},{2,2},{3,3}};

        // Run the test
        final int result = solution0149UnderTest.maxPoints(points);

        // Verify the results
        assertEquals(3, result);
    }

    @Test
    public void testMaxPoints02() {
        // Setup
        final int[][] points = new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};

        // Run the test
        final int result = solution0149UnderTest.maxPoints(points);

        // Verify the results
        assertEquals(4, result);
    }

    @Test
    public void testMaxPoints13() {
        // Setup
        final int[][] points = new int[][]{{0,0},{1,-1},{1,1}};

        // Run the test
        final int result = solution0149UnderTest.maxPoints(points);

        // Verify the results
        assertEquals(2, result);
    }

    @Test
    public void testMaxPoints33() {
        // Setup
        final int[][] points = new int[][]{{2,3},{3,3},{-5,3}};

        // Run the test
        final int result = solution0149UnderTest.maxPoints(points);

        // Verify the results
        assertEquals(3, result);
    }
}
