package cn.qiushile.leetcode.easy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution0724Test {

    private Solution0724 solution0724UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0724UnderTest = new Solution0724();
    }

    @Test
    public void testPivotIndex01() {
        assertEquals(3, solution0724UnderTest.pivotIndex(new int[]{1,7,3,6,5,6}));
    }
}
