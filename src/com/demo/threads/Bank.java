package com.demo.threads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Bank {
    private final double[] accounts;
    //添加ReentrantLock类，实现对共享资源上锁，在未解锁之前其他线程只等进行等待
    private ReentrantLock reentrantLock = new ReentrantLock();
    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    public void transfer(int from,int to,double amount){
        //在这里对于账户余额不足的情况下，我们不做任何操作，但这显然是不正确的，应当将线程挂起等余额充足时再执行操作
        reentrantLock.lock();
        try{
            if (accounts[from] < amount ){
                return;
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.print(String.format("%10.2f from %d to %d",amount,from,to));
            accounts[to] += amount;
            System.out.print(String.format(" Total Balance:%10.2f%n",getTotalBalance()));
        }finally {
            reentrantLock.unlock();
        }
    }

    private double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) {
            sum += a;
        }
        return sum;
    }

    public int size(){
        return accounts.length;
    }
}
