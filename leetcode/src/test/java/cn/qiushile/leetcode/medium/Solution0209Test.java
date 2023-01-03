package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution0209Test {

    private Solution0209 solution0209UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0209UnderTest = new Solution0209();
    }

    @Test
    public void testMinSubArrayLen() {
        assertEquals(2, solution0209UnderTest.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

    @Test
    public void testMinSubArrayLen0() {
        assertEquals(3, solution0209UnderTest.minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }
}
