package com.yugutou.charpter3_array;

import static com.yugutou.tools.ArrayTool.printList;

/**
 * @author by GOATLi
 * date: 2023-10-30.
 */
public class Change {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 5};
        int[] arr2 = {0, 2, 2, 2, 2, 2, 5};

        printList("asda", arr, delRepeat(arr));

        printList("asd", arr2, delRepeat(arr2));

        
    }

    /**
     * 删除所有重复出现的数据，不用考虑数组中的数据重复出现
     *
     * @param arr 数组
     * @return 数组
     */
    public static int delRepeat(int[] arr) {

        if (arr == null) {
            return 0;
        }

        int slow = 0;
        for (int fast = 1; fast < arr.length; fast++) {

            // 第一个元素比较
            if ((fast == 1) && arr[fast] != arr[fast - 1]) {
                arr[slow++] = arr[fast - 1];
            }

            // 最后一个元素比较
            if (fast + 1 == arr.length) {
                if (arr[fast] != arr[fast - 1]) {
                    arr[slow++] = arr[fast];
                }
                continue;
            }

            // 中间元素比较
            if ((arr[fast] != arr[fast - 1] && arr[fast] != arr[fast + 1])) {
                arr[slow++] = arr[fast];
            }
        }

        return slow;
    }
}
