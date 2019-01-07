package com.school.test.test_01;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Binsiness {
    public static long start = System.currentTimeMillis();
    public static long end = 0;
    public static ReentrantLock lock = new ReentrantLock();
    private List list;

    Binsiness(List list){
        this.list = list;
    }

    public void read(){
        try{
                lock.lock();
                System.out.println(Thread.activeCount());
                System.out.print(Thread.currentThread().getName()+"读:");
                for(int i = 0 ; i< list.size();i++){
                    System.out.print(list.get(i));
                }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
            end = System.currentTimeMillis();
            getTime();
        }
    }

    public void write(){
        try{
            lock.lock();
            int i = new Random().nextInt(100);
            list.add(i);
            System.out.print(Thread.currentThread().getName()+"写:"+i);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
            end = System.currentTimeMillis();
            getTime();
        }

    }

    public static void getTime(){
        System.out.println("总共花费了："+(end-start));
    }

}
