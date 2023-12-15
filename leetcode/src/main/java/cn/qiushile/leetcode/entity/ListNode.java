package cn.qiushile.leetcode.entity;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/8/15
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
