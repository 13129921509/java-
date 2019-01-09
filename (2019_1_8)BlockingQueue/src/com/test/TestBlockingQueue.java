package com.test;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;

class Consumer implements Runnable{
    Random random = new Random();
    BlockingQueue queue;
    Object value;
    public Consumer(BlockingQueue queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            while((value=queue.poll(2,TimeUnit.SECONDS))!=null){
                System.out.println(Thread.currentThread().getName()+"得到了:"+value);
                Thread.sleep((random.nextInt(5)+1)*1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Producer implements Runnable{
    BlockingQueue queue;
    Random random = new Random();
    Integer value;
    public Producer(BlockingQueue queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            while(queue.offer(value = random.nextInt(50),2,TimeUnit.SECONDS)){
                System.out.println(Thread.currentThread().getName()+"放进了"+value);
                Thread.sleep((random.nextInt(5)+1)*1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class TestBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(10);

        ExecutorService service = Executors.newFixedThreadPool(20);
        for(int i = 0 ; i < 10 ; i++){
            service.execute(new Consumer(queue));
        }
        for(int i = 0 ; i < 10 ; i++){
            service.execute(new Producer(queue));
        }
    }
}
