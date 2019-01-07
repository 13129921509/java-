package com.school.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * ʹ��Lock �� Condition�������������������
 * @author tangzhijing
 *
 */
public class LockCondition {
        public static void main(String[] args) {
            Lock lock = new ReentrantLock();
            Condition producerCondition = lock.newCondition();
            Condition consumerCondition = lock.newCondition();
            Resource2 resource = new Resource2(lock,producerCondition,consumerCondition);
            
            //�������߳�
            ProducerThread2 producer1 = new ProducerThread2(resource);
            
            //�������߳�
            ConsumerThread2 consumer1 = new ConsumerThread2(resource);
            ConsumerThread2 consumer2 = new ConsumerThread2(resource);
            ConsumerThread2 consumer3 = new ConsumerThread2(resource);
            
            producer1.start();
            consumer1.start();
            consumer2.start();
            consumer3.start();
        }
}
/**
 * �������߳�
 */
class ConsumerThread2 extends Thread{
    private Resource2 resource;
    public ConsumerThread2(Resource2 resource){
        this.resource = resource;
        //setName("������");
    }
    public void run(){
        while(true){
            try {
                Thread.sleep((long) (1000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.remove();
        }
    }
}
/**
 * �������߳�
 * @author tangzhijing
 *
 */
class ProducerThread2 extends Thread{
    private Resource2 resource;
    public ProducerThread2(Resource2 resource){
        this.resource = resource;
        setName("������");
    }
    public void run(){
        while(true){
                try {
                    Thread.sleep((long) (1000 * Math.random()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                resource.add();
        }
    }
}
/**
 * ������Դ��
 * @author tangzhijing
 *
 */
class Resource2{
    private int num = 0;//��ǰ��Դ����
    private int size = 10;//��Դ���������ŵ���Դ��Ŀ
    private Lock lock;
    private Condition producerCondition;
    private Condition consumerCondition;
    public Resource2(Lock lock, Condition producerCondition, Condition consumerCondition) {
        this.lock = lock;
        this.producerCondition = producerCondition;
        this.consumerCondition = consumerCondition;
 
    }
    /**
     * ����Դ���������Դ
     */
    public void add(){
        lock.lock();
        try{
            if(num < size){
                num++;
                System.out.println(Thread.currentThread().getName() + 
                        "����һ����Դ,��ǰ��Դ����" + num + "��");
                //���ѵȴ���������
                consumerCondition.signalAll();
            }else{
                //���������̵߳ȴ�
                try {
                    producerCondition.await();
                    System.out.println(Thread.currentThread().getName() + "�߳̽���ȴ�");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }finally{
            lock.unlock();
        }
    }
    /**
     * ����Դ����ȡ����Դ
     */
    public void remove(){
        lock.lock();
        try{
            if(num > 0){
                num--;
                System.out.println("������" + Thread.currentThread().getName() 
                        + "����һ����Դ," + "��ǰ��Դ����" + num + "��");
                producerCondition.signalAll();//���ѵȴ���������
            }else{
                try {
                    consumerCondition.await();
                    System.out.println(Thread.currentThread().getName() + "�߳̽���ȴ�");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }//�������ߵȴ�
            }
        }finally{
            lock.unlock();
        }
    }
    
}