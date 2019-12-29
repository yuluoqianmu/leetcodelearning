package com.shml.leetcode.page1_20;

/**
 * ### [19\. 删除链表的倒数第N个节点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)

 Difficulty: **中等**


 给定一个链表，删除链表的倒数第 _n _个节点，并且返回链表的头结点。

 **示例：**

 ```
 给定一个链表: 1->2->3->4->5, 和 n = 2.

 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 ```
 */

import com.shml.leetcode.common.ListNode;

public class RemoveNthFromEnd_19 {

    /**
     * 思路：使用以前以后两个指针，两个指针的距离相差n
     * @param head
     * @param n
     * @return
     */
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
