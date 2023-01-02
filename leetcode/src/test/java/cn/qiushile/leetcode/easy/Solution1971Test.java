package cn.qiushile.leetcode.easy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Solution1971Test {

    private Solution1971 solution1971UnderTest;

    @Before
    public void setUp() {
        solution1971UnderTest = new Solution1971();
    }

    @Test
    public void testValidPath1() {
        assertTrue(solution1971UnderTest.validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2));
    }

    @Test
    public void testValidPath2() {
        assertFalse(solution1971UnderTest.validPath(6, new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5));
    }


    @Test
    public void testValidPath17() {
        assertTrue(solution1971UnderTest.validPath(50,
                new int[][]{{41,40},{9,32},{48,14},{6,44},{18,41},{41,1},{7,41},{38,41},{19,4},{16,41},{41,43},{41,22},
                        {41,21},{9,0},{41,48},{32,36},{24,44},{39,41},{48,17},{49,15},{47,41},{19,31},{11,41},{41,23},
                        {41,49},{45,44},{2,49},{13,41},{35,41},{30,0},{5,44},{8,0},{41,20},{41,28},{12,11},{12,41},{49,10},
                        {19,0},{0,37},{34,41},{42,48},{27,41},{0,41},{19,44},{41,26},{41,29},{33,41},{49,46},{41,25},{3,41}}, 40, 3));
    }

    @Test
    public void testValidPath19() {
        assertTrue(solution1971UnderTest.validPath(10,
                new int[][]{{2,6},{4,7},{1,2},{3,5},{7,9},{6,4},{9,8},{0,1},{3,0}}, 3, 5));
    }


}
