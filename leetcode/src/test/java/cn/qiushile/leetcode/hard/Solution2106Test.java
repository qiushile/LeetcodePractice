package cn.qiushile.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/5/4
 */
public class Solution2106Test {

    private Solution2106 solution = new Solution2106();

    @Test
    public void maxTotalFruits1() {
        int[][] fruits = new int[][]{{2,8},{6,3},{8,6}};
        assertEquals(9, solution.maxTotalFruits(fruits, 5, 4));
    }
    @Test
    public void maxTotalFruits2() {
        int[][] fruits = new int[][]{{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}};
        assertEquals(14, solution.maxTotalFruits(fruits, 5, 4));
    }
    @Test
    public void maxTotalFruits3() {
        int[][] fruits = new int[][]{{0,3},{6,4},{8,5}};
        assertEquals(0, solution.maxTotalFruits(fruits, 3, 2));
    }
    @Test
    public void maxTotalFruits03() {
        int[][] fruits = new int[][]{{200000,10000}};
        assertEquals(10000, solution.maxTotalFruits(fruits, 200000, 200000));
    }
    @Test
    public void maxTotalFruits05() {
        int[][] fruits = new int[][]{{200000,10000}};
        assertEquals(10000, solution.maxTotalFruits(fruits, 0, 200000));
    }
    @Test
    public void maxTotalFruits13() {
        int[][] fruits = new int[][]{{200000,10000}};
        assertEquals(0, solution.maxTotalFruits(fruits, 0, 0));
    }
    @Test
    public void maxTotalFruits013() {
        int[][] fruits = new int[][]{{0,7},{7,4},{9,10},{12,6},{14,8},{16,5},{17,8},{19,4},{20,1},{21,3},{24,3},{25,3},{26,1},{28,10},{30,9},{31,6},{32,1},{37,5},{40,9}};
        assertEquals(71, solution.maxTotalFruits(fruits, 21, 30));
    }
    @Test
    public void maxTotalFruits14() {
        int[][] fruits = new int[][]{{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}};
        assertEquals(14, solution.maxTotalFruits(fruits, 5, 4));
    }
}
