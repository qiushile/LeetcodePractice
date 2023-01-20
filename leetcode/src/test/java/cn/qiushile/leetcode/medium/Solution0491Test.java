package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution0491Test {

    private Solution0491 solution0491UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0491UnderTest = new Solution0491();
    }

    @Test
    public void testFindSubsequences01() {
        assertEquals(8, solution0491UnderTest.findSubsequences(new int[]{4,6,7,7}).size());
    }
}
