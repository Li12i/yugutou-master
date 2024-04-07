package com.yugutou.charpter12_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        List<String> arg = new ArrayList<>();
        arg.add("tiantian");
        arg.add("yuanyuan");
        arg.add("tingting");
        arg.add("yingzi");
        arg.add("qiyue");

        zipName(arg);

        System.out.println(arg);
    }

    /**
     * 压缩名称：
     * 如果出现重复名称，则压缩第二个名字为~
     *
     * @param
     * @return 返回后的值
     */
    public static void zipName(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String ele = list.get(i);
            String newString = zip(ele);
            list.set(i, newString);
        }
    }


    public static String zip(String str) {
        int length = str.length();
        // 判断是否需要被压缩
        if (length == 0 || length % 2 != 0) {
            return str;
        }
        // 左右开始节点
        char[] chars = str.toCharArray();
        int leftStart = 0;
        int rightStart = length / 2;
        StringBuilder res = new StringBuilder();
        // 比较如果出现不同，则返回原值
        while (rightStart < length) {
            res.append(chars[leftStart]);
            if (chars[rightStart] != chars[leftStart]) {
                return str;
            } else {
                leftStart++;
                rightStart++;
            }
        }
        res.append('~');
        return res.toString();
    }
}
