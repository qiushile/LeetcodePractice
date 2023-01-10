package cn.qiushile.leetcode.medium;

import cn.qiushile.leetcode.medium.Solution0133.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Solution0133Test {

    private Solution0133 solution0133UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0133UnderTest = new Solution0133();
    }

    @Test
    public void testCloneGraph() {
        // Setup
        final Node n1 = new Node(1);
        final Node n2 = new Node(2);
        final Node n3 = new Node(3);
        final Node n4 = new Node(4);

        n1.neighbors = List.of(n2, n3, n4);
        n2.neighbors = List.of(n1, n3, n4);
        n3.neighbors = List.of(n1, n2, n4);
        n4.neighbors = List.of(n1, n2, n3);

        // Run the test
        final Node result = solution0133UnderTest.cloneGraph(n1);

        // Verify the results
        assertEquals(1, result.val);
    }

}
