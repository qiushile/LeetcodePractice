package cn.qiushile.leetcode.easy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Solution0226Test {

    private Solution0226 solution0226UnderTest;

    @Before
    public void setUp() {
        solution0226UnderTest = new Solution0226();
    }

    @Test
    public void testInvertTree2() {
        // Setup
        final Solution0226.TreeNode root = new Solution0226.TreeNode(2);
        root.left = new Solution0226.TreeNode(1);
        root.right = new Solution0226.TreeNode(3);
        // Run the test
        final Solution0226.TreeNode result = solution0226UnderTest.invertTree(root);

        // Verify the results
        assertEquals(3, result.left.val);
        assertEquals(1, result.right.val);
    }

    @Test
    public void testInvertTree3() {
        // Setup
        final Solution0226.TreeNode root = null;

        // Run the test
        final Solution0226.TreeNode result = solution0226UnderTest.invertTree(root);

        // Verify the results
        assertNull(result);
    }
}
