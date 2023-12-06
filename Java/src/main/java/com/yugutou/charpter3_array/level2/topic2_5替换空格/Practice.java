package com.yugutou.charpter3_array.level2.topic2_5替换空格;

/**
 * @author goatli
 */
public class Practice {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("We are happy.");
        System.out.println(replaceSpace(sb));
    }

    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }

        //空格数量
        int numOfblank = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                numOfblank++;
            }
        }
        //设置长度
        str.setLength(len + 2 * numOfblank);
        //两个指针
        int fast = len - 1;
        int slow = (len + 2 * numOfblank) - 1;

        while (fast >= 0 && slow > fast) {
            char c = str.charAt(fast);
            if (c == ' ') {
                fast--;
                str.setCharAt(slow--, '0');
                str.setCharAt(slow--, '2');
                str.setCharAt(slow--, '%');
            } else {
                str.setCharAt(slow, c);
                fast--;
                slow--;
            }
        }
        return str.toString();
    }
}
