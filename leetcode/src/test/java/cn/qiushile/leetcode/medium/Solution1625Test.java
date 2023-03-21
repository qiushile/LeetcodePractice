package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution1625Test {

    private Solution1625 solution1625UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1625UnderTest = new Solution1625();
    }

    @Test
    public void testFindLexSmallestString01() {
        assertEquals("2050", solution1625UnderTest.findLexSmallestString("5525", 9, 2));
    }

    @Test
    public void testFindLexSmallestString02() {
        assertEquals("24", solution1625UnderTest.findLexSmallestString("74", 5, 1));
    }

    @Test
    public void testFindLexSmallestString03() {
        assertEquals("0011", solution1625UnderTest.findLexSmallestString("0011", 4, 2));
    }
    @Test
    public void testFindLexSmallestString04() {
        assertEquals("00553311", solution1625UnderTest.findLexSmallestString("43987654", 7, 3));
    }
}
