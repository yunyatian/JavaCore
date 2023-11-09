package com.demo.charpter3;

import java.util.Arrays;

public class ArrayCopyTest {
    public static void main(String[] args) {

        /**
         * test和array共享一份内存，所以当修改test时，array随之也进行修改。
         * 当使用copyof时并不是使用同一份内存，会新建一份新的内存进行存储，所以改变copy的值时，array的值并不会改变。
         */
        int[] array = new int[]{2, 3, 5, 7, 11, 13};
        int[] test = array;
        System.out.println(Arrays.toString(array));
        test[5] = 14;
        System.out.println(Arrays.toString(array));
        int[] copy = Arrays.copyOf(array, array.length);
        copy[5] = 15;
        System.out.println(Arrays.toString(array));
    }
}
