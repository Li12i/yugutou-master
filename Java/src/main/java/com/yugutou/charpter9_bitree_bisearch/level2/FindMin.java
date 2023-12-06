package com.yugutou.charpter9_bitree_bisearch.level2;

/**
 * LeetCode153 旋转数字的最小数字
 */
public class FindMin {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        int[] nums2 = {3, 4, 5, 6, 7, 8, 1, 2};
        int[] nums3 = {3, 4, 1, 2, 5, 6, 7, 8};
//        System.out.println(findMin(nums));
        System.out.println(findMin2(nums));
        System.out.println(findMin2(nums2));
        System.out.println(findMin2(nums3));
    }

    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + ((high - low) >> 1);
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }

    public static int findMin2(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int pivot = low + ((high - low) >> 1);
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[high];
    }
}
