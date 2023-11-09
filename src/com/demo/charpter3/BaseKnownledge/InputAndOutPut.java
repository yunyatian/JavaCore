package com.demo.charpter3.BaseKnownledge;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;

public class InputAndOutPut {
    public static void main(String[] args) throws IOException {
        double x = 10000 / 3.0 ;
        System.out.println("========格式化输出内容=========");
        System.out.println("未格式化的输出：" + x);
        System.out.printf("格式化后的输出(使用printf打印输出,println没有该功能)：%8.2f\n", x);
        System.out.printf("打印正负号输出（使用+）:%+.2f\n", x);
        System.out.printf("添加分组符（使用，）:%,.2f\n", x);
        System.out.println("使用静态方法format进行格式化输出：" + String.format("%8.2f", x));

        System.out.printf("%1$s %2$tB %2$te, %2$tY\n", "Due date:", new Date());
        System.out.printf("%s %tB %<te, %<tY\n", "Due date:", new Date());

        System.out.println("============文件输入与输出============");
        Scanner in = new Scanner(Paths.get("MyFile.txt"), String.valueOf(StandardCharsets.UTF_8));
        while (in.hasNext()){
            System.out.println(in.next());
        }
        in.close();

        FileWriter fileWriter = new FileWriter("MyFile.txt",true);
        PrintWriter out = new PrintWriter(fileWriter);

//        PrintWriter out = new PrintWriter("MyFile.txt", String.valueOf(StandardCharsets.UTF_8));
        out.append("\n你好！");
        out.close();
    }

}
