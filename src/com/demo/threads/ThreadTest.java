package com.demo.threads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


public class ThreadTest {
    public static final int DELAY = 10;
    public static final int STEPS = 100;
    public static final double MAX_AMOUNT = 1000;

    public static void main(String args[]){
        Bank bank = new Bank(4,100000);

        //Thread.sleep方法指定线程休眠时间
        //线程执行顺序随机，起码该程序如此
        Runnable task1 = () ->
        {
            try{
                for (int i = 0; i < STEPS; i++){
                    double amount = Math.random()*MAX_AMOUNT;
                    bank.transfer(0,1,amount);
                    int x = (int)(DELAY*Math.random());
                    System.out.print("休眠时间："+x+" ");
                    Thread.sleep(x);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable task2 = () ->
        {
            try{
                for (int i = 0; i < STEPS; i++){
                    System.out.print("Task2 is running.");
                    double amount = Math.random()*MAX_AMOUNT;
                    bank.transfer(2,3,amount);
                    int x = (int)(DELAY*Math.random());
                    System.out.print("休眠时间："+x+" ");
                    Thread.sleep(x);
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        //new Thread(Runnable实例)，调用start()方法启动线程，从而调用run()方法
        new Thread(task1).start();
        new Thread(task2).start();
    }
}
