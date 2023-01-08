package cn.qiushile.leetcode.contest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution6285Test {

    private Solution6285 solution6285UnderTest;

    @Before
    public void setUp() throws Exception {
        solution6285UnderTest = new Solution6285();
    }

    @Test
    public void testMaxKelements01() {
        assertEquals(50L, solution6285UnderTest.maxKelements(new int[]{10,10,10,10,10}, 5));
    }

    @Test
    public void testMaxKelements02() {
        assertEquals(17L, solution6285UnderTest.maxKelements(new int[]{1,10,3,3,3}, 3));
    }
}
