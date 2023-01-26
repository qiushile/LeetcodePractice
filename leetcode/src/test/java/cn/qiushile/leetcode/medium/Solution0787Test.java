package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution0787Test {

    private Solution0787 solution0787UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0787UnderTest = new Solution0787();
    }

    @Test
    public void testFindCheapestPrice01() {
        // Setup
        final int[][] flights = new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};

        // Run the test
        final int result = solution0787UnderTest.findCheapestPrice(4, flights, 0, 3, 1);

        // Verify the results
        assertEquals(700, result);
    }

    @Test
    public void testFindCheapestPrice02() {
        // Setup
        final int[][] flights = new int[][]{{0,1,100},{1,2,100}};

        // Run the test
        final int result = solution0787UnderTest.findCheapestPrice(3, flights, 0, 2, 1);

        // Verify the results
        assertEquals(200, result);
    }

    @Test
    public void testFindCheapestPrice03() {
        // Setup
        final int[][] flights = new int[][]{{0,1,100},{1,2,100},{0,2,500}};

        // Run the test
        final int result = solution0787UnderTest.findCheapestPrice(3, flights, 0, 2, 0);

        // Verify the results
        assertEquals(500, result);
    }

    @Test
    public void testFindCheapestPrice46() {
        // Setup
        final int[][] flights = new int[][]{{0,1,1},{0,2,5},{1,2,1},{2,3,1}};

        // Run the test
        final int result = solution0787UnderTest.findCheapestPrice(4, flights, 0, 3, 1);

        // Verify the results
        assertEquals(6, result);
    }
}
