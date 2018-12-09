package com.school.test.test_01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test_01 {


    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<Integer>();
        init(list);
        //Binsiness_2 binsiness = new Binsiness_2(list);
        Binsiness binsiness = new Binsiness(list);
        //ExecutorService executor  = Executors.newFixedThreadPool(20);

        for(int i = 0 ; i<=10 ; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    binsiness.write();
                }
            }).start();
//            executor.execute(new Runnable() {
//                @Override
//                public void run() {
//
//                }
//            });
        }

        for(int i = 0 ; i<=2000 ; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    binsiness.read();
                }
            }).start();
//            executor.execute(new Runnable() {
//                @Override
//                public void run() {
//                    binsiness.read();
//                }
//            });
        }

    }

    public static void init(List list){
        for(int i = 0 ; i < 500 ; i++){
            list.add(i);
        }
    }
}
