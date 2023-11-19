package cn.qiushile.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/11/19
 */
public class Solution0689Test {

    Solution0689 solution = new Solution0689();

    @Test
    public void maxSumOfThreeSubarrays1() {
        assertArrayEquals(new int[]{0,3,5}, solution.maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1}, 2));
    }

    @Test
    public void maxSumOfThreeSubarrays03() {
        assertArrayEquals(new int[]{0,3,5}, solution.maxSumOfThreeSubarrays(new int[]{1,2,1,2,2,2,2,2}, 2));
    }

    @Test
    public void maxSumOfThreeSubarrays39() {
        assertArrayEquals(new int[]{1,4,7}, solution.maxSumOfThreeSubarrays(new int[]{7,13,20,19,19,2,10,1,1,19}, 3));
    }
}
