package cn.qiushile.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2024/5/7
 */
public class Solution0741Test {

    Solution0741 solution = new Solution0741();

    @Test
    public void cherryPickup1() {
        assertEquals(5, solution.cherryPickup(new int[][]{{0,1,-1},{1,0,-1},{1,1,1}}));
    }

    @Test
    public void cherryPickup2() {
        assertEquals(0, solution.cherryPickup(new int[][]{{1,1,-1},{1,-1,1},{-1,1,1}}));
    }

    @Test
    public void cherryPickup16() {
        assertEquals(5, solution.cherryPickup(new int[][]{{0,1,-1},{1,0,-1},{1,1,1}}));
    }
}
