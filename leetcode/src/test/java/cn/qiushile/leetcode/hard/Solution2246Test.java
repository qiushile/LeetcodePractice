package cn.qiushile.leetcode.hard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution2246Test {

    private Solution2246 solution2246UnderTest;

    @Before
    public void setUp() throws Exception {
        solution2246UnderTest = new Solution2246();
    }

    @Test
    public void testLongestPath01() {
        assertEquals(3, solution2246UnderTest.longestPath(new int[]{-1,0,0,1,1,2}, "abacbe"));
    }

    @Test
    public void testLongestPath02() {
        assertEquals(3, solution2246UnderTest.longestPath(new int[]{-1,0,0,0}, "aabc"));
    }
}
