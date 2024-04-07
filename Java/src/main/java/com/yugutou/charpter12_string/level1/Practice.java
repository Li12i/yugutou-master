package com.yugutou.charpter12_string.level1;

public class Practice {
    public static void main(String[] args) {
        System.out.println(stingToInt("    -42"));

    }

    /**
     * 将字符串里的字符 转换成数字
     *
     * @param str 字符串
     * @return 转换后的数字
     */
    public static int stingToInt(String str) {
        int len = str.length();
        char[] charArray = str.toCharArray();
        int index = 0;

        // 1.将前面的空格全部去除
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        if (index == len) {
            return 0;
        }

        // 2.判断正负符号
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            sign = -1;
            index++;
        }

        // 3.将后续出现的数字进行转换，如果过程中出现不合法的字符，则直接返回
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 如果出现发飞字符
            if (currChar >= '9' || currChar <= '0') {
                break;
            }

            // 判断每次的结果是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 对结果进行相加
            res = res * 10 + sign * (currChar - '0');

            index++;
        }

        return res;
    }
}
