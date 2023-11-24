package com.yugutou.charpter5_queue_map.level3;

import java.util.HashMap;
import java.util.Map;

public class PracticeLRU {
    // 我们需要记录他的容量、大小、头尾节点、对应的Map集合
    // 在构建时初始化
    private Map<Integer, Node> cache;
    private int capacity;
    private int size;
    private Node head, tail;

    // 构造函数 构造时初始化
    public PracticeLRU(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    /**
     * @param key 值
     * @return 值
     * 判断是否存在该值
     * 1.如果不存在，直接返回-1
     * 2.如果存在，则返回值，并将该值放在链表表头位置
     */
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        moveToHead(node);
        return node.key;
    }

    /**
     * 插入节点
     * 判断是否存在，如果存在，则直接移到开头
     * 否则插入新节点，并判断删除尾节点
     */
    public void put(int key) {
        Node node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            Node newNode = new Node(key);
            // 放入缓存中
            cache.put(key, newNode);
            // 添加到头节点
            addToHead(newNode);
            ++size;
            // 如果容量超出 则 移除底部元素 并 删除map中的值
            if (size > capacity) {
                Node tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            moveToHead(node);
        }
    }

    /**
     * 将元素删除
     * 将元素插入到头节点
     */
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private Node removeTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

    public static void main(String[] args) {
        PracticeLRU PracticeLRU = new PracticeLRU(2);
        PracticeLRU.put(1); // 缓存是 {1=1}
        PracticeLRU.put(2); // 缓存是 {1=1, 2=2}
        System.out.println(PracticeLRU.get(1));    // 返回 1
        PracticeLRU.put(3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(PracticeLRU.get(2));    // 返回 -1 (未找到)
        PracticeLRU.put(4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(PracticeLRU.get(1));    // 返回 -1 (未找到)
        System.out.println(PracticeLRU.get(3));    // 返回 3
        System.out.println(PracticeLRU.get(4));    // 返回 4
    }
}

// 节点
class Node {
    int key;

    Node prev;

    Node next;

    public Node(int key) {
        this.key = key;
    }

    public Node() {

    }

}
