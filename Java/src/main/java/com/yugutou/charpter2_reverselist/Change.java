package com.yugutou.charpter2_reverselist;

import com.yugutou.charpter2_reverselist.level3.Practice;

public class Change {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode nodeA = initLinkedList(a);

        System.out.println(toString(nodeA));
    }

    /**
     * 将偶数位的数据进行翻转 1
     * @param head
     * @return
     */
    public static ListNode help(ListNode head) {

        if(head == null) return null;

        // 现将偶数 个 数据进行 获取反转，在进行插入
        ListNode evenDummyHead = new ListNode(-1);

        ListNode curr = head;
        ListNode eCurr = evenDummyHead;
        int i = 1;
        while (curr != null) {
            if (i++ % 2 == 0) {
                eCurr.next = curr;
                eCurr = eCurr.next;
            }
            curr = curr.next;
        }

        // 翻转偶数链表
        evenDummyHead.next = reverse(evenDummyHead.next);

        curr = head;
        eCurr = evenDummyHead.next;

        i = 1;
        while (curr != null) {
            if (i++ % 2 == 0) {
                eCurr.next = curr.next;
                curr.next = eCurr;
                eCurr = eCurr.next;

            }
            curr = curr.next;
        }

        return null;
    }

    // 头插法
    public static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode dummyHead = new ListNode(-1);
        while (curr != null) {
            ListNode next = curr.next;
            curr = next;
            next.next = dummyHead.next;
            dummyHead.next = next;
        }
        return dummyHead.next;
    }


    /**
     * 初始化链表
     *
     * @param array
     * @return
     */
    private static ListNode initLinkedList(int[] array) {
        ListNode head = null, cur = null;

        for (int i = 0; i < array.length; i++) {
            ListNode newNode = new ListNode(array[i]);
            newNode.next = null;
            if (i == 0) {
                head = newNode;
                cur = head;
            } else {
                cur.next = newNode;
                cur = newNode;
            }
        }
        return head;
    }

    /**
     * 输出链表
     *
     * @param head 头节点
     */
    public static String toString(ListNode head) {
        ListNode current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.val).append("\t");
            current = current.next;
        }
        return sb.toString();
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
