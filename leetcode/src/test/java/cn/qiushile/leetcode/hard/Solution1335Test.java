package cn.qiushile.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/5/16
 */
public class Solution1335Test {

    private Solution1335 solution = new Solution1335();

    @Test
    public void minDifficulty1() {
        assertEquals(7, solution.minDifficulty(new int[]{6,5,4,3,2,1}, 2));
    }

    @Test
    public void minDifficulty11() {
        assertEquals(843, solution.minDifficulty(new int[]{11,111,22,222,33,333,44,444}, 6));
    }


    @Test
    public void minDifficulty13() {
        assertEquals(1803, solution.minDifficulty(new int[]{186,398,479,206,885,423,805,112,925,656,16,932,740,292,671,360}, 4));
    }
}
