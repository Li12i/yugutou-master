package com.yugutou.charpter1_linklist.level2.topic2_1第一个公共结点;

import com.yugutou.charpter1_linklist.level1.BasicLink;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author goatli
 */
public class practice {
    public static void main(String[] args) {
        ListNode[] heads = initLinkedList();
        //la 为 1 2 3 4 5
        //lb 为 11 22 4 5
        ListNode la = heads[0];
        ListNode lb = heads[1];

        int testMethod = 4;
        ListNode node = new ListNode(0);
        switch (testMethod) {
            case 1: //方法1：通过Hash辅助查找
                node = findFirstCommonNodeByMap(la, lb);
                break;
            case 2: //方法2：通过集合辅助查找
                node = findFirstCommonNodeBySet(la, lb);
                break;
//            case 3://方法3：通过栈辅助查找
//                node = findFirstCommonNodeByStack(la, lb);
//                break;
            case 4://方法4：通过拼接辅助查找
                node = findFirstCommonNodeByCombine(la, lb);
                break;
//            case 5://方法5：通过差辅助查找
//                node = findFirstCommonNodeBySub(la, lb);
//                break;
        }
        System.out.println("公共结点为：" + node.val);
    }

    /**
     * 通过Hash辅助查找
     *
     * @return same ListNode
     */
    public static ListNode findFirstCommonNodeByMap(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode current1 = pHead1;
        ListNode current2 = pHead2;

        HashMap<ListNode, Integer> hashMap = new HashMap<>();
        while (current1 != null) {
            hashMap.put(current1, null);
            current1 = current1.next;
        }

        while (current2 != null) {
            if (hashMap.containsKey(current2)) {
                return current2;
            }
            current2 = current2.next;
        }
        return null;
    }

    /**
     * 通过集合来辅助查找
     *
     * @param headA 头节点1
     * @param headB 头结点2
     * @return same ListNode
     */
    public static ListNode findFirstCommonNodeBySet(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode current1 = headA;
        ListNode current2 = headA;

        // 创建两个栈
        Stack<ListNode> stackA = new Stack();
        Stack<ListNode> stackB = new Stack();

        while (current1 != null) {
            stackA.push(current1);
            current1 = current1.next;
        }
        while (current2 != null) {
            stackB.push(current2);
            current2 = current2.next;
        }
        ListNode preNode = null;
        while (stackB.size() > 0 && stackA.size() > 0) {
            if (stackA.peek() == stackB.peek()) {
                preNode = stackA.pop();
                stackB.pop();
            } else {
                break;
            }
        }
        return preNode;
    }

    public static ListNode findFirstCommonNodeByCombine(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) {
                if (p1 == null) {
                    p1 = pHead2;
                }
                if (p2 == null) {
                    p2 = pHead1;
                }
            }
        }
        return p1;
    }

    public static ListNode findWithTwoPoint(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;

        ListNode temp1 = pHead1, temp2 = pHead2;
        int head1Len = 0, head2Len = 0;

        while (temp1 != null) {
            temp1 = temp1.next;
            head1Len++;
        }

        while (temp2 != null) {
            temp2 = temp2.next;
            head2Len++;
        }

        ListNode cur = pHead1;
        ListNode cur2 = pHead2;
        int len = head1Len - head2Len > 0 ? head1Len - head2Len : head2Len - head1Len;

        if (head1Len > head2Len) {
            int a = 0;
            while (len > a++) {
                cur = cur.next;
            }
        }

        if (head2Len > head1Len) {
            int a = 0;
            while (len > a++) {
                cur2 = cur2.next;
            }
        }

        while (cur2 != cur) {
            cur2 = cur2.next;
            cur = cur.next;
        }
        return cur;
    }

    // 初始化连表
    static ListNode[] initLinkedList() {
        ListNode[] heads = new ListNode[2];
        // 1 -> 2 -> 3
        heads[0] = new ListNode(1);
        // 记录当前头节点
        ListNode current1 = heads[0];
        current1.next = new ListNode(2);
        current1 = current1.next;
        current1.next = new ListNode(3);
        current1 = current1.next;

        heads[1] = new ListNode(11);
        ListNode current2 = heads[1];
        current2.next = new ListNode(22);
        current2 = current2.next;

        // 构造相同的部分
        ListNode node4 = new ListNode(4);
        current1.next = node4;
        current2.next = node4;
        node4.next = new ListNode(5);
        node4.next.next = new ListNode(6);
        return heads;
    }

    private static ListNode initLinkedList(int[] array) {
        ListNode head = null, cur = null;
        for (int i = 0; i < array.length; i++) {
            ListNode newNode = new ListNode(array[i]);
            newNode.next = null;
            if (i == 0) {
                head = newNode;
                cur = newNode;
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
