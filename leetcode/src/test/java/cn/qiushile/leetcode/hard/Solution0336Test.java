package cn.qiushile.leetcode.hard;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/5/4
 */
public class Solution0336Test {

    Solution0336 solution = new Solution0336();

    @Test
    public void palindromePairs1() {
        String[] words = new String[]{"abcd","dcba","lls","s","sssll"};
        assertEquals(List.of(List.of(0,1),List.of(1,0),List.of(3,2),List.of(2,4)).stream().collect(Collectors.toSet()),
                solution.palindromePairs(words).stream().collect(Collectors.toSet()));
    }

    @Test
    public void palindromePairs2() {
        String[] words = new String[]{"bat","tab","cat"};
        assertEquals(List.of(List.of(0,1),List.of(1,0)).stream().collect(Collectors.toSet()),
                solution.palindromePairs(words).stream().collect(Collectors.toSet()));
    }

    @Test
    public void palindromePairs3() {
        String[] words = new String[]{"a",""};
        assertEquals(List.of(List.of(0,1),List.of(1,0)).stream().collect(Collectors.toSet()),
                solution.palindromePairs(words).stream().collect(Collectors.toSet()));
    }

    @Test
    public void palindromePairs026() {
        String[] words = new String[]{"a","b","c","ab","ac","aa"};
        assertEquals(List.of(List.of(3,0),List.of(1,3),List.of(4,0),List.of(2,4),List.of(5,0),List.of(0,5)).stream().collect(Collectors.toSet()),
                solution.palindromePairs(words).stream().collect(Collectors.toSet()));
    }
}
