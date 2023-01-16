package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Solution0057Test {

    private Solution0057 solution0057UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0057UnderTest = new Solution0057();
    }

    @Test
    public void testInsert01() {
        // Setup
        final int[][] intervals = new int[][]{{1,3},{6,9}};
        final int[][] expectedResult = new int[][]{{1,5},{6,9}};

        // Run the test
        final int[][] result = solution0057UnderTest.insert(intervals, new int[]{2,5});

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testInsert02() {
        // Setup
        final int[][] intervals = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        final int[][] expectedResult = new int[][]{{1,2},{3,10},{12,16}};

        // Run the test
        final int[][] result = solution0057UnderTest.insert(intervals, new int[]{4,8});

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testInsert002() {
        // Setup
        final int[][] intervals = new int[][]{};
        final int[][] expectedResult = new int[][]{{5,7}};

        // Run the test
        final int[][] result = solution0057UnderTest.insert(intervals, new int[]{5,7});

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testInsert003() {
        // Setup
        final int[][] intervals = new int[][]{{1,5}};
        final int[][] expectedResult = new int[][]{{1,5}};

        // Run the test
        final int[][] result = solution0057UnderTest.insert(intervals, new int[]{2,3});

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testInsert009() {
        // Setup
        final int[][] intervals = new int[][]{{1,5}};
        final int[][] expectedResult = new int[][]{{1,5},{6,8}};

        // Run the test
        final int[][] result = solution0057UnderTest.insert(intervals, new int[]{6,8});

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testInsert010() {
        // Setup
        final int[][] intervals = new int[][]{{1,5}};
        final int[][] expectedResult = new int[][]{{0,0},{1,5}};

        // Run the test
        final int[][] result = solution0057UnderTest.insert(intervals, new int[]{0,0});

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testInsert149() {
        // Setup
        final int[][] intervals = new int[][]{{3,5},{12,15}};
        final int[][] expectedResult = new int[][]{{3,5},{6,6},{12,15}};

        // Run the test
        final int[][] result = solution0057UnderTest.insert(intervals, new int[]{6,6});

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testInsert155() {
        // Setup
        final int[][] intervals = new int[][]{{6,10},{13,16},{19,19},{23,25},{34,39},{41,43},{49,51}};
        final int[][] expectedResult = new int[][]{{6,10},{13,16},{19,19},{23,25},{27,27},{34,39},{41,43},{49,51}};

        // Run the test
        final int[][] result = solution0057UnderTest.insert(intervals, new int[]{27,27});

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }
}
