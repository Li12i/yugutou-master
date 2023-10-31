package com.yugutou.charpter3_array.level2.topic2_4区间合并;

import java.util.ArrayList;
import java.util.List;

/**
 * @author goatli
 */
public class Practice {
    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(summaryRanges(arr));

        int[] nums = {0, 1, 3, 50, 75};
        System.out.println(ranges(nums, 99));
    }

    public static List<String> summaryRanges(int[] nums) {

        List<String> res = new ArrayList<>();
        // 起始位置
        int slow = 0;

        //
        for (int fast = 0; fast < nums.length; fast++) {
            if (fast + 1 == nums.length || nums[fast] + 1 != nums[fast + 1]) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[slow]);

                // 如果只有一个值的话 那么不需要进行拼接
                if (slow != fast) {
                    sb.append("->").append(nums[fast]);
                }

                // 刷新slow为fast的下一个
                slow = fast + 1;

                res.add(sb.toString());
            }
        }

        return res;
    }

    public static List<String> ranges(int[] nums, int big) {

        List<String> res = new ArrayList<>();

        for (int index = 0; index < nums.length; index++) {

            if (index + 1 == nums.length || nums[index] + 1 != nums[index + 1]) {
                int min = nums[index] + 1;
                int max = 0;
                if (index + 1 == nums.length) {
                    max = big;
                } else {
                    max = nums[index + 1] - 1;
                }

                StringBuilder sb = new StringBuilder();
                sb.append(min);

                // 如果出现 中间只差一个值，就不用管了
                if (min != max) {
                    sb.append("->").append(max);
                }

                res.add(sb.toString());
            }
        }

        return res;
    }
}
