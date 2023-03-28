package cn.qiushile.leetcode.hard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution1092Test {

    private Solution1092 solution1092UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1092UnderTest = new Solution1092();
    }

    @Test
    public void testShortestCommonSupersequence01() {
        assertEquals("cabac", solution1092UnderTest.shortestCommonSupersequence("abac", "cab"));
    }

    @Test
    public void testShortestCommonSupersequence02() {
        assertEquals("aaaaaaaa", solution1092UnderTest.shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa"));
    }

    @Test
    public void testShortestCommonSupersequence002() {
        assertEquals("bbbaaababbb", solution1092UnderTest.shortestCommonSupersequence("bbbaaaba", "bbababbb"));
    }
}
