package cn.qiushile.leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2024/11/25
 */
public class Solution0743Test {

    Solution0743 solution = new Solution0743();

    @Test
    public void networkDelayTime1() {
        assertEquals(2, solution.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
    }
    @Test
    public void networkDelayTime2() {
        assertEquals(1, solution.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 1));
    }
    @Test
    public void networkDelayTime3() {
        assertEquals(-1, solution.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2));
    }
}
