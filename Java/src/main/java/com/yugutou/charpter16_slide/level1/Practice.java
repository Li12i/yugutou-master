package com.yugutou.charpter16_slide.level1;

import com.yugutou.charpter16_slide.level2.MaxArea;

public class Practice {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));

        int[] nums1 = new int[]{2,2,2,2,2};
        System.out.println(findLengthOfLCIS(nums1));
    }

    /**
     * 寻找一个数组里 k 个和的最大平均数
     *
     * @param nums 数组
     * @param k    k个数的和
     * @return 平均数
     */
    public static double findMaxAverage(int[] nums, int k) {

        if (nums == null || k > nums.length || k < 1) return 0;

        int windowSum = 0;

        // 先走k步
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        // 比较接下来每一步的大小
        int res = windowSum;
        for (int left = k; left < nums.length; left++) {
            windowSum += nums[left] - nums[left - k];
            res = Math.max(res, windowSum);
        }

        return (double) res / k;
    }

    /**
     * 寻找最长的递增数列
     *
     * @param nums 数组
     * @return 长度
     */
    public static int findLengthOfLCIS(int[] nums) {

        int left = 0;
        int right = 0;
        int res = 0;

        while (right < nums.length) {
            // 只有前一个值大于右值的时候才需要变化
            if (right > 0 && nums[right - 1] >= nums[right]) {
                left = right;
            }
            right++;
            res  = Math.max(res, right - left);
        }

        return res;
    }
}
