package com.yugutou.charpter1_linklist.level2.topic2_2回文序列;

public class Practice {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 2, 1};
        ListNode listNode = initLinkedList(arr);
        System.out.println(isPalindromeByTwoPoints(listNode));
    }
    /**
     * 双指针方法
     * @param head 头结点
     * @return 是否
     */
    public static boolean isPalindromeByTwoPoints(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;

        // 如果快指针的下一个为空 说明他是最后一个元素
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }

        // 如果出现基数的状况
        if (fast != null) {
            slow = slow.next;
        }

        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }

        return true;
    }

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
}

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
