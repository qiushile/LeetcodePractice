package cn.qiushile.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/7/27
 */
public class Solution2141Test {

    private Solution2141 solution = new Solution2141();

    @Test
    public void maxRunTime() {
        assertEquals(2L, solution.maxRunTime(2, new int[]{1,1,1,1}));
    }
}
