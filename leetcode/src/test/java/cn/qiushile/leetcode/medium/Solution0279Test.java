package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution0279Test {

    private Solution0279 solution0279UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0279UnderTest = new Solution0279();
    }

    @Test
    public void testNumSquares01() {
        assertEquals(3, solution0279UnderTest.numSquares(12));
    }

    @Test
    public void testNumSquares02() {
        assertEquals(2, solution0279UnderTest.numSquares(13));
    }

    @Test
    public void testNumSquares586() {
        assertEquals(2, solution0279UnderTest.numSquares(18));
    }
}
