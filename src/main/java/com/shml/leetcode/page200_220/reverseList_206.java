package com.shml.leetcode.page200_220;

import com.shml.leetcode.common.ListNode;

/**
 * Created by shaoml on 2019/7/24.
 */
public class reverseList_206 {

    public static  ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {

            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;

    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        for (int i = 2; i<=5; i++) {
            l1.addNode(i);
        }
        l1.printList();
        System.out.println(" ");

        ListNode result = reverseList(l1);

        result.printList();
    }
}
