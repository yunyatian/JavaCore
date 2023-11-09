package com.demo.charpter3;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class LotteryOdds {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("请输入中奖需要几位数字？");
        int k = in.nextInt();

        System.out.print("请输入中奖池中有多少个数字？");
        int n = in.nextInt();

        int lotteryOdds = 1;
        for (int i = 1; i <= k; i++) {
            lotteryOdds = lotteryOdds * (n - i + 1) / i;
        }
        System.out.println("中奖号码共有 "+ lotteryOdds +" 组，祝您好运！");
    }
}
