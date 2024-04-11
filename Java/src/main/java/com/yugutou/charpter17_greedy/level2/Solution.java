package com.yugutou.charpter17_greedy.level2;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{6, -2, -5, 1};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 最大子串
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            sum = Math.max(sum, count); // 取区间累计的最大值（相当于不断确定最大子序终止位置）
            if (count <= 0) {
                count = 0; // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
            }
        }
        return sum;
    }
}
