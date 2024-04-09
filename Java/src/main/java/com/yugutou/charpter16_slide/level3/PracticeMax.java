package com.yugutou.charpter16_slide.level3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PracticeMax {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        for (int i : maxSlidingWindow(nums, k)) {
            System.out.println(i);
        }
    }

    /**
     * 活动窗口最大值
     *
     * @param nums 数组
     * @param k    滑动窗口大小
     * @return 最大值数组
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k) return new int[]{0, 0};

        int length = nums.length;
        int[] ans = new int[length - k + 1];
        // 用于存放滑动时的最大值
        PriorityQueue<int[]> qp = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
            }
        });

        // 存放前K位
        for (int i = 0; i < k; i++) {
            qp.offer(new int[]{nums[i], i});
        }
        // 第一位最大值
        ans[0] = qp.peek()[0];

        for (int i = k; i < length; i++) {
            // 将值存放进
            qp.offer(new int[]{nums[i], i});

            // 判断最大值的小标是不是在滑动窗口内
            while (qp.peek()[1] < (i - k + 1)) {
                qp.poll();
            }

            ans[i - k + 1] = qp.peek()[0];
        }

        return ans;
    }
}
