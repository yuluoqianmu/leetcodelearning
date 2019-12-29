package com.shml.leetcode.page1_20;


import com.shml.leetcode.common.ListNode;

public class RemoveNthFromEnd_19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy, end = dummy;
        while (n != 0 ){
            start = start.next;
            n--;
        }
        while (start.next != null){
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i=1; i<5; i++) {
            ListNode node = new ListNode(1);
            cur.next = node;
            cur = node;
        }
        ListNode resultNode = removeNthFromEnd(head, 2);
        System.out.println(resultNode.val);

    }
}
