package com.demo.charpter3;

import java.util.Arrays;

public class CompoundInterest {
    public static void main(String[] args) {
        final double STARTRATE = 10;
        final int NRATES = 6;
        final int NYEARS = 10;

        // 设置利率为10%-15%
        double[] interestRate = new double[NRATES];
        for (int i = 0; i < interestRate.length; i++) {
            interestRate[i] = (STARTRATE + i) / 100.0;
        }

        double[][] balances = new double[NYEARS][NRATES];

        // 设置初始资金为1000
        for (int i = 0; i < balances[0].length; i++) {
            balances[0][i] = 1000;
        }

        // 计算每年资金
        for (int i = 1; i < balances.length; i++) {
            for (int j = 0; j < balances[i].length; j++) {
                double oldBalances = balances[i-1][j];
                double balance = oldBalances + oldBalances * interestRate[j];
                balances[i][j] = balance;
            }
        }
        System.out.println(Arrays.toString(interestRate));
        System.out.println(Arrays.deepToString(balances));


    }
}
