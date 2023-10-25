package com.yugutou.charpter2_reverselist.level2.topic2_3链表加1;

public class Practice {
    public static void main(String[] args) {
//        int[] a = {7, 8};
        int[] a = {9,9,9};
//        int[] a = {1, 2, 3};
        ListNode nodeA = initLinkedList(a);

        ListNode node = onePlus(nodeA);

        System.out.println(toString(node));

    }

    private static ListNode onePlus(ListNode head) {

        ListNode dummyHead = new ListNode(-1);

        // 1.翻转链表获取
        ListNode reverseList = reverse(head);

        ListNode cur = reverseList;

        // 加数
        int addNum = 1;
        // 进位
        int carry = 0;

        while (cur != null) {
            int digist = cur.val;
            int sum = digist + addNum + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;

            // 反转回来
            ListNode newNode = new ListNode(sum);
            newNode.next = dummyHead.next;
            dummyHead.next = newNode;
            addNum = 0;

            cur = cur.next;
        }
        if (carry == 1) {
            ListNode newNode = new ListNode(1);
            newNode.next = dummyHead.next;
            dummyHead.next = newNode;
        }

        return dummyHead.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
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
