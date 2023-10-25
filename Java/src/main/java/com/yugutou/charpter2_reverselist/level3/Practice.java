package com.yugutou.charpter2_reverselist.level3;

public class Practice {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        ListNode nodeA = initLinkedList(a);

        ListNode d = null;

//        d = reverseKGroup2(nodeA, 3);
        d = reverseKGroup(nodeA, 3);
        System.out.println(toString(d));
    }

    /**
     * 头插法
     *
     * @param head 头结点
     * @param k    长度
     * @return 链表
     */
    public static ListNode reverseKGroup2(ListNode head, int k) {
        // 1.创建虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;

        // 2.遍历链表查看到底需要翻转几次
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        int n = len / k;

        // 从头开始计算
        cur = head;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k - 1; j++) { // 只需要反转 k-1 次 123 -> 213 -> 321
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            // 每次内层循环最终会落在最后一个位置上
            pre = cur;
            cur = cur.next;
        }


        return dummyHead.next;
    }

    /**
     * 逆序
     *
     * @param head 头结点
     * @param k    长度
     * @return 链表
     * 每次循环需要找到 pre next right right.next
     */
    public static ListNode reverseKGroup(ListNode head, int k) {

        // 1.创建虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;


        // 2.查找长度看需要遍历几次
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        int n = len / k;

        ListNode pre = dummyHead;
        ListNode end = dummyHead;

        for (int i = 0; i < n; i++) {
            // 1.每次循环先将end循环到最后一个k节点
            for (int j = 0; j < k; j++) {
                end = end.next;
            }

            // 记录开始节点和结束节点的后一个节点
            ListNode start = pre.next;
            ListNode next = end.next;

            // 一定要断链
            end.next = null;

            // 2.反转链表
            // pre连原来的尾
            pre.next = reverse(start);
            ;
            // start连之前的尾的下一个节点
            start.next = next;

            // 3.刷新节点
            pre = start;
            end = pre;
        }
        return dummyHead.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
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
