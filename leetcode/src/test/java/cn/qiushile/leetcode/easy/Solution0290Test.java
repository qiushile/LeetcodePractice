package cn.qiushile.leetcode.easy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class Solution0290Test {

    private Solution0290 solution0290UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0290UnderTest = new Solution0290();
    }

    @Test
    public void testWordPattern32() {
        assertFalse(solution0290UnderTest.wordPattern("abba", "dog dog dog dog"));
    }
}
