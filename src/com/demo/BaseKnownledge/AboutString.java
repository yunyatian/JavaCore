package com.demo.BaseKnownledge;

import java.util.Date;

public class AboutString {
    public static void main(String[] args) {
        String greeting = "Hello";
        // substring(x, y)表示截取下标位置为[x,y)的子串
        String s = greeting.substring(0,3);
        System.out.println("字符串子串：" + s);

        String expletive = "Expletive";
        String PG13 = "deleted";
        String message = expletive + PG13;
        System.out.println("字符串拼接：" + message);

        String all = String.join("/", "S", "M", "L", "XL");
        System.out.println("静态方法join的使用：" + all);

        /**
         * String类没有提供改变字符串某个字符的方法。由于不能修改单个字符串，所以java中的String对象是不可变的。
         * 千万不要使用==对两个字符串进行比较
         */
        greeting = greeting.substring(0, 3) + "p!";
        System.out.println(greeting);

        System.out.println("字符串比较结果：");
        System.out.println("equals比较：" + "Help!".equals(greeting));
        System.out.println("equals忽略大小写进行比较：" + "HELP!".equalsIgnoreCase(greeting));
        System.out.println("==比较结果：" + (greeting == "Help!"));
        System.out.println("substring后==结果：" + (greeting.substring(0, 3) == "Hel"));

        /**
         * 空串“”是长度为0的字符串。空串是一个java对象，有自己的串长度（0）和内容（空）
         * String变量还可以存放一个一个特殊值，名为null，表示没有任何对象与该变量关联。
         */
        String str = "";
        System.out.println("判定字符串是否为空（方法1，判定字符创长度是否为0）：" + (str.length() == 0));
        System.out.println("判定字符串是否为空（方法2，使用equals与”“进行比较）：" + str.equals(""));
        String nullStr = null;
        System.out.println("判定字符串是否为null(使用==进行比较)：" + (nullStr == null));

        /**
         * 有些时候，需要由较短的字符串构建字符串，如果采用字符串拼接的方式来达到目的，效率会比较低。每次拼接字符串时，
         * 都会构建一个新的String对象，既耗时，又浪费空间。可以使用StringBuilder来避免这个问题的发生。
         */
        StringBuilder stringBuilder = new StringBuilder();
        String str1 = "Hello ";
        stringBuilder.append(str1);
        String str2 = "World!";
        stringBuilder.append(str2);
        System.out.println(stringBuilder.toString());
        System.out.println("StringBuilder.append()后的长度：" + stringBuilder.length());

    }

}
