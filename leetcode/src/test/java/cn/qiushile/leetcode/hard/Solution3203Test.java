package cn.qiushile.leetcode.hard;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2024/12/25
 */
public class Solution3203Test {

    private Solution3203 solution = new Solution3203();

    @Test
    public void minimumDiameterAfterMerge1() {
        assertEquals(3, solution.minimumDiameterAfterMerge(new int[][]{{0, 1}, {0, 2}, {0, 3}}, new int[][]{{0,1}}));
    }

    @Test
    public void minimumDiameterAfterMerge2() {
        assertEquals(5, solution.minimumDiameterAfterMerge(new int[][]{{0,1},{0,2},{0,3},{2,4},{2,5},{3,6},{2,7}}, new int[][]{{0,1},{0,2},{0,3},{2,4},{2,5},{3,6},{2,7}}));
    }

    @Test
    public void minimumDiameterAfterMerge110() {
        assertEquals(6, solution.minimumDiameterAfterMerge(new int[][]{{1,0},{2,3},{1,4},{2,1},{2,5}}, new int[][]{{4,5},{2,6},{3,2},{4,7},{3,4},{0,3},{1,0},{1,8}}));
    }

    @Test
    public void minimumDiameterAfterMerge546() {
        assertEquals(7, solution.minimumDiameterAfterMerge(new int[][]{{0,1},{2,0},{3,2},{3,6},{8,7},{4,8},{5,4},{3,5},{3,9}}, new int[][]{{0,1},{0,2},{0,3}}));
    }
}
