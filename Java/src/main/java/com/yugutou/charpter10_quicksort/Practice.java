package com.yugutou.charpter10_quicksort;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        int[] array = {6, 3, 2, 4, 5, 8, 7};
//        int[] array = {3, 2, 1, 5, 6, 4};
        int k = 2;//找第二大元素
        System.out.println(findKthLargest1(array, k));
//        System.out.println(array[k - 1]);  //因为是从零开始所以k-1;

    }

    /**
     * 找到第k大的元素
     *
     * @param _nums 数组
     * @param k     第K大
     * @return 第K大的数
     */
    public static int findKthLargest(int[] _nums, int k) {
        int n = _nums.length;
        return quickSelect(_nums, 0, n - 1, k);
    }

    private static int quickSelect(int[] nums, int left, int right, int k) {
        // 正数第k个元素
        int indexK = nums.length - k;
        int indexRight = right;

        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;

        // 找第K大就是找正数length - k
        if (right == indexK) return nums[indexK];

        if (indexK <= left) {
            return quickSelect(nums, 0, left - 1, k);
        } else {
            return quickSelect(nums, left + 1, indexRight, k);
        }
    }


    public static int findKthLargest1(int[] _nums, int k) {
        int n = _nums.length;
        return quickSelect1(_nums, 0, n - 1, n - k);
    }

    private static int quickSelect1(int[] nums, int left, int right, int k) {
        if (left == right) return nums[k];
        // 不对原参数进行修改
        int l = left;
        int r = right;
        // 每次返回的是轴值下标，通过轴值下标和K进行比较，我们这里轴值选择就选择left
        int pivot = nums[left];
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[r] = pivot;
        if (k <= r) return quickSelect1(nums, left, r, k);
        else return quickSelect1(nums, r + 1, right, k);
    }
}
