package com.yugutou.charpter2_reverselist.level2.topic2_1指定区间反转;

import java.util.List;

public class Practice {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        ListNode listNode = initLinkedList(a);

        ListNode res = null;

//        res = reverseBetween(listNode, 2, 4);

        res = reverseBetween2(listNode, 2, 4);

        System.out.println(toString(res));
    }

    /**
     * 通过逆序插入的方式实现
     *
     * @param head  头结点
     * @param left  左
     * @param right 右
     * @return 头结点
     */
    private static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 寻找到 left前节点 和 right后节点 防止断链
        ListNode pre = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // 记录要开始操作的左边节点
        ListNode leftNode = pre.next;

        // 多走一步走到right的位置
        ListNode rightNode = pre;
        for (int i = 0; i <= right - left; i++) {
            rightNode = rightNode.next;
        }
        // 记录右边节点的后一个节点放置断链
        ListNode succ = rightNode.next;
        rightNode.next = null;

        // 反转节点
        ListNode reverse = reverse(leftNode);
        pre.next = rightNode;
        leftNode.next = succ;

        return dummyHead.next;
    }

    /**
     * 通用的链式插入方法
     * @param head 头结点
     * @return 节点
     */
    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 通过头插法的方式实现
     * @param head 头结点
     * @param left 左
     * @param right 右
     * @return 头结点
     */
    private static ListNode reverseBetween2(ListNode head, int left, int right) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre  = dummyHead;

        // 先走到left的左侧
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
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
