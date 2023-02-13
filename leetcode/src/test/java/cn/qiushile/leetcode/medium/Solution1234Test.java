package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution1234Test {

    private Solution1234 solution1234UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1234UnderTest = new Solution1234();
    }

    @Test
    public void testBalancedString06() {
        assertEquals(3, solution1234UnderTest.balancedString("WQWRQQQW"));
    }

    @Test
    public void testBalancedString30() {
        assertEquals(6, solution1234UnderTest.balancedString("WQWRQEQQWERQWWWEREWRQQWWWWQW"));
    }
}
