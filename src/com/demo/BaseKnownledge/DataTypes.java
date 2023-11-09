package com.demo.BaseKnownledge;

public class DataTypes {
    public static void main(String[] args) {
        byte b = -126;
        int i = Byte.toUnsignedInt(b);
        System.out.println(i);
        System.out.println(b & 0xFF);
        System.out.println(0x1.0p-3);

        // 没有x == NaN这种写法，只有Double.isNaN(x)来进行判断。
        System.out.println(Double.isNaN(b));

        System.out.println("2.0 - 1.0结果为：" +(2.0 - 1.1));

        double x = 1.0;
        // 整数被0除将会产生一个异常，浮点数被0除将会得到无穷大或者NaN结果。
        System.out.println("浮点数除以0结果：" + 1.0 / 0);

        int m = 7;
        int n = 7;
        // ++m是先加再赋值
        System.out.println("2 * ++m = " + 2 * ++m);
        // n++是先赋值再加
        System.out.println("2 * n++ = " + 2 * n++);

        String str = "a";
        System.out.println("字符串加法：" + str + 2);

        char ch = 'a';
        System.out.print("字符加法：");
        System.out.println(ch + 2);

//        System.out.println(b);
    }
}
