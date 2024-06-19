package cn.qiushile.leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2024/6/19
 */
public class Solution1482Test {

    Solution1482 solution = new Solution1482();

    @Test
    public void minDays1() {
        assertEquals(3, solution.minDays(new int[]{1,10,3,10,2}, 3, 1));
    }

    @Test
    public void minDays3() {
        assertEquals(12, solution.minDays(new int[]{7,7,7,7,12,7,7}, 2, 3));
    }
}
