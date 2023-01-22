package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Solution0131Test {

    private Solution0131 solution0131UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0131UnderTest = new Solution0131();
    }

    @Test
    public void testPartition01() {
        assertEquals(List.of(List.of("a","a","b"), List.of("aa","b")), solution0131UnderTest.partition("aab"));
    }

    @Test
    public void testPartition02() {
        assertEquals(List.of(List.of("a")), solution0131UnderTest.partition("a"));
    }
}
