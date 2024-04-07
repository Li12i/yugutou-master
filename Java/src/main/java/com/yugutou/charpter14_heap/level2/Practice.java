package com.yugutou.charpter14_heap.level2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 找最大用小堆，找最小用大堆
 */
public class Practice {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
//        System.out.println(findKLarge(arr, k));

        int[] arr1 = new int[]{1,3,5,7,2,4,6,8};
        for (int i : findSmall(arr1, k)) {
            System.out.println(i);
        }


    }

    public static int findKLarge(int[] nums, int k) {

        if (k > nums.length) return -1;

        int len = nums.length;
        // 创建一个含有k个元素的最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);

        // 当堆不满的时候直接塞
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        for (int i = k; i < len; i++) {
            Integer peek = minHeap.peek();
            // 只有比他大的值才能塞
            if (nums[i] > peek) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();
    }

    public static int[] findSmall(int[] nums, int k) {
        if (k > nums.length) return new int[]{};

        int len = nums.length;
        // 创建一个含有k个元素的最大堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> b - a);

        // 当堆不满的时候直接塞
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        for (int i = k; i < len; i++) {
            Integer peek = minHeap.peek();
            // 只有比他小的值才能塞
            if (nums[i] < peek) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        int size = minHeap.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = minHeap.poll();
        }

        return res;
    }

}
