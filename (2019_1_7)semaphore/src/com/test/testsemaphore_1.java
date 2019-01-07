package com.test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在java中，提供了信号量Semaphore的支持。
 *
 *
 * Semaphore类是一个计数信号量，必须由获取它的线程释放，
 * 通常用于限制可以访问某些资源（物理或逻辑的）线程数目。
 *
 *
 * 一个信号量有且仅有3种操作，且它们全部是原子的：初始化、增加和减少
 * 增加可以为一个进程解除阻塞；
 * 减少可以让一个进程进入阻塞。
 *
 * --如果朋友您想转载本文章请注明转载地址"http://www.cnblogs.com/XHJT/p/3910406.html "谢谢--
 *
 * 信号量维护一个许可集，若有必要，会在获得许可之前阻塞每一个线程：
 *           //从此信号量获取给定数目的许可，在提供这些许可前一直将线程阻塞。
 *           acquireUninterruptibly(int permits){}
 * 每一个release()添加一个许可，从而可能释放一个正在阻塞的获取者。
 * Semaphore只对可用许可的号码进行计数，并采取相应的行动。
 *
 * 如何获得Semaphore对象？
 *     public Semaphore(int permits,boolean fair)
 *     permits:初始化可用的许可数目。
 *     fair: 若该信号量保证在征用时按FIFO的顺序授予许可，则为true，否则为false；
 *
 * 如何从信号量获得许可？
 *     public void acquire() throws InterruptedException
 *
 *
 *
 * 如何释放一个许可，并返回信号量？
 *     public void release()
 *代码实例：
 *     20个人去银行存款，但是该银行只有两个办公柜台，有空位则上去存钱，没有空位则只能去排队等待
 */
class Bank{
    static ReentrantLock lock = new ReentrantLock();
    private Integer account = 100;

    public Integer getAccount() {
        return account;
    }
//重入锁出现问题
    public void save(int money){
//        if(lock.tryLock()){
//            try{
//                lock.lock();
                account+=money;
//            }catch (Exception e){
//                e.printStackTrace();
//            }finally {
//                lock.unlock();
//            }
//        }
    }
}

class SaveThread implements Runnable{
    Random random = new Random();
    Bank bank;
    Semaphore semaphore;
    public SaveThread(Semaphore semaphore,Bank bank){
        this.semaphore = semaphore;
        this.bank = bank;
    }
    @Override
    public void run() {
        try {
            Thread.sleep((random.nextInt(10)+1)*1000);
            semaphore.acquire();
            bank.save(10);
            System.out.println(Thread.currentThread().getName()+"存入10,当前余额:"+bank.getAccount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }
}
public class testsemaphore_1 {
    final static int S = 2;

    public static void main(String[] args) {
        Bank bank = new Bank();
        Semaphore semaphore = new Semaphore(S);
        ExecutorService service = Executors.newFixedThreadPool(10);
        for(int i = 0 ;i < 10 ; i++){
            service.execute(new SaveThread(semaphore,bank));
        }
    }
}
