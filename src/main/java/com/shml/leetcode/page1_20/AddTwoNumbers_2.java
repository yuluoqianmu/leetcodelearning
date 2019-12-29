package com.shml.leetcode.page1_20;

import com.shml.leetcode.common.ListNode;

public class AddTwoNumbers_2 {
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * <p>
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);

        ListNode cur = dummy;

        int carry = 0;

        while(l1!=null || l2!=null) {
            int d1 = l1 == null ? 0 : l1.val;
            int d2 = l2 == null ? 0 : l2.val;

            int sum = d1 + d2 + carry;

            carry = sum >= 10 ? 1 : 0;

            cur.next = new ListNode(sum % 10);

            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }

        if (carry == 1) {
            cur.next = new ListNode(1);
        }

        return dummy.next;
    }



}
