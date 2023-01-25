package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution2359Test {

    private Solution2359 solution2359UnderTest;

    @Before
    public void setUp() throws Exception {
        solution2359UnderTest = new Solution2359();
    }

    @Test
    public void testClosestMeetingNode01() {
        assertEquals(2, solution2359UnderTest.closestMeetingNode(new int[]{2,2,3,-1}, 0, 1));
    }

    @Test
    public void testClosestMeetingNode02() {
        assertEquals(2, solution2359UnderTest.closestMeetingNode(new int[]{1,2,-1}, 0, 2));
    }

    @Test
    public void testClosestMeetingNode05() {
        assertEquals(1, solution2359UnderTest.closestMeetingNode(new int[]{9,8,7,0,5,6,1,3,2,2}, 1, 6));
    }
}
