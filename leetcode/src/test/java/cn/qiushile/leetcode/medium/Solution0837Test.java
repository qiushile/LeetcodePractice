package cn.qiushile.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/5/25
 */
public class Solution0837Test {

    private Solution0837 solution = new Solution0837();
    @Test
    public void new21Game1() {
        assertEquals(1.00000, solution.new21Game(10, 1, 10), 0.0001);
    }

    @Test
    public void new21Game2() {
        assertEquals(0.6, solution.new21Game(6, 1, 10), 0.0001);
    }

    @Test
    public void new21Game3() {
        assertEquals(0.73278, solution.new21Game(21, 17, 10), 0.0001);
    }
}
