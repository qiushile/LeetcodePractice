package cn.qiushile.leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2024/12/19
 */
public class Solution0769Test {

    Solution0769 solution = new Solution0769();

    @Test
    public void maxChunksToSorted1() {
        assertEquals(1, solution.maxChunksToSorted(new int[]{4,3,2,1,0}));
    }
    @Test
    public void maxChunksToSorted2() {
        assertEquals(4, solution.maxChunksToSorted(new int[]{1,0,2,3,4}));
    }
}
