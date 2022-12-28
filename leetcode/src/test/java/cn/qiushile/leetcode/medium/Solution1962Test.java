package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution1962Test {

    private Solution1962 solution1962UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1962UnderTest = new Solution1962();
    }

    @Test
    public void testMinStoneSum01() {
        assertEquals(12, solution1962UnderTest.minStoneSum(new int[]{5, 4, 9}, 2));
    }

    @Test
    public void testMinStoneSum02() {
        assertEquals(12, solution1962UnderTest.minStoneSum(new int[]{4, 3, 6, 7}, 3));
    }
}
