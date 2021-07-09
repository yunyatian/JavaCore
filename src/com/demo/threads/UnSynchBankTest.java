package com.demo.threads;

/**
  *不安全的多线程方式
  *账户的资源会减少
 * 存在进程之间相互更改，覆灭其他进程进行的操作
 */
public class UnSynchBankTest {
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    public static void main(String args[]){
        Bank bank = new Bank(NACCOUNTS,INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++){
            int fromAccount = i;
            Runnable r = () ->
            {
                try{
                    while(true){
                        int toAccount = (int) (bank.size()* Math.random());
                        double amount = MAX_AMOUNT* Math.random();
                        /*
                        假设账户增加金额分为三步：
                        1.将account[to]加载到寄存器
                        2.增加amount
                        3.将结果写回account[to]
                        假设线程1执行了步骤1和2，然后他的运行权被抢占。此时第二个进程被唤醒，更新account数组中同一个元素。
                        然后第一个线程被唤醒执行第三步。这个动作会抹去第二个进程所做的操作，从而产生错误，总金额出现差错。
                         */
                        bank.transfer(fromAccount,toAccount,amount);
                        Thread.sleep((int)(DELAY* Math.random()));
                    }
                }catch(InterruptedException e){
                }
            };

            Runnable m = () ->
            {
                try{
                    while(true){
                        int toAccount = (int) (bank.size()* Math.random());
                        double amount = MAX_AMOUNT* Math.random();
                        bank.transfer(fromAccount,toAccount,amount);
                        Thread.sleep((int)(DELAY* Math.random()));
                    }
                }catch(InterruptedException e){
                }
            };
            Thread t = new Thread(r);
            Thread c = new Thread(m);
            t.start();
            c.start();
        }
    }
}
