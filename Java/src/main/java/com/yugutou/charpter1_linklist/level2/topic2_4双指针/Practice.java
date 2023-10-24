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

        int len = 0;

        ListNode lenNode = head;
        ListNode fast = head;
        ListNode slow = head;
        // 遍历获取长度
        while (lenNode != null) {
            len++;
            lenNode = lenNode.next;
        }

        if (k % len == 0) {
            return head;
        }

        while (k-- % len > 0) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode res = slow.next;
        fast.next = head;
        res.next = null;

        return null;
    }

    /**
     * 寻找第一个公共子节点 拼接
     *
     * @param head  第一个链表
     * @param head2 第二个链表
     */
    public static ListNode findFirstWithStr(ListNode head, ListNode head2) {

        if (head == null || head2 == null) return null;

        ListNode p1 = head;
        ListNode p2 = head2;

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;

            if (p1 != p2) {
                if (p1 == null) {
                    p1 = head2;
                }

                if (p2 == null) {
                    p2 = head;
                }
            }

        }
        return p1;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
