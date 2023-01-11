package cn.qiushile.leetcode.easy;

import cn.qiushile.leetcode.easy.Solution0112.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Solution0112Test {

    private Solution0112 solution0112UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0112UnderTest = new Solution0112();
    }

    @Test
    public void testHasPathSum() {
        // Setup
        final TreeNode root = new TreeNode(1, new TreeNode(2), null);

        // Run the test
        final boolean result = solution0112UnderTest.hasPathSum(root, 1);

        // Verify the results
        assertFalse(result);
    }

    @Test
    public void testHasPathSum01() {
        // Setup
        final TreeNode root = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));

        // Run the test
        final boolean result = solution0112UnderTest.hasPathSum(root, 22);

        // Verify the results
        assertTrue(result);
    }

    @Test
    public void testHasPathSum02() {
        // Setup
        final TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        // Run the test
        final boolean result = solution0112UnderTest.hasPathSum(root, 5);

        // Verify the results
        assertFalse(result);
    }

    @Test
    public void testHasPathSum03() {
        // Setup
        final TreeNode root = null;

        // Run the test
        final boolean result = solution0112UnderTest.hasPathSum(root, 0);

        // Verify the results
        assertFalse(result);
    }
}
