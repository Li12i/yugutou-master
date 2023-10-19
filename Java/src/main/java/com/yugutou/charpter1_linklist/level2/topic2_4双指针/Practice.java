package com.yugutou.charpter1_linklist.level2.topic2_4双指针;

import java.util.List;

/**
 * @author goatli
 */
public class Practice {

    /**
     * 寻找中间节点
     *
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        // 考虑奇数偶数的情况，当为奇数时 1 2 3 4 5 快指针走到最后一个是防止空指针异常
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 寻找倒数第k个元素
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (k < 0) {
            return null;
        }

        ListNode fast = head, slow = head;
        int i = k;
        while (fast != null && i-- > 0) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 旋转链表
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 快指针先走k，慢指针再走，tmep用于存储head节点
        ListNode slow = head, fast = head, temp = head;

        // 获取长度
        int len  = 0;
        while (head != null) {
            head = head.next;
            len ++;
        }

        // 如果是刚好走len的长度 就没有变化
        if(len % k == 0) {
            return temp;
        }

        int i = k;
        while (fast != null && i-- > 0) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow到了第k个的位置
        ListNode slowNext = slow.next;
        slow.next = null;
        fast.next = temp;
        return slowNext;

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
