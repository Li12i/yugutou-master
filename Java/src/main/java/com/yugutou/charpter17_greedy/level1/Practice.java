package com.yugutou.charpter17_greedy.level1;

import java.util.Arrays;

public class Practice {

    /**
     * 寻找最多的饼干满足
     *
     * @param g 胃口
     * @param s 饼干
     * @return 数
     */
    public static int findContentChildren(int[] g, int[] s) {
        int res = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        // 大饼干满足大胃口 防止浪费
        int index = s.length - 1;
        // 遍历胃口
        for (int i = g.length - 1; i >= 0; i--) {
            if (index >= 0 && s[index] >= g[i]) {
                res++;
                index--;
            }
        }
        return res;
    }

    /**
     * 分发饼干
     *
     * @param ratings 评分
     * @return 最少糖果数
     */
    public static int candy(int[] ratings) {
        int ans = 0;
        int[] nums = new int[ratings.length];

        nums[0] = 1;
        // 第一次从左边遍历
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                nums[i] = nums[i - 1] + 1;
            } else {
                nums[i] = 1;
            }
        }

        // 第二次从右边遍历
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                nums[i] = Math.max(nums[i], nums[i + 1] + 1);
            }
        }

        for (int i : nums) {
            ans += i;
        }

        return ans;
    }
}
