package com.shml.leetcode.common;

import com.shml.leetcode.page1_20.RemoveNthFromEnd_19;

/**
 * 定义链表的节点
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }


    /**
     * 添加一个节点
     * @param val
     */
    public void addNode(int val) {

        ListNode newNode = new ListNode(val);

        if (this.next == null) {
            this.next = newNode;
        } else {
            this.next.addNode(val);
        }
    }

    /**
     * 打印链表
     */
    public void printList() {
        System.out.print(this.val);
        if (this.next != null) {
            System.out.print("-->");
            this.next.printList();
        }
    }
}
