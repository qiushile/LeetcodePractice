package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/5
 */
public class Solution0452Test {
    private Solution0452 solution;

    public Solution0452Test() {}

    @Before
    public void setUp() throws Exception {
        solution = new Solution0452();
    }

    @Test
    public void findMinArrowShots00() {
        assertEquals(4, solution.findMinArrowShots(new int[][]{{-5,16},{-3,-1},{-2147483646,-2147483645},{2147483646,2147483647},{-1,6},{-7,-2}}));
    }

    @Test
    public void findMinArrowShots01() {
        assertEquals(2, solution.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
    }

    @Test
    public void findMinArrowShots02() {
        assertEquals(4, solution.findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}));
    }

    @Test
    public void findMinArrowShots03() {
        assertEquals(2, solution.findMinArrowShots(new int[][]{{1,2},{2,3},{3,4},{4,5}}));
    }

    @Test
    public void findMinArrowShots48() {
        assertEquals(2, solution.findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}));
    }
}
