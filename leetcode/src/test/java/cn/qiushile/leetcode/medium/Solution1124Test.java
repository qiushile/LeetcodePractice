package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution1124Test {

    private Solution1124 solution1124UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1124UnderTest = new Solution1124();
    }

    @Test
    public void testLongestWPI01() {
        assertEquals(3, solution1124UnderTest.longestWPI(new int[]{9,9,6,0,6,6,9}));
    }

    @Test
    public void testLongestWPI03() {
        assertEquals(1, solution1124UnderTest.longestWPI(new int[]{6,6,9}));
    }

    @Test
    public void testLongestWPI63() {
        assertEquals(1, solution1124UnderTest.longestWPI(new int[]{6,9,6}));
    }

    @Test
    public void testLongestWPI68() {
        assertEquals(3, solution1124UnderTest.longestWPI(new int[]{8,10,6,16,5}));
    }
}
