package com.test;
/*
假如你突然想做饭，但是没有厨具，也没有食材。网上购买厨具比较方便，食材去超市买更放心。

实现分析：在快递员送厨具的期间，我们肯定不会闲着，可以去超市买食材。所以，在主线程里面另起一个子线程去网购厨具。

但是，子线程执行的结果是要返回厨具的，而run方法是没有返回值的。所以，这才是难点，需要好好考虑一下。
 */

import java.util.Random;

class OnlineShopping implements Runnable{
    volatile boolean isReady = false;
    volatile boolean externalIsReady = false;
    final Random random = new Random();
    public OnlineShopping(){
        System.out.println("快递已下达");
    }
    @Override
    public void run() {
        getUtensils();
        while(!isReady){
            try {
                Thread.sleep(1000);
                System.out.println("快递还在路上……");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        backUtensils();
        externalIsReady = isReady;
    }

    public void getUtensils(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep((random.nextInt(10)+1)*1000);
                    isReady = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void backUtensils(){
        System.out.println("厨具到位了");
    }
}
public class Test_Future_01 {

    static boolean footSignal = false;
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        OnlineShopping shopping = new OnlineShopping();
        Thread t1 = new Thread(shopping);

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!shopping.externalIsReady){
                }
                System.out.println("我已经收到了厨具到位了的信息");
                while(!footSignal){
                }
                System.out.println("准备炒菜了");
            }
        });
        t1.join();
        t2.join();
        t1.start();
        t2.start();
        System.out.println("起身去超市买食材");
        Thread.sleep(random.nextInt(5)*1000);
        System.out.println("食材到位了");
        footSignal = true;
    }
}
