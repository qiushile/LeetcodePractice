package cn.qiushile.leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2026/1/19
 */
public class Solution1292Test {

    private Solution1292 solution = new Solution1292();

    @Test
    public void maxSideLength1() {
        assertEquals(2, solution.maxSideLength(new int[][]{{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}}, 4));
    }

    @Test
    public void maxSideLength45() {
        assertEquals(1, solution.maxSideLength(new int[][]{{0}}, 0));
    }
}
