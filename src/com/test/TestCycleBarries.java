package com.test;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadBusiness implements Runnable{
    static Random random = new Random();
    CyclicBarrier cyclicBarrie;
    public ThreadBusiness(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrie = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+"正在写入数据...");
            cyclicBarrie.await();
            //Thread.sleep(random.nextInt(4000)+1000);
            System.out.println(Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
            cyclicBarrie.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("所有线程写入完毕，继续处理其他任务...");
    }
}
public class TestCycleBarries {
    final static int N = 10;
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                System.out.println("存活的线程数目:"+Thread.activeCount());
            }
        });
        ExecutorService executors = Executors.newFixedThreadPool(N);
        for(int i = 0 ; i < N; i++){
            executors.execute(new ThreadBusiness(cyclicBarrier));
        }
    }
}
