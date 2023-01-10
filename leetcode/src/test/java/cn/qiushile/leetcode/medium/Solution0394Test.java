package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution0394Test {

    private Solution0394 solution0394UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0394UnderTest = new Solution0394();
    }

    @Test
    public void testDecodeString01() {
        assertEquals("aaabcbc", solution0394UnderTest.decodeString("3[a]2[bc]"));
    }

    @Test
    public void testDecodeString02() {
        assertEquals("accaccacc", solution0394UnderTest.decodeString("3[a2[c]]"));
    }

    @Test
    public void testDecodeString03() {
        assertEquals("abcabccdcdcdef", solution0394UnderTest.decodeString("2[abc]3[cd]ef"));
    }
}
