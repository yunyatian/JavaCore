package com.demo.synch2;

import java.util.Arrays;

public class Bank {
    private final double[] accounts;

    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
    }

    //使用synchronized关键字相当于上锁
    public synchronized  void transfer(int from,int to,double amount) throws InterruptedException {
            while(accounts[from] < amount){
                //wait与之前的await基本一致，将线程挂起
                wait();
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.print(String.format("%10.2f from %d to %d",amount,from,to));
            accounts[to] += amount;
            System.out.print(String.format(" Total Balance:%10.2f%n",getTotalBalance()));
            //唤醒所有被挂起的线程
            notifyAll();
    }

    public synchronized double getTotalBalance() {
        double sum = 0;
//        for (int i = 0; i < accounts.length; i++) {
//            sum += accounts[i];
//        }
        for (double number:accounts) {
            sum +=number;
        }
        return sum;
    }
     public int size(){
        return accounts.length;
     }

}
