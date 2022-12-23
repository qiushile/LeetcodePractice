package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution0309Test {

    private Solution0309 solution0309UnderTest;

    @Before
    public void setUp() {
        solution0309UnderTest = new Solution0309();
    }

    @Test
    public void testMaxProfit001() {
        assertEquals(3, solution0309UnderTest.maxProfit(new int[]{1,2,3,0,2}));
    }

    @Test
    public void testMaxProfit002() {
        assertEquals(0, solution0309UnderTest.maxProfit(new int[]{1}));
    }

    @Test
    public void testMaxProfit003() {
        assertEquals(0, solution0309UnderTest.maxProfit(new int[]{2,1}));
    }

    @Test
    public void testMaxProfit131() {
        assertEquals(1, solution0309UnderTest.maxProfit(new int[]{2,1,2,0,1}));
    }

    @Test
    public void testMaxProfit192() {
        assertEquals(6, solution0309UnderTest.maxProfit(new int[]{6,1,3,2,4,7}));
    }

    @Test
    public void testMaxProfit193() {
        assertEquals(10, solution0309UnderTest.maxProfit(new int[]{2,1,4,5,2,9,7}));
    }

    @Test
    public void testMaxProfit202() {
        assertEquals(10, solution0309UnderTest.maxProfit(new int[]{1,3,5,4,3,7,6,9,2,4}));
    }

    @Test
    public void testMaxProfit203() {
        assertEquals(10, solution0309UnderTest.maxProfit(new int[]{8,6,4,3,3,2,3,5,8,3,8,2,6}));
    }
}
