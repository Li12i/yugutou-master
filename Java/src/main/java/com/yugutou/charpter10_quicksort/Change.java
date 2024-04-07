package com.yugutou.charpter10_quicksort;

import java.util.Arrays;

public class Change {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 3, 7, 6, 1, 8, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] nums, int left, int right) {
        // 当只有一个元素的时候不需要
        if (left >= right) return;

        int indexRight = right;
        int pivot = nums[left];
        while (left < indexRight) {
            // 找到第一个比该元素小的元素
            while (left < indexRight && nums[right] >= pivot) {
                indexRight--;
            }
            nums[left] = nums[indexRight];
            while (left < indexRight && nums[left] <= pivot) {
                left++;
            }
            nums[indexRight] = nums[left];
        }
        nums[left] = pivot;

        // 左
        quickSort(nums, 0, left);
        quickSort(nums, left + 1, right);
    }
}
