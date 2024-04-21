package cn.qiushile.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2024/4/21
 */
public class Solution1883Test {

    Solution1883 solution = new Solution1883();
    @Test
    public void minSkips1() {
        assertEquals(1, solution.minSkips(new int[]{1,3,2}, 4,2));
    }
}
