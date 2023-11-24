package com.yugutou.charpter2_reverselist;

public class Change {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        ListNode nodeA = initLinkedList(a);

        ListNode res = help(nodeA);
        System.out.println(toString(res));
    }

    /**
     * 将偶数位的数据进行翻转 1
     *
     * @param head
     * @return
     */
    public static ListNode help(ListNode head) {

        if (head == null) return null;

        // 1.获取所有偶数项
        ListNode odd = head;
        ListNode even = head.next;
        ListNode curseOdd = odd;//游标A
        ListNode curseEven = even;//游标B

        while (curseEven != null) {
            if (curseEven.next != null) {
                curseOdd.next = curseEven.next;
                curseOdd = curseOdd.next;
                curseEven.next = curseOdd.next;
                curseEven = curseEven.next;
            } else {
                curseOdd.next = null;
                curseEven.next = null;
                break;
            }
        }

        // 2.翻转
        even = reverse(even);

        // 重置到开头节点
        curseOdd = odd;
        curseEven = even;

        // 创建结果
        ListNode ans = new ListNode(-1);
        ListNode cur = ans;

        // 合并
        int i = 1;
        while (curseOdd != null && curseEven != null) {
            if (i++ % 2 == 0) {
                cur.next = curseEven;
                curseEven = curseEven.next;
                cur = cur.next;
            } else {
                cur.next = curseOdd;
                curseOdd = curseOdd.next;
                cur = cur.next;
            }
        }
        cur.next = curseOdd != null ? curseOdd : curseEven;

        return ans.next;
    }

    // 头插法
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
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
