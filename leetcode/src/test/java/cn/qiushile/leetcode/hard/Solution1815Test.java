package cn.qiushile.leetcode.hard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution1815Test {

    private Solution1815 solution1815UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1815UnderTest = new Solution1815();
    }

    @Test
    public void testMaxHappyGroups01() {
        assertEquals(4, solution1815UnderTest.maxHappyGroups(3, new int[]{1,2,3,4,5,6}));
    }

    @Test
    public void testMaxHappyGroups02() {
        assertEquals(4, solution1815UnderTest.maxHappyGroups(4, new int[]{1,3,2,5,2,2,1,6}));
    }

    @Test
    public void testMaxHappyGroups50() {
        assertEquals(9, solution1815UnderTest.maxHappyGroups(7, new int[]{287773481,815094798,356732984,644469322,543193620,903158817,274116865,395252956,363839119,365378492,122313059,312690039,252532812}));
    }
}
