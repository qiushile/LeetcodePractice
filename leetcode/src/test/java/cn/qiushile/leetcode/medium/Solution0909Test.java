package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution0909Test {

    private Solution0909 solution0909UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0909UnderTest = new Solution0909();
    }

    @Test
    public void testSnakesAndLadders03() {
        // Setup
        final int[][] board = new int[][]{{-1,-1,-1},{-1,9,8},{-1,8,9}};

        // Run the test
        final int result = solution0909UnderTest.snakesAndLadders(board);

        // Verify the results
        assertEquals(1, result);
    }

    @Test
    public void testSnakesAndLadders209() {
        // Setup
        final int[][] board = new int[][]{{-1,-1,-1,135,-1,-1,-1,-1,-1,185,-1,-1,-1,-1,105,-1},{-1,-1,92,-1,-1,-1,-1,-1,-1,201,-1,118,-1,-1,183,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,179,-1,-1,-1,-1,-1,-1},{-1,248,-1,-1,-1,-1,-1,-1,-1,119,-1,-1,-1,-1,-1,192},{-1,-1,104,-1,-1,-1,-1,-1,-1,-1,165,-1,-1,206,104,-1},{145,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,229,-1},{-1,-1,75,140,-1,-1,-1,-1,-1,-1,-1,-1,43,-1,34,-1},{-1,-1,-1,-1,-1,-1,169,-1,-1,-1,-1,-1,-1,188,-1,-1},{-1,-1,-1,-1,-1,-1,92,-1,171,-1,-1,-1,-1,-1,-1,66},{-1,-1,-1,126,-1,-1,68,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,109,-1,86,28,228,-1,-1,144,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,59,-1,-1,-1,-1,-1,51,-1,-1,-1,62,-1},{-1,71,-1,-1,-1,63,-1,-1,-1,-1,-1,-1,212,-1,-1,-1},{-1,-1,-1,-1,174,-1,59,-1,-1,-1,-1,-1,-1,133,-1,-1},{-1,-1,62,-1,5,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,59,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}};

        // Run the test
        final int result = solution0909UnderTest.snakesAndLadders(board);

        // Verify the results
        assertEquals(10, result);
    }
}
