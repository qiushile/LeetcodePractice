package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Solutioin0542Test {

    private Solutioin0542 solutioin0542UnderTest;

    @Before
    public void setUp() throws Exception {
        solutioin0542UnderTest = new Solutioin0542();
    }

    @Test
    public void testUpdateMatrix01() {
        // Setup
        final int[][] mat = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        final int[][] expectedResult = new int[][]{{0,0,0},{0,1,0},{0,0,0}};

        // Run the test
        final int[][] result = solutioin0542UnderTest.updateMatrix(mat);

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testUpdateMatrix02() {
        // Setup
        final int[][] mat = new int[][]{{0,0,0},{0,1,0},{1,1,1}};
        final int[][] expectedResult = new int[][]{{0,0,0},{0,1,0},{1,2,1}};

        // Run the test
        final int[][] result = solutioin0542UnderTest.updateMatrix(mat);

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }
}
