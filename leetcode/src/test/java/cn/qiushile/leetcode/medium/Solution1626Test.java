package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution1626Test {

    private Solution1626 solution1626UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1626UnderTest = new Solution1626();
    }

    @Test
    public void testBestTeamScore01() {
        assertEquals(34, solution1626UnderTest.bestTeamScore(new int[]{1,3,5,10,15}, new int[]{1,2,3,4,5}));
    }

    @Test
    public void testBestTeamScore02() {
        assertEquals(16, solution1626UnderTest.bestTeamScore(new int[]{4,5,6,5}, new int[]{2,1,2,1}));
    }

    @Test
    public void testBestTeamScore03() {
        assertEquals(6, solution1626UnderTest.bestTeamScore(new int[]{1,2,3,5}, new int[]{8,9,10,1}));
    }
}
