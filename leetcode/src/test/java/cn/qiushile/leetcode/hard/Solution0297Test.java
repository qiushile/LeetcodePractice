package cn.qiushile.leetcode.hard;

import cn.qiushile.leetcode.hard.Solution0297.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Solution0297Test {

    private Solution0297 solution0297UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0297UnderTest = new Solution0297();
    }

    @Test
    public void testSerializeDeserialize() {
        final Integer[] nums = new Integer[] {4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2};
        TreeNode root = generate(nums);

        // Setup
        //final TreeNode root = tree[0];

        // Run the test
        final String result = solution0297UnderTest.serialize(root);

        // Verify the results
        assertNotNull(result);
        TreeNode treeNode = solution0297UnderTest.deserialize(result);
        assertNotNull(treeNode.right.left.right.left.left);
        assertEquals(5, treeNode.right.left.right.left.left.val);

    }

    private static TreeNode generate(Integer[] nums) {
        List<TreeNode> last = new ArrayList<>();
        List<TreeNode> curr = new ArrayList<>();
        int n = nums.length;
        TreeNode root = new TreeNode(nums[0]);
        last.add(root);
        int start = 1;
        int end = -1;
        int count = 1;
        int i = 0;
        while (i < n) {
            end = start + count * 2;
            count = 0;
            for (i = start; i < end && i < n; i++) {
                Integer num = nums[i];
                if (num != null) {
                    count++;
                    TreeNode node = new TreeNode(num);
                    curr.add(node);
                    TreeNode parent = last.get((i - start) / 2);
                    if ((i - start) % 2 == 0) {
                        parent.left = node;
                    } else {
                        parent.right = node;
                    }
                }
            }
            start = end;
            last = curr;
            curr = new ArrayList<>();
        }
        return root;
    }
}
