package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Solution0106Test {

    private Solution0106 solution0106UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0106UnderTest = new Solution0106();
    }

    @Test
    public void testBuildTree01() {
        // Setup
        // Run the test
        final Solution0106.TreeNode result = solution0106UnderTest.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});

        // Verify the results
        assertEquals(3, result.val);
        assertEquals(9, result.left.val);
        assertNull(result.left.left);
        assertNull(result.left.right);
        assertEquals(20, result.right.val);
        assertEquals(15, result.right.left.val);
        assertEquals(7, result.right.right.val);
        assertNull(result.right.left.left);
        assertNull(result.right.left.right);
        assertNull(result.right.right.left);
        assertNull(result.right.right.right);
    }
}
