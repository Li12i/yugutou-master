package com.yugutou.charpter2_reverselist.level2.topic2_2两两反转;

public class Practice {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        ListNode listNode = initLinkedList(a);
        ListNode res = null;

        res = swapPairs(listNode);
        System.out.println(toString(res));
    }

    /**
     * 两两反转操作
     * @param head 头结点
     * @return 头结点
     */
    public static ListNode swapPairs(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode temp = dummyHead;

        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;

            node1.next = node2.next;
            node2.next = node1;
            temp.next = node2;
            temp = node1; // 指针要按照原先的排序后移
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
