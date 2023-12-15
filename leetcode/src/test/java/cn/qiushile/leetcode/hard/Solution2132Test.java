package cn.qiushile.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/12/15
 */
public class Solution2132Test {

    private Solution2132 solution = new Solution2132();

    @Test
    public void possibleToStamp01() {
        assertTrue(solution.possibleToStamp(new int[][]{{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0}}, 4, 3));
    }

    @Test
    public void possibleToStamp064() {
        assertFalse(solution.possibleToStamp(new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,1}}, 3, 3));
    }
}
