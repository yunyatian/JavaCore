package com.demo.stackTrace;

import java.util.Scanner;

public class StackTraceTest {
    public static int factorial(int n){
        System.out.println("factorial("+n+")");
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();//提取堆栈跟踪信息
        for (StackTraceElement stackTraceElement:
             stackTraceElements) {
            System.out.println(stackTraceElement);
        }
        int r;
        if(n<=1){
            r=1;
        }else{
            r=n*factorial(n-1);
        }
        System.out.println("return "+r);
        return r;
    }

    public static void main(String[] args) {
        //使用try-with-resource格式，不管try块的内容是否正常退出，还是说捕获异常，都会自动关闭括号中所写的资源，且括号中的资源可以不止一个
        try(Scanner in = new Scanner(System.in)){//try-with-resource格式，当try块结束的时候，会自动关闭资源。
            System.out.println("Enter n:");
            int n = in.nextInt();
            factorial(n);
        }
    }
}
