package com.shml.swordoffer;

import com.shml.leetcode.common.ListNode;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList_35 {

    public class Node {
        private int val;
        private Node next;
        private Node random;
        public Node(int x) {
            this.val = x;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        if (head == null)
            return null;

        Node cur = head;
        Map<Node, Node> map = new HashMap<>();

        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;

        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public Node copyRandomList_2(Node head) {

        if (head == null)
            return null;

        Node cur = head;

        while (cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }

        cur = head;

        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head.next;
        Node pre = head, res = head.next;

        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }

        pre.next = null;

        return res;
    }



}
