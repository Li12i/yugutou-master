package com.yugutou.charpter10_quicksort;

import java.util.Arrays;

/**
 *
 */
public class QuickSortBasic {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 3, 7, 6, 1, 8, 4};
        quickSort1(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = arr[right];
            int i = left - 1;
            for (int j = left; j < right; j++) {
                if (arr[j] < pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            //哨兵移动到位置pivotIndex上
            int pivotIndex = i + 1;
            int temp = arr[pivotIndex];
            arr[pivotIndex] = arr[right];
            arr[right] = temp;

            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    public static void quickSort1(int[] arr, int left, int right) {
        // 记录右节点
        int indexRight = right;
        if (left < right) {
            int pivot = arr[left];
            while (left < right) {
                // 找到第一个比目标节点小的元素
                while (left < right && arr[right] >= pivot) {
                    right--;
                }
                arr[left] = arr[right];
                // 找到第一个比目标节点大的元素
                while (left < right && arr[left] <= pivot) {
                    left++;
                }
                arr[right] = arr[left];
            }
            // 赋值
            arr[left] = pivot;

            quickSort1(arr, 0, left - 1);
            quickSort1(arr, left + 1, indexRight);
        }
    }



}
