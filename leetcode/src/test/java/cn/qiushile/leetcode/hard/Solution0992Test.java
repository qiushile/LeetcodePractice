package cn.qiushile.leetcode.hard;

import cn.qiushile.leetcode.hard.Solution0992;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2024/3/30
 */
public class Solution0992Test {

    Solution0992 solution = new Solution0992();

    @Test
    public void subarraysWithKDistinct1() {
        assertEquals(7, solution.subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2));
    }

    @Test
    public void subarraysWithKDistinct2() {
        assertEquals(3, solution.subarraysWithKDistinct(new int[]{1,2,1,3,4}, 3));
    }

    @Test
    public void subarraysWithKDistinct47() {
        assertEquals(2, solution.subarraysWithKDistinct(new int[]{1,2}, 1));
    }
}
