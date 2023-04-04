package cn.qiushile.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/4/4
 */
public class Solution1000Test {

    Solution1000 solution = new Solution1000();

    @Test
    public void mergeStones01() {
        assertEquals(20, solution.mergeStones(new int[]{3,2,4,1}, 2));
    }

    @Test
    public void mergeStones02() {
        assertEquals(-1, solution.mergeStones(new int[]{3,2,4,1}, 3));
    }

    @Test
    public void mergeStones03() {
        assertEquals(25, solution.mergeStones(new int[]{3,5,1,2,6}, 3));
    }

    @Test
    public void mergeStones19() {
        assertEquals(40, solution.mergeStones(new int[]{6,4,4,6}, 2));
    }

    @Test
    public void mergeStones37() {
        assertEquals(36, solution.mergeStones(new int[]{6,4,9,3,1}, 3));
    }

    @Test
    public void mergeStones53() {
        assertEquals(3334, solution.mergeStones(new int[]{16,43,87,30,4,98,12,30,47,45,32,4,64,14,24,84,86,51,11,22,4}, 2));
    }
}
