package com.yugutou.charpter11_bit;

public class Practice {
    public static void main(String[] args) {
        int n = 100;
//        System.out.println(hammingWeight(n));
//        System.out.println(hammingWeight1(n));
//        System.out.println(hammingWeight2(n));
//        int[] ints = countBits(4);
//        for (int i = 0; i < ints.length; i++) {
//            System.out.print(ints[i] + ",");
//        }

        System.out.println(~2 + 1);

    }

    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (n >> i) & 1;
        }
        return count;
    }

    public static int hammingWeight1(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
//            System.out.println("123：" + ((n & (1 << i)) >> i));
            count += ((n & (1 << i)) >> i);
        }
        return count;
    }

    public static int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n-1);
            count ++;
        }
        return count;
    }

    public static int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            bits[i] = hammingWeight2(i);
        }
        return bits;
    }

}
