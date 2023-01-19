package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution0974Test {

    private Solution0974 solution0974UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0974UnderTest = new Solution0974();
    }

    @Test
    public void testSubarraysDivByK01() {
        assertEquals(7, solution0974UnderTest.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
    }
}
