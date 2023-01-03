package cn.qiushile.leetcode.easy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution0944Test {

    private Solution0944 solution0944UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0944UnderTest = new Solution0944();
    }

    @Test
    public void testMinDeletionSize01() {
        assertEquals(1, solution0944UnderTest.minDeletionSize(new String[]{"cba","daf","ghi"}));
    }

    @Test
    public void testMinDeletionSize02() {
        assertEquals(0, solution0944UnderTest.minDeletionSize(new String[]{"a","b"}));
    }

    @Test
    public void testMinDeletionSize03() {
        assertEquals(3, solution0944UnderTest.minDeletionSize(new String[]{"zyx","wvu","tsr"}));
    }
}
