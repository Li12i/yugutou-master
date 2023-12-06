package com.yugutou.charpter9_bitree_bisearch;

public class Practice {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 5, 5, 8, 9};
//        System.out.println(a(arr, 5));
        System.out.println(b2(arr, 5));
//        System.out.println(c2(arr, 5));
    }

    /**
     * 找到第一个大于等于5的元素
     * 我们这里使用 左闭右开
     *
     * @param arr    数组
     * @param target 目标
     * @return 元素下表
     */
    public static int a(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        if (arr[left] > target || arr[right - 1] < target) {
            return -1;
        }
        while (left < right) {
            int middle = left + ((right - left) >> 1);
            if (arr[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return right;
    }

    /**
     * 找到第一个小于5的元素
     * 我们这里使用 左开右开
     *
     * @param arr    数组
     * @param target 目标
     * @return 元素下标
     */
    public static int b(int[] arr, int target) {
        int left = -1;
        int right = arr.length;
        while (left + 1 != right) {
            int middle = left + ((right - left) >> 1);
            if (arr[middle] < target) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return left;
    }

    public static int b2(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int middle = left + ((right - left) >> 1);
            if (arr[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return right - 1;
    }

    /**
     * 返回第一个大于5的元素
     *
     * @param arr    数组
     * @param target 目标
     * @return 元素下标
     */
    public static int c(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int middle = left + ((right - left) >> 1);
            if (arr[middle] <= target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return right;
    }

    public static int c2(int[] arr, int target) {
        int left = -1;
        int right = arr.length;
        while (left + 1 != right) {
            int middle = left + ((right - left) >> 1);
            if (arr[middle] <= target) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return right;
    }
}
