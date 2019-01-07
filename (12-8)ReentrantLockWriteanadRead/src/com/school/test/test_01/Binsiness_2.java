package com.school.test.test_01;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Binsiness_2 {
    public static long start = System.currentTimeMillis();
    public static long end = 0;
    public static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public static Lock writeLock = lock.writeLock();
    public static Lock readLock = lock.readLock();
    private List list;

    Binsiness_2(List list){
        this.list = list;
    }

    public void read(){
        try{
            readLock.lock();
            System.out.println(Thread.activeCount());
            System.out.print(Thread.currentThread().getName()+"读:");
            for(int i = 0 ; i< list.size();i++){
                System.out.print(list.get(i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readLock.unlock();
            end = System.currentTimeMillis();
            getTime();
        }
    }

    public void write(){
        try{
            writeLock.lock();
            int i = new Random().nextInt(100);
            list.add(i);
            System.out.print(Thread.currentThread().getName()+"写:"+i);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            writeLock.unlock();
            end = System.currentTimeMillis();
            getTime();
        }

    }

    public static void getTime(){
        System.out.println("总共花费了："+(end-start));
    }
}
