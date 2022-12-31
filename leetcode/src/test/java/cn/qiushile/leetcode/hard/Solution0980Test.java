package cn.qiushile.leetcode.hard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution0980Test {

    private Solution0980 solution0980UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0980UnderTest = new Solution0980();
    }

    @Test
    public void testUniquePathsIII01() {
        assertEquals(2, solution0980UnderTest.uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
    }

    @Test
    public void testUniquePathsIII02() {
        assertEquals(4, solution0980UnderTest.uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,2}}));
    }

    @Test
    public void testUniquePathsIII03() {
        assertEquals(0, solution0980UnderTest.uniquePathsIII(new int[][]{{0,1},{2,0}}));
    }
}
