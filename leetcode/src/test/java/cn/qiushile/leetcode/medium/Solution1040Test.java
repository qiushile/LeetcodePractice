package cn.qiushile.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/4/7
 */
public class Solution1040Test {

    Solution1040 solution = new Solution1040();

    @Test
    public void numMovesStonesII01() {
        assertArrayEquals(new int[]{1,2}, solution.numMovesStonesII(new int[]{7,4,9}));
    }

    @Test
    public void numMovesStonesII02() {
        assertArrayEquals(new int[]{2,3}, solution.numMovesStonesII(new int[]{6,5,4,3,10}));
    }
}
