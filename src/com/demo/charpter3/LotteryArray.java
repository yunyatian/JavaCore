package com.demo.charpter3;

public class LotteryArray {
    /**
     * 计算乐透号码的概率
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        final int NMAX = 10; // 乐透号码的最大值

        int[][] odds = new int[NMAX+1][]; // 创建二维数组存储每个号码组合的概率
        for (int i = 0; i <= NMAX; i++) {
            odds[i] = new int[i +1]; // 初始化二维数组，每个子数组的长度为i+1
        }
        for (int i = 0; i < odds.length; i++) {
            for (int j = 0; j < odds[i].length; j++) {
                int lotteryOdds = 1; // 初始化乐透号码的概率为1
                for (int k = 1; k < j; k++) {
                    lotteryOdds = lotteryOdds * (i - k + 1) / k; // 根据组合数计算乐透号码的概率
                }
                odds[i][j] = lotteryOdds; // 将计算得到的概率存入二维数组中
            }
        }

        for (int[] row:odds) {
            for (int odd:row) {
                System.out.printf("%4d", odd); // 格式化输出每个概率
            }
            System.out.println(); // 换行输出
        }
    }

}
