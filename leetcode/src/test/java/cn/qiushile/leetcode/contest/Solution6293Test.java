package cn.qiushile.leetcode.contest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution6293Test {

    private Solution6293 solution6293UnderTest;

    @Before
    public void setUp() throws Exception {
        solution6293UnderTest = new Solution6293();
    }

    @Test
    public void testCountGood01() {
        assertEquals(1L, solution6293UnderTest.countGood(new int[]{1,1,1,1,1}, 10));
    }

    @Test
    public void testCountGood02() {
        assertEquals(4L, solution6293UnderTest.countGood(new int[]{3,1,4,3,2,2,4}, 2));
    }
}
