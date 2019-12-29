package com.shml.leetcode.page200_220;

import com.shml.leetcode.common.ListNode;

/**
 * Created by shaoml on 2019/7/24.
 */
public class reverseList_206 {

    public ListNode reverseList(ListNode head) {

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
}
