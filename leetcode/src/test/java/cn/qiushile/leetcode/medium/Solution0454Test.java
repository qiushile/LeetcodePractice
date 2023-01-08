package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution0454Test {

    private Solution0454 solution0454UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0454UnderTest = new Solution0454();
    }

    @Test
    public void testFourSumCount01() {
        assertEquals(2, solution0454UnderTest.fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2}));
    }

    @Test
    public void testFourSumCount02() {
        assertEquals(1, solution0454UnderTest.fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}));
    }
}
