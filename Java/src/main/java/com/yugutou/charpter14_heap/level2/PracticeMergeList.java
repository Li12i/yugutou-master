package com.yugutou.charpter14_heap.level2;

import com.yugutou.charpter1_linklist.level1.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 23. 合并 K 个升序链表
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 */
public class PracticeMergeList {

    public static void main(String[] args) {

    }

    public static ListNode mergeKList(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparing(node -> node.val));
        for (int i = 0; i < lists.length; i++) {
            q.add(lists[i]);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!q.isEmpty()) {
            tail.next = q.poll();
            tail = tail.next;
            if (tail.next != null) {
                q.add(tail.next);
            }
        }
        return dummy.next;
    }
}
