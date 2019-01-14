package com.test;

import java.util.concurrent.*;

/*
线程池会吃掉堆栈，能不能想办法，在异常的时候 打印出 提交任务的线程的堆栈？
 */
class Business implements Runnable{
    int a,b;
    public Business(int a,int b){
        this.a = a;
        this.b = b;
    }
    @Override
    public void run() {
        int i = a/b;
        System.out.println(i);
    }
}
public class Test_01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(0,Integer.MAX_VALUE,0L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
        for(int i = 0 ; i < 5 ;i ++){
            /*第一种方法*/
//            Future future = poolExecutor.submit(new Business(100,i));
//            future.get();
            /*第二种方法*/
            poolExecutor.execute(new Business(100,i));
        }
    }
}
