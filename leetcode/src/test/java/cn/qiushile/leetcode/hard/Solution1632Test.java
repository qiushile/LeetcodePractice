package cn.qiushile.leetcode.hard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Solution1632Test {

    private Solution1632 solution1632UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1632UnderTest = new Solution1632();
    }

    @Test
    public void testMatrixRankTransform01() {
        // Setup
        final int[][] matrix = new int[][]{{1,2},{3,4}};
        final int[][] expectedResult = new int[][]{{1,2},{2,3}};

        // Run the test
        final int[][] result = solution1632UnderTest.matrixRankTransform(matrix);

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testMatrixRankTransform02() {
        // Setup
        final int[][] matrix = new int[][]{{7,7},{7,7}};
        final int[][] expectedResult = new int[][]{{1,1},{1,1}};

        // Run the test
        final int[][] result = solution1632UnderTest.matrixRankTransform(matrix);

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testMatrixRankTransform03() {
        // Setup
        final int[][] matrix = new int[][]{{20,-21,14},{-19,4,19},{22,-47,24},{-19,4,19}};
        final int[][] expectedResult = new int[][]{{4,2,3},{1,3,4},{5,1,6},{1,3,4}};

        // Run the test
        final int[][] result = solution1632UnderTest.matrixRankTransform(matrix);

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testMatrixRankTransform09() {
        // Setup
        final int[][] matrix = new int[][]{{2,3,1},{9,4,5},{3,4,2}};
        final int[][] expectedResult = new int[][]{{2,3,1},{6,4,5},{3,4,2}};

        // Run the test
        final int[][] result = solution1632UnderTest.matrixRankTransform(matrix);

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testMatrixRankTransform10() {
        // Setup
        final int[][] matrix = new int[][]{{-37,-26,-47,-40,-13},{22,-11,-44,47,-6},{-35,8,-45,34,-31},{-16,23,-6,-43,-20},{47,38,-27,-8,43}};
        final int[][] expectedResult = new int[][]{{3,4,1,2,7},{9,5,3,10,8},{4,6,2,7,5},{7,9,8,1,6},{12,10,4,5,11}};

        // Run the test
        final int[][] result = solution1632UnderTest.matrixRankTransform(matrix);

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }
}
