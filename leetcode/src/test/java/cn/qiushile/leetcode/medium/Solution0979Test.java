package cn.qiushile.leetcode.medium;

import cn.qiushile.leetcode.entity.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2024/5/19
 */
public class Solution0979Test {

    Solution0979 solution = new Solution0979();

    @Test
    public void distributeCoins1() {
        assertEquals(2, solution.distributeCoins(new TreeNode(3, new TreeNode(0), new TreeNode(0))));
    }
    @Test
    public void distributeCoins2() {
        assertEquals(3, solution.distributeCoins(new TreeNode(0, new TreeNode(3), new TreeNode(0))));
    }
}
