package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Solution1443Test {

    private Solution1443 solution1443UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1443UnderTest = new Solution1443();
    }

    @Test
    public void testMinTime01() {
        assertEquals(8, solution1443UnderTest.minTime(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}, List.of(false,false,true,false,true,true,false)));
    }

    @Test
    public void testMinTime02() {
        assertEquals(6, solution1443UnderTest.minTime(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}, List.of(false,false,true,false,false,true,false)));
    }

    @Test
    public void testMinTime03() {
        assertEquals(0, solution1443UnderTest.minTime(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}, List.of(false,false,false,false,false,false,false)));
    }

    @Test
    public void testMinTime54() {
        assertEquals(4, solution1443UnderTest.minTime(4, new int[][]{{0,2},{0,3},{1,2}}, List.of(false,true,false,false)));
    }
}
