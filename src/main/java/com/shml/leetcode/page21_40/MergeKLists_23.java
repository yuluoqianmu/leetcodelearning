package com.shml.leetcode.page21_40;

import com.shml.leetcode.common.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *### [23\. 合并K个排序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/)
 Difficulty: **困难**
 合并 _k _个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 **示例:**
 ```
 输入:
 [
   1->4->5,
   1->3->4,
   2->6
 ]
 输出: 1->1->2->3->4->4->5->6
 ```
 */
public class MergeKLists_23 {

    /**
     * 优先级队列法
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0)
            return  null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length,
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        if (o1.val < o2.val)
                            return -1;
                        else if (o1.val == o2.val)
                            return 0;
                        else return 1;
                    }
                });
        ListNode dummy = new ListNode(0);

        ListNode p = dummy;

        for (ListNode node : lists) {
            if (node != null)
                queue.add(node);
        }

        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null)
                queue.add(p.next);
        }

        return dummy.next;
    }

    /**
     * 分治法
     * @param lists
     * @return
     */
    public ListNode mergeKLists_2(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        return merge(lists, 0, lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right)
            return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid, right);
        return mergeTwoList(l1,l2);
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {

    }
}
