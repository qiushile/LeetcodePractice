package cn.qiushile.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 752. Open the Lock
 * Medium
 * 3.4K
 * 125
 * Companies
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
 * Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 * Example 1:
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 * because the wheels of the lock become stuck after the display becomes the dead end "0102".
 * Example 2:
 * Input: deadends = ["8888"], target = "0009"
 * Output: 1
 * Explanation: We can turn the last wheel in reverse to move from "0000" -> "0009".
 * Example 3:
 * Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * Output: -1
 * Explanation: We cannot reach the target without getting stuck.
 * Constraints:
 * 1 <= deadends.length <= 500
 * deadends[i].length == 4
 * target.length == 4
 * target will not be in the list deadends.
 * target and deadends[i] consist of digits only.
 * Accepted
 * 192.2K
 * Submissions
 * 345.9K
 * Acceptance Rate
 * 55.5%
 * Runtime 57 ms Beats 94.24% Memory 43.3 MB Beats 96.53%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/9
 */
public class Solution0752 {
    public int openLock(String[] deadends, String target) {
        Integer tar = Integer.parseInt(target);
        if (tar.equals(0)) {
            return 0;
        }

        Set<Integer> visited = new HashSet<>();
        for (String deadend : deadends) {
            visited.add(Integer.parseInt(deadend));
        }
        if (visited.contains(0)) {
            return -1;
        }
        int count = 0;
        Set<Integer> curr = new HashSet<>();
        curr.add(0);
        visited.add(0);
        Set<Integer> next = new HashSet<>();
        while (!curr.isEmpty()) {
            count++;
            for (Integer num : curr) {
                int[] nums = getNextStep(num);
                for (int n : nums) {
                    if (!visited.contains(n)) {
                        if (tar.equals(n)) {
                            return count;
                        }
                        next.add(n);
                    }
                }
            }
            visited.addAll(next);
            curr = next;
            next = new HashSet<>();
        }
        return -1;
    }

    public int[] getNextStep(int num) {
        return new int[]{
                (num + 1000) % 10000, (num + 9000) % 10000,
                (num % 1000 < 900)? num + 100: num - 900, (num % 1000 < 100? num + 900: num - 100),
                (num % 100 < 90)? num + 10: num - 90, (num % 100 < 10? num + 90: num - 10),
                (num % 10 < 9)? num + 1: num - 9, (num % 10 < 1? num + 9: num - 1)};
    }
}
