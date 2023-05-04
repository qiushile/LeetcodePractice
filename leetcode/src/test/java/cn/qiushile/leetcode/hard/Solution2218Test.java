package cn.qiushile.leetcode.hard;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/4/16
 */
public class Solution2218Test {

    private Solution2218 solution = new Solution2218();

    @Test
    public void maxValueOfCoins01() {

        assertEquals(101, solution.maxValueOfCoins(List.of(List.of(1,100,3), List.of(7,8,9)), 2));
    }

    @Test
    public void maxValueOfCoins02() {
        assertEquals(706, solution.maxValueOfCoins(
                List.of(List.of(100),List.of(100),List.of(100),List.of(100),List.of(100),List.of(100),List.of(100),
                        List.of(1,1,1,1,1,1,700)), 7));
    }
}
