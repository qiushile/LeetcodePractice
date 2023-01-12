package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Solution1807Test {

    private Solution1807 solution1807UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1807UnderTest = new Solution1807();
    }

    @Test
    public void testEvaluate01() {
        assertEquals("bobistwoyearsold", solution1807UnderTest.evaluate("(name)is(age)yearsold", List.of(List.of("name","bob"),List.of("age","two"))));
    }

    @Test
    public void testEvaluate02() {
        assertEquals("hi?", solution1807UnderTest.evaluate("hi(name)", List.of(List.of("a","b"))));
    }

    @Test
    public void testEvaluate03() {
        assertEquals("yesyesyesaaa", solution1807UnderTest.evaluate("(a)(a)(a)aaa", List.of(List.of("a","yes"))));
    }
}
