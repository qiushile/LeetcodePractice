package cn.qiushile.leetcode.easy;

import cn.qiushile.leetcode.easy.Solution0100.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Solution0100Test {

    private Solution0100 solution0100UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0100UnderTest = new Solution0100();
    }

    @Test
    public void testIsSameTree() {
        // Setup
        final TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        final TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        // Run the test
        final boolean result = solution0100UnderTest.isSameTree(p, q);

        // Verify the results
        assertTrue(result);
    }
}
