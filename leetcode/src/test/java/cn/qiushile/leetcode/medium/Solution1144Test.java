package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution1144Test {

    private Solution1144 solution1144UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1144UnderTest = new Solution1144();
    }

    @Test
    public void testMovesToMakeZigzag01() {
        assertEquals(2, solution1144UnderTest.movesToMakeZigzag(new int[]{1,2,3}));
    }

    @Test
    public void testMovesToMakeZigzag02() {
        assertEquals(4, solution1144UnderTest.movesToMakeZigzag(new int[]{9,6,1,6,2}));
    }

    @Test
    public void testMovesToMakeZigzag36() {
        assertEquals(6, solution1144UnderTest.movesToMakeZigzag(new int[]{6,6,1,3,7,8}));
    }
}
