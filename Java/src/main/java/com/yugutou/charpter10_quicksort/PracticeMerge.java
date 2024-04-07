package com.yugutou.charpter10_quicksort;

import java.util.Arrays;

public class PracticeMerge {

    public static void main(String[] args) {
        int[] array = {6, 3, 2, 1, 4, 5, 8, 7};
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 归并排序
     *
     * @param array 需要排序的数组
     * @param start 起始位置
     * @param end   结束位置
     * @param temp  临时数组用于存放数组元素
     */
    static void mergeSort(int[] array, int start, int end, int[] temp) {
        // 1.最后一个元素不需要排序 所以我们只需要考虑两个及以上即可
        if (start < end) {
            int mid = start + ((end - start) >> 1);

            // 先归
            mergeSort(array, start, mid, temp);
            mergeSort(array, mid + 1, end, temp);
            // 后并
            merge(array, start, mid, end, temp);
        }
    }

    static void merge(int[] array, int start, int mid, int end, int[] temp) {
        // 记录开始的节点位置
        int left = start;
        int right = mid + 1;
        int pos = start;
        // 第一次合并是通过辅助数组排序
        while (left <= mid && right <= end) {
            if (array[left] < array[right]) {
                temp[pos++] = array[left++];
            } else {
                temp[pos++] = array[right++];
            }
        }

        while (left <= mid) {
            temp[pos++] = array[left++];
        }
        while (right <= end) {
            temp[pos++] = array[right++];
        }

        // 第二次排序是对原数组进行排序
        while (start <= end) {
            array[start] = temp[start];
            start ++;
        }
    }
}
