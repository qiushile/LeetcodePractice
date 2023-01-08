package cn.qiushile.leetcode.contest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution6283Test {

    private Solution6283 solution6283UnderTest;

    @Before
    public void setUp() throws Exception {
        solution6283UnderTest = new Solution6283();
    }

    @Test
    public void testMaximumCount00() {
        assertEquals(3, solution6283UnderTest.maximumCount(new int[]{-2,-1,0,0,0,1,2,3}));
    }

    @Test
    public void testMaximumCount01() {
        assertEquals(3, solution6283UnderTest.maximumCount(new int[]{-2,-1,-1,1,2,3}));
    }

    @Test
    public void testMaximumCount02() {
        assertEquals(3, solution6283UnderTest.maximumCount(new int[]{-3,-2,-1,0,0,1,2}));
    }

    @Test
    public void testMaximumCount03() {
        assertEquals(4, solution6283UnderTest.maximumCount(new int[]{5,20,66,1314}));
    }
}
