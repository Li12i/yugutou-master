package com.yugutou.charpter17_greedy.level2;


import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 4}, {0, 0}};
//        System.out.println(Arrays.deepToString(merge(intervals)));

//        int[][] intervals1 = {{1, 5}};
//        int[] newInterval = new int[]{6, 8};
//        System.out.println(Arrays.deepToString(insert(intervals1, newInterval)));

        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    /**
     * 合并区间
     *
     * @param intervals 数组
     * @return 数组
     */
    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (v1, v2) -> (v1[0] - v2[0]));
        // [[], [], []]
        int[][] res = new int[intervals.length][2];

        int index = -1;
        for (int[] interval : intervals) {
            // 比较前一个的右边界 和 当前数组的左边界，比较谁大
            if (index == -1 || res[index][1] < interval[0]) {
                res[++index] = interval;
            } else {
                res[index][0] = Math.min(res[index][0], interval[0]);
                res[index][1] = Math.max(res[index][1], interval[1]);
            }
        }

        return Arrays.copyOf(res, index + 1);
    }

    /**
     * 插入区间
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0 && newInterval.length != 0) return new int[][]{newInterval};

        int[][] res = new int[intervals.length + 1][2];

        int left = newInterval[0];
        int right = newInterval[1];
        int index = 0;
        int i = 0;
        int length = intervals.length;
        // 右侧比左边小的，直接插入
        while (i < length && intervals[i][1] < left) {
            res[index++] = intervals[i];
            i++;
        }

        // 在中间的 取较小较大值
        while (i < length && intervals[i][0] <= right) {
            left = Math.min(intervals[i][0], left);
            right = Math.max(intervals[i][1], right);
            i++;
        }
        res[index] = new int[]{left, right};

        // 左侧比右侧大的 直接插入
        while (i < length && intervals[i][0] > right) {
            res[++index] = intervals[i];
            i++;
        }

        return Arrays.copyOf(res, index + 1);
    }

    /**
     * 加油站问题
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int start = 0;
        int costs = 0;
        int totalCost = 0;

        // 遍历的时候判断消耗是否大于油罐值
        for (int i = 0; i < gas.length; i++) {
            totalCost += gas[i] - cost[i];
            costs += gas[i] - cost[i];
            if (costs < 0) {
                // 这段不行 从下一段开始
                start = i + 1;
                costs = 0; // 分段重新开始计算
            }
        }

        if (totalCost < 0) return -1;

        return start;
    }

    /**
     * 跳跃游戏
     */
    public static boolean canJump(int[] nums) {

        if (nums.length == 1) return true;

        // 记录覆盖的最远范围
        int cover = 0;

        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, nums[i] + i);
            if (cover >= nums.length - 1) return true;
        }

        return false;
    }

}
