package cn.qiushile.leetcode.easy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Solution0953Test {

    private Solution0953 solution0953UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0953UnderTest = new Solution0953();
    }

    @Test
    public void testIsAlienSorted01() {
        assertTrue(solution0953UnderTest.isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }

    @Test
    public void testIsAlienSorted02() {
        assertFalse(solution0953UnderTest.isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
    }

    @Test
    public void testIsAlienSorted03() {
        assertFalse(solution0953UnderTest.isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
