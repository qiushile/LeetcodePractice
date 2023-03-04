package cn.qiushile.leetcode.contest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution6314Test {

    private Solution6314 solution6314UnderTest;

    @Before
    public void setUp() throws Exception {
        solution6314UnderTest = new Solution6314();
    }

    @Test
    public void testRootCount01() {
        // Setup
        final int[][] edges = new int[][]{{0,1},{1,2},{1,3},{4,2}};
        final int[][] guesses = new int[][]{{1,3},{0,1},{1,0},{2,4}};

        // Run the test
        final int result = solution6314UnderTest.rootCount(edges, guesses, 3);

        // Verify the results
        assertEquals(3, result);
    }

    @Test
    public void testRootCount02() {
        // Setup
        final int[][] edges = new int[][]{{0,1},{1,2},{2,3},{3,4}};
        final int[][] guesses = new int[][]{{1,0},{3,4},{2,1},{3,2}};

        // Run the test
        final int result = solution6314UnderTest.rootCount(edges, guesses, 1);

        // Verify the results
        assertEquals(5, result);
    }
}
