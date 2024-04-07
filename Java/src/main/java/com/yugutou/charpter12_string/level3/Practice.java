package com.yugutou.charpter12_string.level3;

public class Practice {
    public static void main(String[] args) {
        int num = 93;
        char[] chars = new char[5];
        int left = 0;
        while (num > 0) {
            chars[left++] = (char) (num % 10 + '0');
            num /= 10;
        }
        reverse(chars, 0, left - 1);

        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }

    public static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char aChar = chars[left];
            chars[left] = chars[right];
            chars[right] = aChar;
            left++;
            right--;
        }
    }
}
