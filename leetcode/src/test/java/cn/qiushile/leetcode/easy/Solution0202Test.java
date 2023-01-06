package cn.qiushile.leetcode.easy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Solution0202Test {

    private Solution0202 solution0202UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0202UnderTest = new Solution0202();
    }

    @Test
    public void testIsHappy01() {
        assertTrue(solution0202UnderTest.isHappy(19));
    }
}
