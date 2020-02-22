package com.shml.leetcode.page21_40;

import com.shml.leetcode.common.ListNode;

public class SwapPairs_24 {

    /**
     * ### [24\. 两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)
     *
     * Difficulty: **中等**
     *
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * **你不能只是单纯的改变节点内部的值**，而是需要实际的进行节点交换。
     *
     * **示例:**
     *
     * ```
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     * ```
     *
     * 递归解法
     * ```
     * @param head
     * @return
     */

    public static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;

    }

    /**
     * 非递归方法
     * @param head
     */
    public static ListNode swapPairs_2(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;

        while (temp.next!=null && temp.next.next!=null) {

            ListNode start = temp.next;
            ListNode end  = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;

        }
        return pre.next;
    }


    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        for (int i = 2; i<=5; i++) {
            l1.addNode(i);
        }
        l1.printList();
        System.out.println(" ");
        ListNode ret = swapPairs_2(l1);

        ret.printList();
    }
}
