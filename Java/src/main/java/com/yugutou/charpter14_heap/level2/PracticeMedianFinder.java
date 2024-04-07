package com.yugutou.charpter14_heap.level2;

import java.util.PriorityQueue;

public class PracticeMedianFinder {
    // 小顶堆存储较大部分的最小值
    static PriorityQueue<Integer> minHeap;
    // 大顶堆存储较小部分的最大值
    static PriorityQueue<Integer> maxHeap;

    // 初始化数据
    static void MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    // 添加数据
    public void addNum(int num) {
        // 将较大的数据存入小顶堆中
        if (minHeap.isEmpty() || num > minHeap.peek()) {
            minHeap.offer(num);
            // 如果minHeap比maxHeap多两个元素，则需要平衡数据
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(minHeap.poll());
            }
        } else {
            maxHeap.offer(num);
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else  {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}
