package cn.qiushile.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2024/4/20
 */
public class Solution0039Test {

    Solution0039 solution = new Solution0039();

    @Test
    public void combinationSum1() {
        assertEquals(2, solution.combinationSum(new int[]{2,3,6,7}, 7).size());
    }
    @Test
    public void combinationSum2() {
        assertEquals(3, solution.combinationSum(new int[]{2,3,6}, 8).size());
    }
    @Test
    public void combinationSum3() {
        assertEquals(0, solution.combinationSum(new int[]{2}, 1).size());
    }
}
