package com.yugutou.charpter15;

/**
 * 用4kb内存寻找重复元素
 */
public class FindDuplicatesIn32000 {


}

class BitSet {
    int[] bitSet;

    public BitSet(int size) {
        this.bitSet = new int[size >> 5];
    }

    boolean get(int pos) {
        int wordNumber = (pos >> 5);
        int bitNumber = (pos & 0X1F);
        return (bitSet[wordNumber] & (1 << bitNumber)) != 0;
    }

    void set(int pos) {
        int wordNumber = (pos >> 5);
        int bitNumber = (pos & 0X1F);
        bitSet[wordNumber] |= 1 << bitNumber;
    }
}
