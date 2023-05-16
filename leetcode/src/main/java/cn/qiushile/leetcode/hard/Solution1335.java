package cn.qiushile.leetcode.hard;

import java.util.PriorityQueue;

/**
 * 1335. Minimum Difficulty of a Job Schedule
 * Hard
 * 2.5K
 * 228
 * Companies
 * You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, you have to finish all the jobs j where 0 <= j < i).
 * You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done on that day.
 * You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].
 * Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
 * Example 1:
 * Input: jobDifficulty = [6,5,4,3,2,1], d = 2
 * Output: 7
 * Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
 * Second day you can finish the last job, total difficulty = 1.
 * The difficulty of the schedule = 6 + 1 = 7
 * Example 2:
 * Input: jobDifficulty = [9,9,9], d = 4
 * Output: -1
 * Explanation: If you finish a job per day you will still have a free day. you cannot find a schedule for the given jobs.
 * Example 3:
 * Input: jobDifficulty = [1,1,1], d = 3
 * Output: 3
 * Explanation: The schedule is one job per day. total difficulty will be 3.
 * Constraints:
 * 1 <= jobDifficulty.length <= 300
 * 0 <= jobDifficulty[i] <= 1000
 * 1 <= d <= 10
 * @author qiushile <qiushile@sina.com>
 * @date 2023/5/16
 */
public class Solution1335 {
    class Node {
        int val;
        Node prev;
        Node next;
    }
    public int minDifficulty(int[] jobs, int d) {
        int n = jobs.length;
        if (n < d) {
            return -1;
        }
        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> weight(b) - weight(a));
        Node head = new Node();
        head.val = jobs[0];
        int sum = jobs[0];
        Node last = head;
        for (int i = 1; i < n; i++) {
            sum += jobs[i];
            Node node = new Node();
            node.val = jobs[i];
            last.next = node;
            node.prev = last;
            q.offer(last);
            last = node;
        }
        if (n == d) {
            return sum;
        }
        q.offer(last);
        while (n > d) {
            Node curr = q.poll();
            Node prev = curr.prev;
            Node next = curr.next;
            sum -= curr.val;
            if (prev != null) {
                prev.next = next;
                q.remove(prev);
                q.offer(prev);
            }
            if (next != null) {
                next.prev = prev;
                q.remove(next);
                q.offer(next);
            }
            n--;
        }
        return sum;
    }

    private int weight(Node node) {
        int w = -1;
        if (node.prev != null && node.prev.val >= node.val) {
            w = node.val;
        } else if (node.next != null && node.next.val >= node.val) {
            w = node.val;
        }
        return w;
    }
}
