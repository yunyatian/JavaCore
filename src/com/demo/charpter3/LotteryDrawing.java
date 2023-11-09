package com.demo.charpter3;

import java.util.Arrays;
import java.util.Scanner;

public class LotteryDrawing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("您可抽取几位数字？");
        int k = in.nextInt();

        System.out.print("奖池数字共有多少位？");
        int n = in.nextInt();

        // 为奖池数组添加数字
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i+1;
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            // 设置随机值得到下表位置
            int r = (int) (Math.random() * n);

            // 取出下标位置值作为本次抽取数字
            result[i] = numbers[r];

            // 使用数组最后一个元素来替换被取出数字
            numbers[r] = numbers[n - 1];
            n--;
        }

        Arrays.sort(result);
        System.out.println("您抽出的数字按顺序依次为："+Arrays.toString(result));
    }
}
