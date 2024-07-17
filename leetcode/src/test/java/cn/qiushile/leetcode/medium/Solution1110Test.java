package cn.qiushile.leetcode.medium;

import static org.junit.Assert.*;

import cn.qiushile.leetcode.entity.TreeNode;
import org.junit.Test;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2024/7/17
 */
public class Solution1110Test {

    Solution1110 solution = new Solution1110();

    @Test
    public void delNodes() {
        solution.delNodes(new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), new TreeNode(7))), new int[]{3,5});
    }
}
