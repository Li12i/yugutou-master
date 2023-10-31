package com.yugutou.charpter3_array.level2.topic2_1删除元素;

/**
 * @author goatli
 */
public class Practice {
    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3, 3};
        int val = 3;

//        System.out.println("快慢指针的结果为：" +delVal(arr, val));

        System.out.println("对撞双指针的结果为：" +delValWithCollision(arr, val));

//        System.out.println(delValWithCollision2(arr,val));
    }

    /**
     * 通过快慢指针进行删除元素
     *
     * @param nums 数组
     * @param val  要删除的值
     * @return
     */
    public static int delVal(int[] nums, int val) {

        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }

        return slow;
    }

    /**
     * 对撞双指针
     *
     * @param nums 数组
     * @param val  要删除的值
     * @return 大小
     */
    public static int delValWithCollision(int[] nums, int val) {
        int slow = 0;
        int fast = nums.length - 1;

        for (slow = 0; slow <= fast;) {
            if (nums[slow] == val && nums[fast] != val) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
            }

            if (nums[slow] != val) {
                slow++;
            }
            if (nums[fast] == val) {
                fast--;
            }

        }

        return slow;
    }

    public static int delValWithCollision2(int[] nums, int val) {
        int slow = 0;
        int fast = nums.length - 1;

        for (slow = 0; slow <= fast;) {
            if (nums[slow] == val) {
                nums[slow] = nums[fast--];
            } else {
                slow ++;
            }
        }

        return slow;
    }

    public static int removeDuplicates(int[] arr) {
        // 这里第一个位置不用考虑，相当于一定相等
        int slow = 1;

        for (int fast = 0; fast < arr.length; fast++) {
            if (arr[fast] != arr[slow - 1]) {
                arr[slow] = arr[fast];
                slow ++;
            }
        }
        return slow;
    }
}