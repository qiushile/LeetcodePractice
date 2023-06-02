package cn.qiushile.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/6/2
 */
public class Solution0220Test {

    private Solution0220 solution = new Solution0220();

    @Test
    public void containsNearbyAlmostDuplicate1() {
        assertTrue(solution.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));
    }

    @Test
    public void containsNearbyAlmostDuplicate2() {
        assertFalse(solution.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
    }

    @Test
    public void containsNearbyAlmostDuplicate40() {
        assertTrue(solution.containsNearbyAlmostDuplicate(new int[]{1,2,2,3,4,5}, 3, 0));
    }
}
