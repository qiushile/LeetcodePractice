package cn.qiushile.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/9/28
 */
public class Solution2251Test {

    private Solution2251 solution = new Solution2251();

    @Test
    public void fullBloomFlowers01() {
        assertArrayEquals(new int[]{1,2,2,2}, solution.fullBloomFlowers(new int[][]{{1,6},{3,7},{9,12},{4,13}}, new int[]{2,3,7,11}));
    }

    @Test
    public void fullBloomFlowers02() {
        assertArrayEquals(new int[]{2,2,1}, solution.fullBloomFlowers(new int[][]{{1,10},{3,3}}, new int[]{3,3,2}));
    }
}
