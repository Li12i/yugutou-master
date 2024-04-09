package com.yugutou.charpter16_slide.level2;

import java.util.Arrays;

public class PracticeMIn {

    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
//        System.out.println(minSubArrayLen(target, nums));

        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
//        System.out.println(maxArea(height));

        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    /**
     * 寻找最小长度
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        if (nums.length < 1) return 0;

        int sum = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            // 寻找最小的长度
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    /**
     * 寻找最大水池深度
     *
     * @param height 高
     * @return 最大深度
     */
    public static int maxArea(int[] height) {
        if (height.length < 1) return 0;

        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (right > left) {
            // 记录当前面积。 并去比较左右两边谁的边小，小的进行收缩。
            int hei = Math.min(height[right], height[left]);
            res = Math.max(res, (right - left) * (hei));

            if (hei == height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return res;
    }

    public static int maxArea1(int[] height) {
        if (height.length < 1) return 0;

        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (right > left) {
            // 记录当前面积。 并去比较左右两边谁的边小，小的进行收缩。
            res = height[right] > height[left] ?
                    Math.max(res, (right - left) * (height[left++])) :
                    Math.max(res, (right - left) * (height[right--]));
        }

        return res;
    }

    /**
     * 寻找是否存在排列
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @return 是 否
     */
    public static boolean checkInclusion(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];


        // 先走s1的长度
        for (int i = 0; i < len1; i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(arr1, arr2)) return true;

        // 走s2的长度
        for (int right = len1; right < len2; right++) {
            arr2[s2.charAt(right) - 'a']++;
            int left = right - len1;
            arr2[s2.charAt(left) - 'a']--;
            if (Arrays.equals(arr1, arr2)) return true;
        }
        return false;
    }
}
