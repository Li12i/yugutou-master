package com.yugutou.charpter11_bit;

public class PracticeBit {
    public static void main(String[] args) {
        int i = 0x5f3759df - (2 >> 1);
        System.out.println(i);
        System.out.println(3200 >> 5);
    }
    public void check(int[] array) {
        BitSet bs = new BitSet(3200);
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int num0 = num - 1;
            if (bs.get(num0)) {
                System.out.println(num);
            } else {
                bs.set(num0);
            }
        }
    }
}

class BitSet {
    int[] bitSet;

    public BitSet(int size) {
        this.bitSet = new int[size >> 5];
    }

    boolean get(int pos) {
        int wordNumber = (pos >> 5);
        int bitNumber = (pos & 0x1F);
        return (bitSet[wordNumber] & (1 << bitNumber)) != 0;
    }

    void set(int pos) {
        int wordNumber = (pos >> 5);
        int bitNumber = (pos & 0x1F);
        bitSet[wordNumber] |= 1 << bitNumber;
    }
}
