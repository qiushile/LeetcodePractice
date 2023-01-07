package cn.qiushile.leetcode.contest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution6290Test {

    private Solution6290 solution6290UnderTest;

    @Before
    public void setUp() throws Exception {
        solution6290UnderTest = new Solution6290();
    }

    @Test
    public void testMaxPower01() {
        assertEquals(5L, solution6290UnderTest.maxPower(new int[]{1,2,4,5,0}, 1, 2));
    }

    @Test
    public void testMaxPower02() {
        assertEquals(4L, solution6290UnderTest.maxPower(new int[]{4,4,4,4}, 0, 3));
    }
}
