package com.yugutou.charpter12_string.level2;

public class Practice {

    public static void main(String[] args) {
        String s= "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        // 遍历将其反转
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }

        // 判断是否是回文子串
        int n = sb.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
