package com.demo.synch;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;
    private Lock  bankLock;
    private Condition sufficientFunds;

    public Bank(int n,double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
        //设置锁
        bankLock = new ReentrantLock();
        //设置条件
        sufficientFunds = bankLock.newCondition();
    }

    public void transfer(int from,int to,double amount) throws InterruptedException {

        bankLock.lock();
        try{
            while(accounts[from] < amount){
                //这里设置的await是为了当余额不足时将线程挂起，等待程序运行使得余额充足时，再次唤醒线程
                //调用await方法的线程和等待获得锁的线程存在本质的不同：
                //调用await方法的线程会进入这个条件的等待集，当锁可用时，该线程不会变为可运行状态。实际上，他仍然保持非活动状态，
                //直到另一个线程在同一条件下调用signalAll方法，
                //某一线程调用了await方法后，自身是没有办法进行重新激活的，只有等待另一进程调用signalAll方法。
                //如果所有线程都进入了挂起状态且没有线程调用signalAll方法，这将会导致死锁的产生。
                sufficientFunds.await();
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.print(String.format("%10.2f from %d to %d",amount,from,to));
            accounts[to] += amount;
            System.out.print(String.format(" Total Balance:%10.2f%n",getTotalBalance()));
            //signalAll方法会激活等待这个条件的所有线程。这下西安城会离开等待集，再次成为可运行状态。
            //同时他们会再次尝试进入该对象，所以他们会再一次的判断测试条件。
            //signalAll方法仅仅只是通知所有线程现在有可能满足条件了，但是并不能保证一定会满足条件。需要再次检查条件
            //除了signalAll方法还有signal方法可以接触线程挂起状态，
            // 但是signal只是随机选择等待的某一个线程解除其阻塞态。这种方法虽然更高效，但也存在危险，
            // 因为随机唤醒的某一个线程如果不能运行，那么又会进入阻塞态度，如果没有其他线程调用signal，那么系统会进入死锁。
            sufficientFunds.signalAll();
        } finally {
            bankLock.unlock();
        }
    }

    public double getTotalBalance() {
        bankLock.lock();
        try {
            double sum = 0;
//            for (int i = 0; i < accounts.length; i++) {
//                sum += accounts[i];
//            }
            for (double number:accounts) {
                sum +=number;
            }
            return sum;
        }finally {
            bankLock.unlock();
        }
    }
     public int size(){
        return accounts.length;
     }

}
