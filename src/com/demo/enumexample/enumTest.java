package com.demo.enumexample;

public class enumTest {
    public static void main(String args[]){
        String str1 = Size.valueOf("LONG").name();
        System.out.println(str1);

        str1 = Size.valueOf("LONG").toString();
        System.out.println(str1);

        Size size = Size.valueOf("LONG");
        System.out.println(size);

    }
}
