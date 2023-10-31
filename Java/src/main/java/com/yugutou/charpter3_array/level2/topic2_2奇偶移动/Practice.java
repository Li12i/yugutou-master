package com.yugutou.charpter3_array.level2.topic2_2奇偶移动;

import java.util.Arrays;

/**
 * @author goatli
 */
public class Practice {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int[] ints = sortArrayByParity(arr);
        System.out.println(Arrays.toString(sortArrayByParity(ints)));
    }
    public static int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 左奇 右偶
            if (nums[left] % 2 > nums[right] % 2) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

            }

            if (nums[left] % 2 == 0) {
                left ++;
            }

            if (nums[right] % 2 == 1) {
                right --;
            }
        }
        return nums;
    }
}
