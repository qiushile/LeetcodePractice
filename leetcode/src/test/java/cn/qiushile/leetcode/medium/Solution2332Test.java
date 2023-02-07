package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution2332Test {

    private Solution2332 solution2332UnderTest;

    @Before
    public void setUp() throws Exception {
        solution2332UnderTest = new Solution2332();
    }

    @Test
    public void testLatestTimeCatchTheBus1() {
        assertEquals(16, solution2332UnderTest.latestTimeCatchTheBus(new int[]{10,20}, new int[]{2,17,18,19}, 2));
    }

    @Test
    public void testLatestTimeCatchTheBus2() {
        assertEquals(20, solution2332UnderTest.latestTimeCatchTheBus(new int[]{20,30,10}, new int[]{19,13,26,4,25,11,21}, 2));
    }

    @Test
    public void testLatestTimeCatchTheBus02() {
        assertEquals(3, solution2332UnderTest.latestTimeCatchTheBus(new int[]{3}, new int[]{2,4}, 2));
    }

    @Test
    public void testLatestTimeCatchTheBus03() {
        assertEquals(1, solution2332UnderTest.latestTimeCatchTheBus(new int[]{3}, new int[]{2,3}, 2));
    }

    @Test
    public void testLatestTimeCatchTheBus05() {
        assertEquals(1, solution2332UnderTest.latestTimeCatchTheBus(new int[]{2}, new int[]{2}, 2));
    }

    @Test
    public void testLatestTimeCatchTheBus54() {
        assertEquals(10, solution2332UnderTest.latestTimeCatchTheBus(new int[]{5,15}, new int[]{11,12,13,14,15}, 2));
    }
}
