package cn.qiushile.leetcode.hard;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class Solution1096Test {

    private Solution1096 solution1096UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1096UnderTest = new Solution1096();
    }

    @Test
    public void testBraceExpansionII01() {
        assertEquals(Arrays.asList("ac", "ad", "ae", "bc", "bd", "be"), solution1096UnderTest.braceExpansionII("{a,b}{c,{d,e}}"));
    }

    @Test
    public void testBraceExpansionII02() {
        assertEquals(Arrays.asList("a","ab","ac","z"), solution1096UnderTest.braceExpansionII("{{a,z},a{b,c},{ab,z}}"));
    }

    @Test
    public void testBraceExpansionII75() {
        assertEquals(Arrays.asList("acdf","acef","bcdf","bcef"), solution1096UnderTest.braceExpansionII("{a,b}c{d,e}f"));
    }

    @Test
    public void testBraceExpansionII104() {
        assertEquals(Arrays.asList("a","aiaw","aow","axw","er","g","ia","n","o","u","w","x"), solution1096UnderTest.braceExpansionII("{a{x,ia,o}w,{n,{g,{u,o}},{a,{x,ia,o},w}},er}"));
    }
}
