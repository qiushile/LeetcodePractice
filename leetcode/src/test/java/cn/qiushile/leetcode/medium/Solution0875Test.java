package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution0875Test {

    private Solution0875 solution0875UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0875UnderTest = new Solution0875();
    }

    @Test
    public void testMinEatingSpeed() {
        assertEquals(2, solution0875UnderTest.minEatingSpeed(new int[]{11110}, 11100));
    }
}
