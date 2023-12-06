package com.yugutou.charpter9_bitree_bisearch.level2;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 9};
//        System.out.println(solve(nums));
//        System.out.println(solve2(nums));
        System.out.println(solve3(nums));
    }


    public static int solve(int[] a) {
        // write code here
        int left = 0;
        int right = a.length - 1;
        int i = 0;
        while (left < right) {
            i++;
//            int mid = (left + right) / 2;
            int mid = left + ((right - left) >> 2);
            if (a[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(i);
        return left;
    }

    // 寻找第一个不等于i的元素
    public static int solve2(int[] a) {
        int left = -1;
        int right = a.length;
        int i = 0;
        while (left + 1 != right) {
            i++;
            int middle = left + ((right - left) >> 1);
            if (a[middle] == middle) {
                left = middle;
            } else {
                right = middle;
            }
        }
        System.out.println(i);
        return right;
    }

    public static int solve3(int[] a) {
        int left = 0;
        int right = a.length - 1;
        int i = 0;
        while (left <= right) {
            i++;
            int middle = left + ((right - left) >> 1);
            if (a[middle] == middle) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        System.out.println(i);
        return left;
    }
}
