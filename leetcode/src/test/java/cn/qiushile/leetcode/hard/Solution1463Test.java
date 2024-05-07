package cn.qiushile.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2024/5/7
 */
public class Solution1463Test {

    Solution1463 solution = new Solution1463();

    @Test
    public void cherryPickup1() {
        assertEquals(24, solution.cherryPickup(new int[][]{{3,1,1},{2,5,1},{1,5,5},{2,1,1}}));
    }

    @Test
    public void cherryPickup2() {
        assertEquals(28, solution.cherryPickup(new int[][]{
                {1,0,0,0,0,0,1},
                {2,0,0,0,0,3,0},
                {2,0,9,0,0,0,0},
                {0,3,0,5,4,0,0},
                {1,0,2,3,0,0,6}}));
    }

    @Test
    public void cherryPickup38() {
        assertEquals(96, solution.cherryPickup(new int[][]{
                {0,8,7 ,10,9,10,0,9 ,6},
                {8,7,10,8 ,7,4 ,9,6,10},
                {8,1,1 ,5 ,1,5 ,5,1 ,2},
                {9,4,10,8 ,8,1 ,9,5 ,0},
                {4,3,6 ,10,9,2 ,4,8,10},
                {7,3,2 ,8 ,3,3 ,5,9 ,8},
                {1,2,6 ,5 ,6,2 ,0,10,0}}));
    }
}
