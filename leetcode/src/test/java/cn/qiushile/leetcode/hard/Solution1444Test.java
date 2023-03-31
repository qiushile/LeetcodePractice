package cn.qiushile.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/4/1
 */
public class Solution1444Test {

    private Solution1444 solution = new Solution1444();

    @Test
    public void ways01() {
        assertEquals(3, solution.ways(new String[]{"A..","AAA","..."}, 3));
    }

    @Test
    public void ways02() {
        assertEquals(1, solution.ways(new String[]{"A..","AA.","..."}, 3));
    }

    @Test
    public void ways03() {
        assertEquals(1, solution.ways(new String[]{"A..","A..","..."}, 1));
    }
}
