package cn.qiushile.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/5/28
 */
public class Solution1547Test {

    private Solution1547 solution = new Solution1547();

    @Test
    public void minCost1() {
        assertEquals(16, solution.minCost(7, new int[]{1,3,4,5}));
    }

    @Test
    public void minCost2() {
        assertEquals(22, solution.minCost(9, new int[]{5,6,1,4,2}));
    }
}
