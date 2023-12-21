package cn.qiushile.leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/12/21
 */
public class Solution2866Test {

    Solution2866 solution = new Solution2866();

    @Test
    public void maximumSumOfHeights1() {
        assertEquals(13, solution.maximumSumOfHeights(Arrays.asList(5,3,4,1,1)));
    }

    @Test
    public void maximumSumOfHeights2() {
        assertEquals(22, solution.maximumSumOfHeights(Arrays.asList(6,5,3,9,2,7)));
    }

    @Test
    public void maximumSumOfHeights3() {
        assertEquals(18, solution.maximumSumOfHeights(Arrays.asList(3,2,5,5,2,3)));
    }

    @Test
    public void maximumSumOfHeights0690() {
        assertEquals(3000000000L, solution.maximumSumOfHeights(Arrays.asList(1000000000,1000000000,1000000000)));
    }
}
