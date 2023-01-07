package cn.qiushile.leetcode.medium;

import cn.qiushile.leetcode.medium.Solution0652.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Solution0652Test {

    private Solution0652 solution0652UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0652UnderTest = new Solution0652();
    }

    @Test
    public void testFindDuplicateSubtrees145() {
        List<TreeNode> duplicateSubtrees = solution0652UnderTest.findDuplicateSubtrees(
                new TreeNode(0,
                        new TreeNode(0, new TreeNode(0, null, null), null),
                        new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0)))));
        assertEquals(1, duplicateSubtrees.size());
        assertEquals(0, duplicateSubtrees.get(0).val);
    }
}
