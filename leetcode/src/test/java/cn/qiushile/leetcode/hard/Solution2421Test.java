package cn.qiushile.leetcode.hard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution2421Test {

    private Solution2421 solution2421UnderTest;

    @Before
    public void setUp() throws Exception {
        solution2421UnderTest = new Solution2421();
    }

    @Test
    public void testNumberOfGoodPaths01() {
        assertEquals(6, solution2421UnderTest.numberOfGoodPaths(new int[]{1,3,2,1,3}, new int[][]{{0,1},{0,2},{2,3},{2,4}}));
    }

    @Test
    public void testNumberOfGoodPaths02() {
        assertEquals(7, solution2421UnderTest.numberOfGoodPaths(new int[]{1,1,2,2,3}, new int[][]{{0,1},{1,2},{2,3},{2,4}}));
    }

    @Test
    public void testNumberOfGoodPaths03() {
        assertEquals(1, solution2421UnderTest.numberOfGoodPaths(new int[]{1}, new int[][]{}));
    }
}
