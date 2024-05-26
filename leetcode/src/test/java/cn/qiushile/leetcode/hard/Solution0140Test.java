package cn.qiushile.leetcode.hard;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2024/5/26
 */
public class Solution0140Test {

    Solution0140 solution = new Solution0140();

    @Test
    public void wordBreak() {
        assertEquals(2, solution.wordBreak("catsanddog", List.of("cat","cats","and","sand","dog")).size());
    }
}
