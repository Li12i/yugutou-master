package com.yugutou.charpter3_array.level1;

/**
 * @author goatli
 */
public class Practice {
    public static void main(String[] args) {
        int[] a = new int[10];
        a[0] = 3;
        a[1] = 4;
        a[2] = 7;
        a[3] = 8;
//        for (int i = 0; i < 8; i++) {
//            a[i] = i;
//        }
        int[] b = new int[]{1, 2, 3, 4, 5, 6};

        int i = find(b, 6, 4);

        int insert = insert(a, 4, 9);
        System.out.println(insert);
    }

    private static int find(int[] arr, int size, int k) {
        if (arr.length < 1) {
            return -1;
        }

        for (int i = 0; i < size; i++) {
            if (arr[i] >= k) {
                return i;
            }
        }
        return -1;

    }

    /**
     * 新增
     *
     * @param arr  数组
     * @param size 数组大小
     * @param ele  插入的元素
     * @return 新增位置
     */
    private static int insert(int[] arr, int size, int ele) {
        // 1.判断元素的大小和已有元素的情况
        if (size >= arr.length) {
            return -1;
        }

        // 2.找到需要插入肚饿数组下标位置
        int index = size;
        for (int i = 0; i < size; i++) {
            if (ele <= arr[i]) {
                index = i;
                break;
            }
        }

        // 3.将大的元素全部后移一位
        for (int j = size; j > index; j--) {
            arr[j] = arr[j - 1];
        }
        arr[index] = ele;
        return index;
    }

    /**
     * 减
     *
     * @param arr  数组
     * @param size 大小
     * @param key  需要删除的值
     * @return 大小
     */
    private static int delete(int[] arr, int size, int key) {
        int index = -1;

        // 1.找到下标位置
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                index = key;
                break;
            }
        }

        // 2.删除前移
        if (index != -1) {
            for (int i = index + 1; i < size; i++) {
                arr[i - 1] = arr[i];
                size--;
            }
        }


        return size;
    }

    /**
     * 合并数组
     *
     * @param nums1     数组1
     * @param nums1_len 数组1长度
     * @param nums2     数组2
     * @param nums2_len 数组2长度
     */
    private void merge(int[] nums1, int nums1_len, int[] nums2, int nums2_len) {
        int index = nums1_len + nums2_len - 1;

        int len1 = nums1_len - 1;
        int len2 = nums2_len - 1;

        while (len1 >= 0 && len2 >= 0) {
            if (nums1[len1] <= nums2[len2]) {
                nums1[index--] = nums1[len1--];
            } else if (nums1[len1] > nums2[len2]) {
                nums1[index--] = nums2[len2--];
            }
        }

        // 如果出现有的走完了有的还没走完的情况下
        while (len2 != -1) {
            nums1[index - 1] = nums2[len2--];
        }
        while (len1 != -1) {
            nums1[index - 1] = nums1[len1--];
        }
    }

    /**
     * 判断是否单调
     * @param nums 数组
     * @return 是否
     */
    public boolean isMonotonic(int[] nums) {
        boolean inc = true;
        boolean dec = true;

        for (int i = 0; i < nums.length - 1; i++) {
            // 如果出现不是单调递增 或者 单调递减的情况
            if (nums[i] > nums[i + 1]) {
                inc = false;
            }

            if (nums[i] < nums[i + 1]) {
                dec = false;
            }
        }

        return inc || dec;
    }
}
