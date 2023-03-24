package cn.qiushile.leetcode.hard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Solution1032Test {

    private Solution1032.StreamChecker streamChecker;

    @Test
    public void testcase() throws Exception {
        streamChecker = new Solution1032.StreamChecker(new String[]{"cd", "f", "kl"});
        assertFalse(streamChecker.query('a'));
        assertFalse(streamChecker.query('b'));
        assertFalse(streamChecker.query('c'));
        assertTrue(streamChecker.query('d'));
        assertFalse(streamChecker.query('e'));
        assertTrue(streamChecker.query('f'));
        assertFalse(streamChecker.query('g'));
        assertFalse(streamChecker.query('h'));
        assertFalse(streamChecker.query('i'));
        assertFalse(streamChecker.query('j'));
        assertFalse(streamChecker.query('k'));
        assertTrue(streamChecker.query('l'));
    }

    @Test
    public void testcase08() throws Exception {
        streamChecker = new Solution1032.StreamChecker(new String[]{"ab","ba","aaab","abab","baa"});
        assertFalse(streamChecker.query('a'));
        assertFalse(streamChecker.query('a'));
        assertFalse(streamChecker.query('a'));
        assertFalse(streamChecker.query('a'));
        assertFalse(streamChecker.query('a'));

        assertTrue(streamChecker.query('b'));
        assertTrue(streamChecker.query('a'));
        assertTrue(streamChecker.query('b'));
        assertTrue(streamChecker.query('a'));
        assertTrue(streamChecker.query('b'));

        assertFalse(streamChecker.query('b'));
        assertFalse(streamChecker.query('b'));
        assertTrue(streamChecker.query('a'));
        assertTrue(streamChecker.query('b'));
        assertTrue(streamChecker.query('a'));

        assertTrue(streamChecker.query('b'));
        assertFalse(streamChecker.query('b'));
        assertFalse(streamChecker.query('b'));
        assertFalse(streamChecker.query('b'));
        assertTrue(streamChecker.query('a'));

        assertTrue(streamChecker.query('b'));
        assertTrue(streamChecker.query('a'));
        assertTrue(streamChecker.query('b'));
        assertTrue(streamChecker.query('a'));
        assertTrue(streamChecker.query('a'));


        assertFalse(streamChecker.query('a'));
        assertTrue(streamChecker.query('b'));
        assertTrue(streamChecker.query('a'));
        assertTrue(streamChecker.query('a'));
        assertFalse(streamChecker.query('a'));
    }
}
