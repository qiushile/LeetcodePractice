package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Solution1616Test {

    private Solution1616 solution1616UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1616UnderTest = new Solution1616();
    }

    @Test
    public void testCheckPalindromeFormation01() {
        assertTrue(solution1616UnderTest.checkPalindromeFormation("x", "y"));
    }

    @Test
    public void testCheckPalindromeFormation02() {
        assertFalse(solution1616UnderTest.checkPalindromeFormation("xbdef", "xecab"));
    }

    @Test
    public void testCheckPalindromeFormation03() {
        assertTrue(solution1616UnderTest.checkPalindromeFormation("ulacfd", "jizalu"));
    }

    @Test
    public void testCheckPalindromeFormation36() {
        assertTrue(solution1616UnderTest.checkPalindromeFormation("abdef", "fecab"));
    }

    @Test
    public void testCheckPalindromeFormation37() {
        assertFalse(solution1616UnderTest.checkPalindromeFormation("abda", "acmc"));
    }

    @Test
    public void testCheckPalindromeFormation39() {
        assertTrue(solution1616UnderTest.checkPalindromeFormation("pvhmupgqeltozftlmfjjde", "yjgpzbezspnnpszebzmhvp"));
    }
}
