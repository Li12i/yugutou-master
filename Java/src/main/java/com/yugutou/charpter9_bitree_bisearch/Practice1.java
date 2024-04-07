package com.yugutou.charpter9_bitree_bisearch;

public class Practice1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 5, 5, 8, 9};
        int[] arr1 = {1,2,2,2,2,2,2,2,2,6};
        System.out.println(findFirstTarget(arr1, 2));
        System.out.println(findFirstTarget(arr1, 5));
    }

    /**
     * 返回第一个元素下标
     * @param arr 数组
     * @param target 目标值
     * @return 下标
     */
    public static int findFirstTarget(int[] arr, int target) {
        int length = arr.length;

        // 如果第一个元素比目标值大 或者 最后一个元素比目标值小，则直接返回错误
        if (length == 0 || arr[0] > target || arr[length - 1] < target) {
            return -1;
        }

        // 开区间
        int left = -1;
        int right = length;

        while (left +1 != right) {
            int mid = left + ((right - left) >> 1);
            // 此时左区间一定严格小于目标值，右区间一定严格大于等于目标值
            if (arr[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (arr[right] != target) {
            return -1;
        }
        return right;
    }
}
