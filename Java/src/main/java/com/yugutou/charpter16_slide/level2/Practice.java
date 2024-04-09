package com.yugutou.charpter16_slide.level2;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Practice {

    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "bbbbb";
//        String s = "pwwkew";
//        System.out.println(lengthOfLongestSubstring(s));

        String s = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    /**
     * 寻找最长子串
     *
     * @param s 字符串
     * @return 长度
     */
    public static int lengthOfLongestSubstring(String s) {

        if (s.length() < 1) return 0;

        // 左指针
        int left = 0;
        int max = 0;
        // 用于存放其位置
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // 如果出现了重复的数据，则将左指针移到重复字符的下标+1的位置
            if (hashMap.containsKey(c)) {
                left = hashMap.get(c) + 1;
            }
            hashMap.put(c, right);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    /**
     * 寻找包含两个元素的最长子串
     *
     * @param s 字符串
     * @return 长度
     */
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() < 1) return 0;

        int left = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // map中存的是相同字符最右侧的下标
            if (map.size() < 3) {
                map.put(c, right);
            }

            if (map.size() == 3) {
                Integer min = Collections.min(map.values());
                map.remove(s.charAt(min));
                left = min + 1;
            }
            max = Math.max(right - left + 1, max);

        }
        return max;
    }
}
