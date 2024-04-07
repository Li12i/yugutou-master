package com.yugutou.charpter11_bit;

public class PracticeAdd {
    public static void main(String[] args) {
        System.out.println(finalDivide(-2147483648, -2147483648));
        System.out.println(finalMultiple(3, -1));

        System.out.println(~2);
    }


    public static int finalAdd(int a, int b) {
        return add(a, b);
    }

    public static int finalMinus(int a, int b) {
        return minus(a, b);
    }

    public static int finalMultiple(int a, int b) {
        return multiple(a, b);
    }

    public static int finalDivide(int a, int b) {
        return divide(a, b);
    }

    /**
     * 加
     */
    public static int add(int a, int b) {
        while (b != 0) {
            int size = (a & b) << 1;
            a = a ^ b;
            b = size;
        }
        return a;
    }

    /**
     * 减
     * a + b
     * = a + (-b)
     * = a + (~b + 1 )
     */
    public static int minus(int a, int b) {
        return add(a, neg(b));
    }

    public static int neg(int n) {
        return add(~n, 1);
    }

    /**
     * 乘
     * 通过b的每一位和a进行相乘，如果b为1则相加，否则不变
     */
    public static int multiple(int a, int b) {
        int ans = 0;
        while (b != 0) {
            // 只有b的最右不是0
            if ((b & 1) != 0) {
                ans = add(ans, a);
            }
            a <<= 1;
            // 这里记住是算数右移保留符号位
            b >>>= 1;
        }
        return ans;
    }

    /**
     * 除的最小值
     */
    public static int MIN = Integer.MIN_VALUE;

    public static int divide(int a, int b) {
        // 如果ab都是最小值
        if (a == MIN && b == MIN) {
            return 1;
        }
        // 都不是则调用正常除法
        if (a != MIN && b != MIN) {
            return div(a, b);
        }
        // 如果b是最小值
        if (b == MIN) {
            return 0;
        }
        // 如果b是-1
        if (b == neg(1)) {
            return Integer.MAX_VALUE;
        }
        // a是整数最小，b不是整数最小，b不是-1
        // ：此时需要将最小的数加上b使得最小的数变大一点，最后结果再减1（相对逻辑，如果b为负数则取负的负数）
        a = add(a, b > 0 ? b : neg(b));
        int ans = div(a, b);
        int offSet = b > 0 ? neg(1) : 1;
        return add(ans, offSet);
    }

    /**
     * 基本除
     */
    public static int div(int a, int b) {
        // 将两数转换成正数
        int x = a < 0 ? neg(a) : a;
        int y = b < 0 ? neg(b) : b;
        int ans = 0;
        // 从30位开始计算
        for (int i = 30; i >= 0;  i = minus(i, 1)) {
            // 判断 y * 2 ^ i次方是否小于等于x
            // 等价于：也就是 x / 2 ^ i 是否大于等于y
            if ((x >> i) >= y) {
                // 记录这一位
                ans |= (1 << i);
                // 此时我们需要将x减去算过的部分
                x = minus(x, (y << i));
            }
        }

        return a < 0 ^ b < 0 ? neg(ans) : ans;
    }
}
