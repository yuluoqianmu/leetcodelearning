package com.shml.leetcode.page21_40;

import com.shml.leetcode.common.ListNode;

public class ReverseKGroup_25 {
    /**
     * ### [25\. K 个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)
     *
     * Difficulty: **困难**
     *
     *
     * 给你一个链表，每 _k _个节点一组进行翻转，请你返回翻转后的链表。
     *
     * _k _是一个正整数，它的值小于或等于链表的长度。
     *
     * 如果节点总数不是 _k _的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * **示例 :**
     *
     * 给定这个链表：`1->2->3->4->5`
     *
     * 当 _k _= 2 时，应当返回: `2->1->4->3->5`
     *
     * 当 _k _= 3 时，应当返回: `3->2->1->4->5`
     *
     * **说明 :**
     *
     * *   你的算法只能使用常数的额外空间。
     * *   **你不能只是单纯的改变节点内部的值**，而是需要实际的进行节点交换。
     *
     * @param head
     * @param k
     * @return
     */

    public static ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) {
            return  null;
        }

        ListNode a,b;
        a = b = head;

        for (int i=0; i<k; i++) {
            if (b == null){
                return head;
            }
            b = b.next;
        }

        ListNode newHead = reverse(a, b);

        a.next = reverseKGroup(b, k);

        return newHead;
    }

    public static ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, next;
        pre = null;
        cur = a;
        next = a;

        while(cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        for (int i=2; i<=5; i++) {
            head.addNode(i);
        }

        head.printList();
        System.out.println(" ");

        ListNode ret = reverseKGroup(head, 3);

        ret.printList();
    }
}
