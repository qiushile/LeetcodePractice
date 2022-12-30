package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Solution0797Test {

    private Solution0797 solution0797UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0797UnderTest = new Solution0797();
    }

    @Test
    public void testAllPathsSourceTarget01() {
        // Setup
        final int[][] graph = new int[][]{{1,2},{3},{3},{}};

        // Run the test
        final List<List<Integer>> result = solution0797UnderTest.allPathsSourceTarget(graph);

        // Verify the results
        assertEquals(List.of(List.of(0,1,3),List.of(0,2,3)), result);
    }

    @Test
    public void testAllPathsSourceTarget02() {
        // Setup
        final int[][] graph = new int[][]{{4,3,1},{3,2,4},{3},{4},{}};

        // Run the test
        final List<List<Integer>> result = solution0797UnderTest.allPathsSourceTarget(graph);

        // Verify the results
        assertEquals(List.of(List.of(0,4),List.of(0,3,4),List.of(0,1,3,4),List.of(0,1,2,3,4),List.of(0,1,4)), result);
    }
}
